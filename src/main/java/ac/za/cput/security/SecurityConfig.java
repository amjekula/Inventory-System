package ac.za.cput.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String CLERK_ROLE = "CLERK";
//    private static final String ADMIN_ROLE = "ADMIN";


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("first").password("{noop}1234").roles(CLERK_ROLE);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.POST, "**/read").hasRole(CLERK_ROLE)
                                                                                                         .antMatchers(HttpMethod.GET, "**/read/**").hasRole(CLERK_ROLE)
                                                                                                         .and()
                                                                                                         .csrf().disable()
                                                                                                         .formLogin().disable();

    }
}
