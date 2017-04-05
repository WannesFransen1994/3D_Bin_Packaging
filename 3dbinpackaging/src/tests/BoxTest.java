package junit;

import static org.junit.Assert.*;


import org.junit.Test;

import com.bin.packaging.Box;

public class BoxTest {

	
	private Box box;
	
	
	
	@Test
	public void Box_with_valid_arguments_creates_new_box() {
		box = new Box(1, 1, 1);
		
		assertEquals(1, box.getLength());
		assertEquals(1, box.getWidth());
		assertEquals(1, box.getHeight());
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
	
	@Test
	public void Turn_box_over_Z_axis_works() {
		box = new Box(1, 2, 3);
		box.turnZaxis();
		
		assertEquals(2, box.getLength());
		assertEquals(1, box.getWidth());
		assertEquals(3, box.getHeight());
	}
	
	@Test
	public void Turn_box_over_Y_axis_works() {
		box = new Box(1, 2, 3);
		box.turnYaxis();
		
		assertEquals(3, box.getLength());
		assertEquals(2, box.getWidth());
		assertEquals(1, box.getHeight());
	}
	
	@Test
	public void Turn_box_over_X_axis_works() {
		box = new Box(1, 2, 3);
		box.turnXaxis();
		
		assertEquals(1, box.getLength());
		assertEquals(3, box.getWidth());
		assertEquals(2, box.getHeight());
	}
	
}
