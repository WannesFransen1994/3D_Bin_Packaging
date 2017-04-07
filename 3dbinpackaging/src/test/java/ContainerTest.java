import com.bin.packaging.Model.Box;
import com.bin.packaging.Model.Container;
import com.bin.packaging.Model.Coordinate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by tiebe on 5/04/2017.
 */
public class ContainerTest {

    private Coordinate coord;
    private Coordinate coord2;
    private Container container;
    private Map<Coordinate, Box> map;
    private Container container2;

    @Before
    public void setUp() {
        coord = new Coordinate(1, 1, 1);
        coord2 = new Coordinate(5, 5, 5);
        Box box = new Box(1, 1, 1);
        container = new Container(10, 15, 20);

        container.addItem(coord2, box);
        container.addItem(coord, box);

        map = new HashMap<>();
        map.put(coord, box);
        map.put(coord2, box);

        container2 = new Container(container);
    }

    @Test
    public void valueConstructorTest() {
        Assert.assertEquals(10, container.getLength());
        Assert.assertEquals(15, container.getWidth());
        Assert.assertEquals(20, container.getHeight());
        Assert.assertEquals(2, container.getAmountOfItems());
    }
    @Test
    public void copyConstructorTest() {
        Assert.assertEquals(10, container2.getLength());
        Assert.assertEquals(15, container2.getWidth());
        Assert.assertEquals(20, container2.getHeight());
        Assert.assertEquals(2, container2.getAmountOfItems());
    }

    @Test
    public void itemAddTest() {

        Assert.assertTrue(container.getItems().equals(map));
    }

    @Test
    public void itemRemoveTest() {
        container.removeItem(coord2);
        map.remove(coord2);
        Assert.assertEquals(1, container.getAmountOfItems());
        Assert.assertTrue(container.getItems().equals(map));
    }

    @Test
    public void equalsTest() {
        Assert.assertTrue(container.equals(container2));
    }

    @Test
    public void noItemsTest() {

        Container test = new Container(10, 10, 10);
        Assert.assertEquals((float) 0, test.getFilled(), 0.0001);
    }

    @Test
    public void fullContainerTest() {
        Container test = new Container(10, 10, 10);
        test.addItem(coord, new Box(10, 10, 10));

        Assert.assertEquals(1, test.getFilled(), 0.0001);
    }

    @Test
    public void multipleItemsTest() {
        Container test = new Container(10, 10, 10);
        test.addItem(coord, new Box(5, 5, 5));

        Assert.assertEquals(0.125, test.getFilled(), 0.0001);
    }
    @Test
    public void getVolumeTest() {
        Assert.assertEquals(3000, container.getVolume());
    }
}
