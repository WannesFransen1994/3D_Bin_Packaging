package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bin.packaging.Box;
import com.bin.packaging.Container;
import com.bin.packaging.ContainerType;
import com.bin.packaging.Coordinate;
import com.bin.packaging.Subspace;
import com.bin.packaging.VolumeObjectFactory;

public class VolumeObjectFactoryTest {

	@Test
	public void Creating_a_new_box_creates_a_new_box() {
		Box box = VolumeObjectFactory.createBox(1, 2, 3);
		
		assertEquals(1, box.getLength());
		assertEquals(2, box.getWidth());
		assertEquals(3, box.getHeight());
	}
	
	@Test
	public void Creating_a_new_container_creates_a_new_container() {
		Container container = VolumeObjectFactory.createContainer(ContainerType.SMALLEST);
		
		assertEquals(120, container.getLength());
		assertEquals(80, container.getWidth());
		assertEquals(100, container.getHeight());
		
	}
	
	@Test
	public void Creating_a_new_subspace_creates_a_new_subspace() {
		Coordinate coord = new Coordinate(1, 2, 3);
		
		Subspace sub = VolumeObjectFactory.createSubspace(coord, 1, 2, 3);
		
		assertEquals(coord, sub.getCoordinate());
		assertEquals(1, sub.getLength());
		assertEquals(2, sub.getWidth());
		assertEquals(3, sub.getHeight());
		
		
	}
	
	
}
