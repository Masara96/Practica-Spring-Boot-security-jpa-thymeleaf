package com.practica.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.practica.springboot.app.auth.handler.LoginSuccessHandler;
import com.practica.springboot.app.models.service.JpaUserDetailsService;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests().antMatchers("/","/css/**","/js/**","/images/**","/listar").permitAll()
		 .antMatchers("/ver").hasAnyRole("USER")
		 .antMatchers("/uploads/**").hasAnyRole("USER")
		 .antMatchers("/form/**").hasAnyRole("ADMIN")
		 .antMatchers("/eliminar/**").hasAnyRole("ADMIN")
		 .antMatchers("/factura/**").hasAnyRole("ADMIN")
		 .anyRequest().authenticated()
		 .and().formLogin()
		       .successHandler(successHandler)
		 .loginPage("/login")
		 .permitAll()
		 .and().logout().permitAll()
		 .and()
		 .exceptionHandling().accessDeniedPage("/error_403");
	}

	@Autowired
	protected void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {
		
		PasswordEncoder encoder = passwordEncoder();
		
//		UserBuilder users = User.builder().passwordEncoder(password ->{ 
//			return encoder.encode(password);
//		});
//		
//		builder.inMemoryAuthentication()
//		.withUser(users.username("admin").password("12345").roles("ADMIN","USER"))
//		.withUser(users.username("martin").password("12345").roles("USER"));
		
		builder.userDetailsService(userDetailsService)
		.passwordEncoder(encoder);
	}


	
	 

}
