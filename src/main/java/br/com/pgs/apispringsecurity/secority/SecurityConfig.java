package br.com.pgs.apispringsecurity.secority;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfiguration{
	 @Bean
	    public AuthencationTokenFilter getTokenFilter() {
	        return new AuthencationTokenFilter();
	    }

	    protected void configure(HttpSecurity http) throws Exception {
	        http.cors().and().csrf().disable();
	        http.authorizeRequests().anyRequest().authenticated();
	        http.addFilterBefore(getTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	    }

}
