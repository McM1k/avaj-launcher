package avaj.flyable;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId(){
        return idCounter ++;
    }

    protected String composeMessage(String type, String msg) {
        return type + "#" + this.name + "(" + this.id + ") : " + msg;
    }
}
