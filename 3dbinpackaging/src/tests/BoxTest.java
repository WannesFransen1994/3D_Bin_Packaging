

import com.bin.packaging.Box;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Tiebevn on 5/04/2017.
 */

public class BoxTest {

	
	private Box box;
	
	
	
	@Test
	public void Box_with_valid_arguments_creates_new_box() {
		box = new Box(1, 1, 1);
		
		Assert.assertEquals(1, box.getLength());
		Assert.assertEquals(1, box.getWidth());
		Assert.assertEquals(1, box.getHeight());
	}

	
	@Test
	public void Turn_box_over_Z_axis_works() {
		box = new Box(1, 2, 3);
		box.turnZaxis();

		Assert.assertEquals(2, box.getLength());
		Assert.assertEquals(1, box.getWidth());
		Assert.assertEquals(3, box.getHeight());
	}
	
	@Test
	public void Turn_box_over_Y_axis_works() {
		box = new Box(1, 2, 3);
		box.turnYaxis();

		Assert.assertEquals(3, box.getLength());
		Assert.assertEquals(2, box.getWidth());
		Assert.assertEquals(1, box.getHeight());
	}
	
	@Test
	public void Turn_box_over_X_axis_works() {
		box = new Box(1, 2, 3);
		box.turnXaxis();

		Assert.assertEquals(1, box.getLength());
		Assert.assertEquals(3, box.getWidth());
		Assert.assertEquals(2, box.getHeight());
	}

    @Test(expected = IllegalArgumentException.class)
    public void Box_with_invalid_length_throws_exception() {
        box = new Box(-1, 1, 1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void Box_with_invalid_width_throws_exception() {
        box = new Box(1, -1, 1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void Box_with_invalid_height_throws_exception() {
        box = new Box(1, 1, -1);

    }
	
}
