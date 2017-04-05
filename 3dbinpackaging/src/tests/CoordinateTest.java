import com.bin.packaging.Coordinate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Tiebe on 5/04/2017.
 */
public class CoordinateTest {


    private Coordinate coord;
    @Before
    public void setUp() {
        coord = new Coordinate(1, 2, 3);
    }


    @Test
    public void Create_new_coordinate_with_valid_arguments(){


        Assert.assertEquals(1, coord.getCoordinate_x());
        Assert.assertEquals(2, coord.getCoordinate_y());
        Assert.assertEquals(3, coord.getCoordinate_z());
    }

    @Test
    public void Set_New_valid_x() {
        coord.setCoordinate_x(5);

        Assert.assertEquals(5, coord.getCoordinate_x());
    }

    @Test
    public void Set_New_valid_y() {
        coord.setCoordinate_y(5);

        Assert.assertEquals(5, coord.getCoordinate_y());
    }

    @Test
    public void Set_New_valid_z() {
        coord.setCoordinate_z(5);

        Assert.assertEquals(5, coord.getCoordinate_z());
    }
}
