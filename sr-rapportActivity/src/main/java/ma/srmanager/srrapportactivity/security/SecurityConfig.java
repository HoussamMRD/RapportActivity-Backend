package ma.srmanager.srrapportactivity.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Desactiver l'Authentification par defaut de spring
        //super.configure(http);

        //desactiver le token csrf
        http.csrf().disable();

        //Desactiver les sessions
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.headers().frameOptions().disable();

        //Gerer les Autorisations par role
        http.authorizeRequests().
                antMatchers("/h2-console/**","/refreshToken/**","/login/**",
                        "/v3/api-docs","/swagger-ui.html","/api/command/**","/api/query/**").permitAll();

        //http.authorizeRequests().antMatchers(HttpMethod.POST,"/users/**").hasAuthority("ADMIN");
        //http.authorizeRequests().antMatchers(HttpMethod.GET,"/users/**").hasAuthority("USER");

        //Autoriser tout le restes des requetes aux utilisateurs authentifiés
        http.authorizeRequests().anyRequest().authenticated();

        //Ajouter un filtre
        http.addFilterBefore(new JWTAuthorizationfilter(), UsernamePasswordAuthenticationFilter.class);

    }


   // @Bean
   /* public BCryptPasswordEncoder getBcpe(){
        return new BCryptPasswordEncoder();
    }*/


}
