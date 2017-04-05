import com.bin.packaging.Coordinate;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Tiebe on 5/04/2017.
 */
public class CoordinateTest {

    @Test
    public void Create_new_coordinate_with_valid_arguments(){
        Coordinate coord = new Coordinate(1, 2, 3);

        Assert.assertEquals(1, coord.getCoordinate_x());
        Assert.assertEquals(2, coord.getCoordinate_y());
        Assert.assertEquals(3, coord.getCoordinate_z());
    }
}
