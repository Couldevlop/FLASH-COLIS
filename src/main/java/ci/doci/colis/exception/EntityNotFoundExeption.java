package ci.doci.colis.exception;

public class EntityNotFoundExeption extends RuntimeException{
    public EntityNotFoundExeption() {
    }

    public EntityNotFoundExeption(String message) {
        super(message);
    }

    public EntityNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
