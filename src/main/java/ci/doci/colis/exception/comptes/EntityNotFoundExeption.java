package ci.doci.colis.exception.comptes;

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
