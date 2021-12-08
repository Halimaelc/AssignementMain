package Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	       auth.inMemoryAuthentication()
           .withUser("user").password("password").roles("USER").and()
           .withUser("admin").password("password").roles("USER","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http.authorizeRequests()
         .antMatchers("/auth").permitAll()
         .antMatchers("/").permitAll()
         .antMatchers("/program/").access("hasRole(ROLE_USER')")
         .antMatchers("/admin").access("hasRole(ROLE_ADMIN')")
         .anyRequest().permitAll();
      
    }

}
