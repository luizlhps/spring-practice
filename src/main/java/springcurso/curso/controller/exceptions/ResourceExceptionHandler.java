package springcurso.curso.controller.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import springcurso.curso.services.exceptions.DatabaseException;
import springcurso.curso.services.exceptions.ResourceNotFound;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFound e, HttpServletRequest request){
    String error = "Resource not found";
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

    return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> databaseException(DatabaseException e, HttpServletRequest request){
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
