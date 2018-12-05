package avaj.simulation;

import avaj.exceptions.FlyableAlreadyRegisteredException;
import avaj.exceptions.FlyableNotFoundException;
import avaj.flyable.Flyable;

import java.util.concurrent.CopyOnWriteArrayList;

public class Tower {
    private CopyOnWriteArrayList<Flyable> observers = new CopyOnWriteArrayList<>();

    private boolean existsInObservers(Flyable flyable){
        for (Flyable fly : this.observers){
            if (fly == flyable) {
                return true;
            }
        }
        return false;
    }

    public void register(Flyable flyable){
        if (existsInObservers(flyable)){
            throw new FlyableAlreadyRegisteredException();
        }

        observers.add(flyable);
        System.out.println(composeMessage(flyable, "registered"));
    }

    public void unregister(Flyable flyable){
        if (!observers.remove(flyable)){
            throw new FlyableNotFoundException();
        }

        System.out.println(composeMessage(flyable, "unregistered"));
    }

    protected void conditionsChanged(){
        for (Flyable flyable : this.observers) {
            flyable.updateConditions();

            if (flyable.getHeight() == 0){
                try {
                    this.unregister(flyable);
                }
                catch (FlyableNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private String composeMessage(Flyable flyable, String regYN) {
        return "Tower says : " + flyable.getClass().getSimpleName() + "#" + flyable.getName() + "(" + flyable.getId() + ") " + regYN + " to weather tower";
    }

    public CopyOnWriteArrayList<Flyable> getObservers() {
        return observers;
    }
}
