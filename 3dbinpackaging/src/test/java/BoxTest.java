

import com.bin.packaging.Model.Box;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Tiebevn on 5/04/2017.
 */

public class BoxTest {

	
	private Box box;
	
	
	
	@Test
	public void createBoxTest() {
		box = new Box(1, 1, 1);
		
		Assert.assertEquals(1, box.getLength());
		Assert.assertEquals(1, box.getWidth());
		Assert.assertEquals(1, box.getHeight());
	}

	
	@Test
	public void turnYAxisTest() {
		box = new Box(1, 2, 3);
		box.turnYaxis();

		Assert.assertEquals(3, box.getLength());
		Assert.assertEquals(2, box.getWidth());
		Assert.assertEquals(1, box.getHeight());
	}

	@Test
	public void turnZAxisTest() {
		box = new Box(1, 2, 3);
		box.turnZaxis();

		Assert.assertEquals(2, box.getLength());
		Assert.assertEquals(1, box.getWidth());
		Assert.assertEquals(3, box.getHeight());
	}

	@Test
	public void turnXAxisTest() {
		box = new Box(1, 2, 3);
		box.turnXaxis();

		Assert.assertEquals(1, box.getLength());
		Assert.assertEquals(3, box.getWidth());
		Assert.assertEquals(2, box.getHeight());
	}

    @Test(expected = IllegalArgumentException.class)
    public void invalidLengthTest() {
        box = new Box(-1, 1, 1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidWidthTest() {
        box = new Box(1, -1, 1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidHeightTest() {
        box = new Box(1, 1, -1);

    }
	
}
