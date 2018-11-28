import avaj.flyable.Coordinates;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinatesTest {
    Coordinates coordinates;

    @Before
    public void before(){
        coordinates = new Coordinates(123,456,789);
    }

    @Test
    public void getttersTest(){
        assertEquals(123, coordinates.getLongitude());
        assertEquals(456, coordinates.getLatitude());
        assertEquals(789,coordinates.getHeight());
    }
}
