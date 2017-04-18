import com.bin.packaging.Model.Container;
import com.bin.packaging.Model.Coordinate;
import com.bin.packaging.Model.Subspace;
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
        coord = new Coordinate(0, 0, 0);
    }

    @Test
    public void valueConstructorTest() {

        sub = new Subspace(coord, 1, 2, 3);

        Assert.assertEquals(coord, sub.getCoordinate());
        Assert.assertEquals(1, sub.getLength());
        Assert.assertEquals(2, sub.getWidth());
        Assert.assertEquals(3, sub.getHeight());
    }

    @Test
    public void containerConstructorTest() {

        sub = new Subspace(cont);

        // Man, ByRef sucks sometimes

        Assert.assertEquals(0, sub.getCoordinate().getCoordinate_x());
        Assert.assertEquals(0, sub.getCoordinate().getCoordinate_y());
        Assert.assertEquals(0, sub.getCoordinate().getCoordinate_z());




        Assert.assertEquals(1, sub.getLength());
        Assert.assertEquals(2, sub.getWidth());
        Assert.assertEquals(3, sub.getHeight());


    }

}
