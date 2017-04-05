import com.bin.packaging.Container;
import com.bin.packaging.Coordinate;
import com.bin.packaging.LocationFactory;
import com.bin.packaging.Subspace;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by tiebevn on 5/04/2017.
 */
public class SubspaceTest {

    private Coordinate coord;
    private Container cont;
    private Subspace sub;

    @Before
    public void setUp() {

        cont = new Container(1, 2, 3);
    }

    @Test
    public void Create_new_valid_subspace_by_size_and_coordinate() {
        coord = new Coordinate(0, 0, 0);
        sub = new Subspace(coord, 1, 2, 3);

        Assert.assertEquals(coord, sub.getCoordinate());
        Assert.assertEquals(1, sub.getLength());
        Assert.assertEquals(2, sub.getWidth());
        Assert.assertEquals(3, sub.getHeight());
    }

    @Test
    public void Create_new_container_subspace() {

        sub = new Subspace(cont);

        Assert.assertEquals(new Coordinate(0, 0, 0), sub.getCoordinate());
        Assert.assertEquals(1, sub.getLength());
        Assert.assertEquals(2, sub.getWidth());
        Assert.assertEquals(3, sub.getHeight());


    }

}
