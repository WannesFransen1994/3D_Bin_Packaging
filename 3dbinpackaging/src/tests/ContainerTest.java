import com.bin.packaging.Box;
import com.bin.packaging.Container;
import com.bin.packaging.Coordinate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by tiebe on 5/04/2017.
 */
public class ContainerTest {

    private Box box;
    private Coordinate coord;
    private Coordinate coord2;
    private Container container;
    private Map<Coordinate, Box> map;
    private Container container2;

    @Before
    public void setUp() {
        coord = new Coordinate(1, 1, 1);
        coord2 = new Coordinate(5, 5, 5);
        box = new Box(1, 1, 1);
        container = new Container(10, 15, 20);

        container.addItem(coord2, box);
        container.addItem(coord, box);

        map = new HashMap<>();
        map.put(coord, box);
        map.put(coord2, box);

        container2 = new Container(container);
    }

    @Test
    public void Constructor_by_values_test() {
        Assert.assertEquals(10, container.getLength());
        Assert.assertEquals(15, container.getWidth());
        Assert.assertEquals(20, container.getHeight());
        Assert.assertEquals(2, container.getAmountOfItems());
    }
    @Test
    public void Constructor_by_reference_test() {
        Assert.assertEquals(10, container2.getLength());
        Assert.assertEquals(15, container2.getWidth());
        Assert.assertEquals(20, container2.getHeight());
        Assert.assertEquals(2, container2.getAmountOfItems());
    }

    @Test
    public void Add_box_to_items() {

        Assert.assertTrue(container.getItems().equals(map));
    }

    @Test
    public void Remove_item_from_items() {
        container.removeItem(coord2);
        map.remove(coord2);
        Assert.assertEquals(1, container.getAmountOfItems());
        Assert.assertTrue(container.getItems().equals(map));
    }

    @Test
    public void Overriden_equals_method() {
        Assert.assertTrue(container.equals(container2));
    }

    @Test
    public void GetFilled_with_0_items_should_return_0() {

        Container test = new Container(10, 10, 10);
        Assert.assertEquals((float) 0, test.getFilled(), 0.0001);
    }

    @Test
    public void GetFilled_with_full_container() {
        Container test = new Container(10, 10, 10);
        test.addItem(coord, new Box(10, 10, 10));

        Assert.assertEquals(1, test.getFilled(), 0.0001);
    }

    @Test
    public void GetFilled_with_multiple_items_in_container() {
        Container test = new Container(10, 10, 10);
        test.addItem(coord, new Box(5, 5, 5));

        Assert.assertEquals(0.125, test.getFilled(), 0.0001);
    }
    @Test
    public void GetVolume_from_container() {
        Assert.assertEquals(3000, container.getVolume());
    }



}
