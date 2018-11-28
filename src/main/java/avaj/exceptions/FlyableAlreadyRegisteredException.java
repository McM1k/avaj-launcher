package avaj.exceptions;

public class FlyableAlreadyRegisteredException extends RuntimeException {
    public FlyableAlreadyRegisteredException() {
        super("This flyable is already registered");
    }
}
