package yehor.zapara.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import yehor.zapara.spring.model.Role;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers(HttpMethod.GET,
                        "/cinema-halls", "/movies",
                        "/movie-sessions/**")
                .hasAnyRole(Role.RoleName.ADMIN.name(), Role.RoleName.USER.name())
                .antMatchers(HttpMethod.POST,"/cinema-halls", "/movies",
                        "/movie-sessions/**")
                .hasRole(Role.RoleName.ADMIN.name())
                .antMatchers(HttpMethod.PUT,"/movie-sessions/{id}")
                .hasRole(Role.RoleName.ADMIN.name())
                .antMatchers(HttpMethod.DELETE,"/movie-sessions/{id}")
                .hasRole(Role.RoleName.ADMIN.name())
                .antMatchers("/orders/**", "/shopping-carts/**")
                .hasRole(Role.RoleName.USER.name())
                .antMatchers("/users/by-email").hasRole(Role.RoleName.ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
