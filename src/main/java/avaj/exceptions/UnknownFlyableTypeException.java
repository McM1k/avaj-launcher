package avaj.exceptions;

public class UnknownFlyableTypeException extends RuntimeException {
    public UnknownFlyableTypeException() {
        super("wrong flyable type");
    }
}
