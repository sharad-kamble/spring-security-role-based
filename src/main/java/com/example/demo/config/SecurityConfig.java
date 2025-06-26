package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	//SecurityFilterChain -
	// Each and every request which is coming to our application will get
	// intercepted by this filter and here we are apply that security
	// When any request (e.g. /admin, /user) comes to your website, he request first
	// passes through the SecurityFilterChain. This chain contains several security
	// filters – which check passwords, authentication, authorization, etc.Then the
	// request is forwarded or stopped (if it is an unauthorized request).

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		httpSecurity
		// Allow only users with ADMIN role to access "/admin" endpoint
				.authorizeHttpRequests(auth -> auth.requestMatchers("/admin")
				.hasRole("ADMIN").anyRequest().authenticated())
				.formLogin(form -> form.permitAll()) // Enable default login form and allow everyone to access it
				.logout(logout -> logout.permitAll())// Allow everyone to access logout URL
		.exceptionHandling(ex -> ex.accessDeniedPage("/error/403")); // handle 403

		return httpSecurity.build(); // return the implemetation of SecurityFilterChain
	}

	// This method creates and returns users with their roles (in-memory storage)
	@Bean
	public UserDetailsService userDetailsService() {
		// Creating a user with username "sharad" and role "USER"
		UserDetails user = User.builder()
				.username("sharad")
				.password(passwordEncoder().encode("123")).roles("USER") // Password is encrypted
				.build();
		// Creating an admin with username "admin" and role "ADMIN"
		UserDetails admin = User.builder()
				.username("admin")
				.password(passwordEncoder().encode("admin")).roles("ADMIN") // Password is encrypted
				.build();


		// Store both users in memory and return
		return new InMemoryUserDetailsManager(user, admin);

	}


	// This method defines the password encryption strategy (BCrypt)
	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

}
