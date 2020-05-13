package com.nusacamp.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nusacamp.app.jwt.JWTAuthorizationFilter;
import com.nusacamp.app.jwt.JwtTokenProvider;
import com.nusacamp.app.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and()
			.authorizeRequests()
				.antMatchers("/api/v1/**").permitAll()
				.antMatchers("/api/v1/registration").permitAll()
				.antMatchers("/api/v1/admin/**").hasRole("ADMIN")
				.anyRequest().fullyAuthenticated()
				.and()
				.httpBasic()
				.and()
				.csrf().disable()
			.formLogin()
				.loginPage("/api/v1/login").failureUrl("/api/v1/login?error=true")
				.usernameParameter("user_name")
				.passwordParameter("password")
				.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/api/v1/user/logout", "POST"))
				.logoutSuccessUrl("/api/v1/login").and().exceptionHandling()
				.accessDeniedPage("/access-denied");
		
		//jwt filtering
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtTokenProvider));
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring()
			.antMatchers("/resources/**", "/templates/**","/static/**", "/css/**", "/js/**", "/image/**");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	// Cross origin resource sharing
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("https://scm-covid19id-webapp.herokuapp.com").allowedMethods("*");
			}
		};
	}
}
