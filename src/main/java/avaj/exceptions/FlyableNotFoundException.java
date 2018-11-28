package avaj.exceptions;

public class FlyableNotFoundException extends RuntimeException {
    public FlyableNotFoundException() {
        super("avaj.flyable.Flyable isn't registered");
    }
}
