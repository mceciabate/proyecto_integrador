package equipo10.integrador_v01.config.security;

import equipo10.integrador_v01.config.security.jwt.JwtEntryPointConfig;
import equipo10.integrador_v01.config.security.jwt.JwtTokenFilterConfig;
import equipo10.integrador_v01.service.jwt.UsuarioDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Autowired
    UsuarioDetailsService usuarioDetailsService;
    @Autowired
    JwtEntryPointConfig jwtEntryPointConfig;

    @Bean
    public JwtTokenFilterConfig jwtTokenFilter() {
        return new JwtTokenFilterConfig();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean("authenticationManager")
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /*
     * Registro de los endpoints, definiendo quien tiene acceso a cada uno
     */

    @Primary
    @Bean
    protected HttpSecurity configure(HttpSecurity http) throws Exception {


        http.csrf().disable()
                .authorizeRequests()

                .antMatchers(HttpMethod.POST, "/auth/**", "/usuario/**").permitAll()

                .antMatchers(HttpMethod.GET, "/producto/**", "/categoria/**"
                        , "/ciudad/**", "/usuario/listar", "/usuario/email", "usuario/{id}", "/rol/**").permitAll()

                .antMatchers(HttpMethod.POST, "/producto/**", "/categoria/**"
                        , "/ciudad/**", "/rol/**").hasAnyAuthority("ADMINISTRADOR")

                .antMatchers(HttpMethod.PUT, "/producto/**", "/categoria/**"
                        , "/ciudad/**", "/rol/**", "/usuario/**").hasAnyAuthority("ADMINISTRADOR")

                .antMatchers(HttpMethod.DELETE, "/producto/**", "/categoria/**"
                        , "/ciudad/**", "/rol/**", "/usuario/**").hasAnyAuthority("ADMINISTRADOR")

                //.antMatchers(HttpMethod.GET, "/rol/**", "/usuario/**").hasAnyAuthority("ADMINISTRADOR")

                .antMatchers(HttpMethod.POST, "/reserva/**").hasAuthority("USUARIO")

                .and()

                .exceptionHandling().authenticationEntryPoint(jwtEntryPointConfig)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return  http;
    }

    /*
     * Registro de cors origin para el libre consumo de los endpoints desde el front
     */

    // http://18.223.117.95:8080/**, http://localhost:3000/**

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOriginPatterns(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
        UrlBasedCorsConfigurationSource cors = new UrlBasedCorsConfigurationSource();
        cors.registerCorsConfiguration("/**", config);
        return cors;
    }

    /**
     * Registro los filtros configurados anteriormente para que sea un filter implementado por sprinb
     * de esta manera uso e implemento el registro y apertura de los cors
     */
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
