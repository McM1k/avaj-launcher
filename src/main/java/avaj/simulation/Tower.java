package avaj.simulation;

import avaj.exceptions.FlyableAlreadyRegisteredException;
import avaj.exceptions.FlyableNotFoundException;
import avaj.flyable.Flyable;

import java.util.LinkedList;

public class Tower {
    private LinkedList<Flyable> observers = new LinkedList<>();

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
    }

    public void unregister(Flyable flyable){
        if (!observers.remove(flyable)){
            throw new FlyableNotFoundException();
        }
    }

    protected void conditionsChanged(){
        for (Flyable flyable : this.observers){
            flyable.updateConditions();
        }
    }

    public LinkedList<Flyable> getObservers() {
        return observers;
    }
}
