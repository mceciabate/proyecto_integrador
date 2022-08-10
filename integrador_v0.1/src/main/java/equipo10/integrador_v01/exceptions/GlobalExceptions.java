package equipo10.integrador_v01.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptions {
    final static Logger log = Logger.getLogger(GlobalExceptions.class);


    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> procesarResourceNotFound(ResourceNotFoundException ex) {
        ApiException apiException = new ApiException(ex.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now(ZoneId.of("Z")));
        log.error("Error " + ex);
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({ResourceCreateException.class, Exception.class})
    public ResponseEntity<Object> procesarErrorCreateResourse(Exception ex) {
        ApiException apiException = new ApiException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, ZonedDateTime.now(ZoneId.of("Z")));
        log.error("Error " + ex);
        return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> procesarBadRequestError(Exception ex) {
        ApiException apiException = new ApiException(ex.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));
        log.error("Error "+ ex);
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

}
