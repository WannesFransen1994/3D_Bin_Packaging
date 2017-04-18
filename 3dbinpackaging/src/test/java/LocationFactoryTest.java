import com.bin.packaging.Model.Coordinate;
import com.bin.packaging.Model.LocationFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by tiebe on 5/04/2017.
 */
public class LocationFactoryTest {


    @Test
    public void createLocationTest() {
        Coordinate coord = LocationFactory.createCoordinate(1, 2, 3);

        Assert.assertEquals(1, coord.getCoordinate_x());
        Assert.assertEquals(2, coord.getCoordinate_y());
        Assert.assertEquals(3, coord.getCoordinate_z());
    }

    @Test (expected = IllegalArgumentException.class)
    public void create_location_with_invalid_x_argument() {
        Coordinate coord = LocationFactory.createCoordinate(-1, 2, 3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void create_location_with_invalid_y_argument() {
        Coordinate coord = LocationFactory.createCoordinate(1, -2, 3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void create_location_with_invalid_z_argument() {
        Coordinate coord = LocationFactory.createCoordinate(1, 2, -3);
    }
}
