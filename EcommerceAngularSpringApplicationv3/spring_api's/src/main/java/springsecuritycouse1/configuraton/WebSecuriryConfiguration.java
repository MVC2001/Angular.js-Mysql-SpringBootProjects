package springsecuritycouse1.configuraton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import springsecuritycouse1.filters.JwtRequestFilters;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecuriryConfiguration {


    private  final JwtRequestFilters jwtRequestFilters;

    @Autowired
    public WebSecuriryConfiguration(JwtRequestFilters jwtRequestFilters) {
        this.jwtRequestFilters = jwtRequestFilters;
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers( "/signup","/api/inventory","/api/inventories","/api/inventory/{id}","/api2/priceUpdate","/api2/priceUpdate/{id}","/api2/priceUpdates","/api3/newInfo","/api3/newInfo/{id}","/api3/news","/api4/shops/item","/api4/shops/items","/api4/shops/item-with-image","/api4/shops/item/{id}","/api5/soldOut","/api5/cart","/api5/cart/{id}","/api5/carts","/api6/vendor","/api6/vendor/{id}","/api6/vendors","/api8/opinion/comment","/api8/opinion/comment/{id}","/api8/opinion/comments","/api1/product","/login","/api/test").permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/api/hello/**").authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtRequestFilters, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


    // Password Encoding
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}
