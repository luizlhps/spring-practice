package springcurso.curso.services.exceptions;

import java.io.Serial;

public class ResourceNotFound extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFound(Object id) {
        super("Resource not found. id:" + id);
    }

}
