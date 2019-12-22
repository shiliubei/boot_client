package app.security;

import app.service.ClientUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private final SuccessHandler successHandler;
    private final ClientUserDetailsService userDetailsService;

    public SecurityConfig(SuccessHandler successHandler, ClientUserDetailsService userDetailsService) {
        this.successHandler = successHandler;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.userDetailsService(userDetailsService);
        http
                .authorizeRequests()
                .antMatchers("/login")
                .anonymous()
//                .antMatchers("/user")
//                .hasRole("USER")
//                .antMatchers("/admin/**")
//                .hasRole("ADMIN")
                .anyRequest()
//                .authenticated()
                .anonymous()
                .and()
                .formLogin()
                .loginPage("/login") //custom login page
                .successHandler(successHandler)
        ;
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailsService;
    }

}