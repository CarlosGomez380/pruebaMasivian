package prueba.persistence;
public class RouletteException extends Exception {
    public RouletteException(String message) {
        super(message);
    }
    public RouletteException(String message, Throwable cause) {
        super(message, cause);
    }
}
