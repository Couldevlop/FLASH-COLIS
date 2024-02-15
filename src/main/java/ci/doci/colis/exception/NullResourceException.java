package ci.doci.colis.exception;


public class NullResourceException extends RuntimeException{
    public NullResourceException() {
    }

    public NullResourceException(String message) {
        super(message);
    }

    public NullResourceException(String message, Throwable cause) {
        super(message, cause);
    }
}
