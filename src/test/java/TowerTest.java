import static org.junit.Assert.*;
import org.junit.*;

public class TowerTest {

    @Test
    public void registerTest(){
        Tower tower = new Tower();
        Helicopter helicopter = new Helicopter();

        tower.register(helicopter);
        assertEquals(helicopter, tower.observer.at(0), "helicopter should have been added");
        assertEquals(1, tower.observer.length(), "there should be one entry, for the helicopter");
    }

    @Test
    public void unregisterTest(){
        Tower tower = new Tower();
        Helicopter helicopter = new Helicopter();

        tower.register(helicopter);
        tower.unregister(helicopter);
        assertEquals(0, tower.observer.length(), "there should not be any entry, as the heicopter should have been unregistered");
    }

    @Test
    public void conditionsChangedTest() {
        //???
    }
}
