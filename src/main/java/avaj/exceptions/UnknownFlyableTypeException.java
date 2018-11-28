package avaj.exceptions;

public class UnknownFlyableTypeException extends Throwable {
    public UnknownFlyableTypeException() {
        super("wrong flyable type");
    }
}
