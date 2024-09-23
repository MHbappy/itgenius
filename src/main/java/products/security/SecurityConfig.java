package products.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Use of userDetails in order to generate our own custom repo of users
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Configuration of access to endpoints
        http.authorizeRequests()
//            .antMatchers("/actuator/loggers","/actuator/metrics" ).access("hasRole('USER')")
                .antMatchers("/").permitAll()
//            .antMatchers("/**").access("hasRole('USER')")
//            .antMatchers("/", "/**", "*/health").access("permitAll")

            .and()
            .formLogin()
            .loginPage("/login")

            .and()
            .logout()
            .logoutSuccessUrl("/")

            .and()
            .csrf()
//            .ignoringAntMatchers("/h2/**")
            .and()
            .headers()
            .frameOptions()
            .sameOrigin()
        ;
    }
}
