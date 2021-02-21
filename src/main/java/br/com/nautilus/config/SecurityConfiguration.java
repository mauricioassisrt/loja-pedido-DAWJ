package br.com.nautilus.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**").antMatchers("/js/**").antMatchers("/plugins/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery(
						"SELECT login AS username, senha AS password, 1 AS enable FROM usuario WHERE login=?")
				.authoritiesByUsernameQuery(
						"SELECT usuario.login AS username, papel.nome AS authority FROM permisao INNER JOIN usuario ON permisao.usuario_id=usuario.id INNER JOIN papel ON permisao.papel_id=1 WHERE usuario.login=?")
				.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.headers().frameOptions().sameOrigin()
			.and()
			
			.authorizeRequests()
			.antMatchers("/**").hasAnyAuthority("ADM")
			.and()
		
			.formLogin().loginPage("/login").permitAll().and()
			.logout().logoutUrl("/logout").permitAll();
	}
}
