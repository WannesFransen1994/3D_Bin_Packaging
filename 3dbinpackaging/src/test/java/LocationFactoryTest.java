import com.bin.packaging.Coordinate;
import com.bin.packaging.LocationFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by tiebe on 5/04/2017.
 */
public class LocationFactoryTest {


    @Test
    public void Create_New_location() {
        Coordinate coord = LocationFactory.createCoordinate(1, 2, 3);

        Assert.assertEquals(1, coord.getCoordinate_x());
        Assert.assertEquals(2, coord.getCoordinate_y());
        Assert.assertEquals(3, coord.getCoordinate_z());
    }
}
