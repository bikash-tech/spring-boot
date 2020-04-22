package com.example.security;

import static com.example.security.ApplicationUserRole.ADMIN;
import static com.example.security.ApplicationUserRole.ADMIN_TRAINEE;
import static com.example.security.ApplicationUserRole.STUDENT;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserDetailsService userDetailsService;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        UserDetails bikashUser = User.builder()
                .username("bikash")
                .password(passwordEncoder.encode("1234"))
                .authorities(STUDENT.getGrantedAuthorities())
                .build();

        UserDetails jamesUser = User.builder()
                .username("james")
                .password(passwordEncoder.encode("james"))
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        UserDetails tomUser = User.builder()
                .username("tom")
                .password(passwordEncoder.encode("tom"))
                .authorities(ADMIN_TRAINEE.getGrantedAuthorities())
                .build();
        return new InMemoryUserDetailsManager(bikashUser, jamesUser, tomUser);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
	                .loginPage("/login")
	                .permitAll()
	                .defaultSuccessUrl("/courses", true)
	                .usernameParameter("uname")
	                .passwordParameter("pass")
                .and()
                .rememberMe().userDetailsService(userDetailsService)
	                .tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21))
	                .key("somethingverysecure") // By default 2 weeks validity
	                .rememberMeParameter("remember")
	            .and()
	            .logout()
	            	.logoutUrl("/logout")
	            	// we can delete when CSRF will be disable
	            	.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")) 
	            	.invalidateHttpSession(true)
	            	.clearAuthentication(true)
	            	.deleteCookies("JSESSIONID","remember-me") // name are taken from cookie
	            	.logoutSuccessUrl("/login");
    }
}
