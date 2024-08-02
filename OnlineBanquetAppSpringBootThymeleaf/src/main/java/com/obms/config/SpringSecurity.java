package com.obms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/register/**","/saveOrder/**","/savePayment/**","/saveInjuries/**","/about/index/**","/about/saveAboutPost/**","/service/servicePage/**","/serviceHome/**","/service/addPost/**").permitAll()
                                .requestMatchers(
                                        "/about-us/**",
                                        "/service/servicePage/**",
                                        "/serviceHome/**",
                                        "/hallPage/**",
                                        "/include/assets/css/**",
                                        "/include/assets/img" + "/**",
                                        "/include/assets/js/**",
                                        "/images/**",
                                        "/include/assets/plugins/**",
                                        "/asset/css/**", "/js/**",
                                        "/css/**","/assets/webfonts/**",
                                        "/assets/js/**",
                                        "/assets/images/**",
                                        "/assets/css/**",
                                        "/images/**"
                                        ,"/OrderEdit/**",
                                        "/about/PostAboutEditForm/**",
                                        "/PaymentEdit/**",
                                        "/service/PostEditForm/**",
                                        "/InjuryEdit/**",
                                        "/deleteOrder/**",
                                        "/deletePayment/**",
                                        "/deleteInjury/**",
                                        "/deletePost/**",
                                        "/deleteServicePost/**"
                                        ).permitAll()
                                .requestMatchers("/users","/index","/bookingAccount","/paymentAccount","/injuryAccount","/OrderEdit","/InjuryEdit","/PaymentEdit","/saveOrder","/savePayment","/saveInjuries","about/index","/saveAboutPost","/about/PostAboutEditForm","/service/PostEditForm","/service/servicePage","/service/addPost","/serviceHome").hasRole("ADMIN")
                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/users")
                                .defaultSuccessUrl("/index")
                                .defaultSuccessUrl("/OrderEdit")
                                .defaultSuccessUrl("/InjuryEdit")
                                .defaultSuccessUrl("/about/PostAboutEditForm/")
                                .defaultSuccessUrl("/service/PostEditForm/")
                                .defaultSuccessUrl("/PaymentEdit")
                                .defaultSuccessUrl("/saveOrder")
                                .defaultSuccessUrl("/savePayment")
                                .defaultSuccessUrl("/saveInjuries")
                                .defaultSuccessUrl("/service/addPost")

                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
