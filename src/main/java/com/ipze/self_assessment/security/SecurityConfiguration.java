package com.ipze.self_assessment.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableScheduling
@EnableWebSecurity
public class SecurityConfiguration {

    @Value("${app.cors.allowed_origins}")
    private String[] corsAllowedOrigins;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }

	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.headers()
			.frameOptions()
			.sameOrigin()
			*//*.and().cors()*//*
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().csrf().disable()
			.formLogin().disable()
			.httpBasic().disable()
			.authorizeRequests()
			.antMatchers("/auth/**", "/oauth2/**", "/ws-packet/**", "/**").permitAll()
			.antMatchers("/swagger-ui/**").permitAll()
			.antMatchers(HttpMethod.GET, "/ws-packet/**").permitAll()
			.anyRequest().authenticated()
			.and();
	}*/

	/* @Bean
	CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		for (String allowedOrigin : corsAllowedOrigins) {
			config.addAllowedOrigin(allowedOrigin);
		}
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		config.addAllowedOriginPattern("*");
		source.registerCorsConfiguration("/**", config);
		return source;
	}*/
}

