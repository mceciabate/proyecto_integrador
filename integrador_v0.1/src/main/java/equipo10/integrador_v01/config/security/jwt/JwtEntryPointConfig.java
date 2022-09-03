package equipo10.integrador_v01.config.security.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
@Slf4j
public class JwtEntryPointConfig implements AuthenticationEntryPoint {

    /*
     * Si hay error en autenticación y generación de token (pasos previos)
     * genera un estado 401 no autorizado
    */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response
            , AuthenticationException authException) throws IOException{
        log.error("Fallo en autenticación");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");
    }
}
