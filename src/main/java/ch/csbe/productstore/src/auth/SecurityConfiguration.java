package ch.csbe.productstore.src.auth;

import io.swagger.v3.oas.models.PathItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {
    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        http.csrf().disable();
        http
                .httpBasic().disable()
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers(HttpMethod.POST, "/users/signin").permitAll()
                        .requestMatchers(HttpMethod.POST, "/users/signup").permitAll()
                        .requestMatchers("/swagger-ui/index.html").permitAll()
                        .requestMatchers("/swagger-ui/*").permitAll()
                        .requestMatchers("/v3/api-docs").permitAll()
                        .requestMatchers(HttpMethod.GET, "/categories").permitAll()
                        .requestMatchers(HttpMethod.GET, "/categories/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/products/category/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/products").permitAll()
                        .requestMatchers(HttpMethod.GET, "/products/{id}").permitAll()
                        .requestMatchers("/v3/api-docs/swagger-config").permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }

    //.anyRequest().authenticated()

}
