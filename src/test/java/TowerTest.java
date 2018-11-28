import static org.junit.Assert.*;

import avaj.flyable.Coordinates;
import avaj.flyable.Helicopter;
import avaj.simulation.Tower;
import avaj.exceptions.FlyableAlreadyRegisteredException;
import avaj.exceptions.FlyableNotFoundException;
import org.junit.*;

public class TowerTest {
    private Tower tower;
    private Helicopter helicopter;
    private Coordinates coordinates;

    @Before
    public void before() {
        tower = new Tower();
        coordinates = new Coordinates(1,2,3);
        helicopter = new Helicopter("name", coordinates);
    }

    @Test
    public void registerTest(){
        tower.register(helicopter);
        assertEquals(helicopter, tower.getObservers().get(0));
        assertEquals(1, tower.getObservers().size());
    }

    @Test
    public void unregisterTest(){
        tower.register(helicopter);
        tower.unregister(helicopter);
        assertEquals(0, tower.getObservers().size());
    }

    @Test(expected = FlyableNotFoundException.class)
    public void unregisterUnexistingFlyable(){
        tower.unregister(helicopter);
    }

    @Test(expected = FlyableAlreadyRegisteredException.class)
    public void registerAlreadyExisting(){
        tower.register(helicopter);
        tower.register(helicopter);
    }

    @
}
