package com.example.secureApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
//@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}

	
	//Authentication using custom login page
	@Override
	protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(requests -> requests.antMatchers("/login").permitAll())
                .authorizeRequests(requests -> requests.antMatchers("/home").hasAnyRole("USER", "ADMIN"))
                .formLogin(login -> {
					try {
						login
						        .loginPage("/login").defaultSuccessUrl("/").permitAll().and().rememberMe();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				})
                .logout(logout -> logout.invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/logout-success").permitAll());
	}
	
	
	//Google Authentication
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http
//		.csrf().disable()
//		.authorizeRequests().antMatchers("/login").permitAll()
//		.anyRequest().authenticated();
//	}
	
	
}
