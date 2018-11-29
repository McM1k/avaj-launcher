package avaj.simulation;

import avaj.exceptions.FlyableAlreadyRegisteredException;
import avaj.exceptions.FlyableNotFoundException;
import avaj.flyable.Flyable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();

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
        Iterator<Flyable> it = observers.iterator();
        while (it.hasNext()){
            Flyable flyable = it.next();
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

    public ArrayList<Flyable> getObservers() {
        return observers;
    }
}
