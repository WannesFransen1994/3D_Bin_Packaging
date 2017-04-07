import static org.junit.Assert.*;

import org.junit.Test;

import com.bin.packaging.Model.Box;
import com.bin.packaging.Model.Container;
import com.bin.packaging.Model.ContainerType;
import com.bin.packaging.Model.Coordinate;
import com.bin.packaging.Model.Subspace;
import com.bin.packaging.Model.VolumeObjectFactory;

/**
 * Created by Tiebevn on 5/04/2017.
 */

public class VolumeObjectFactoryTest {


	@Test
	public void createBoxTest() {

		Box box = VolumeObjectFactory.createBox(1, 2, 3);
		assertEquals(1, box.getLength());
		assertEquals(2, box.getWidth());
		assertEquals(3, box.getHeight());
	}
	
	@Test
	public void createContainerTest() {
		Container container = VolumeObjectFactory.createContainer(ContainerType.SMALLEST);
		
		assertEquals(120, container.getLength());
		assertEquals(80, container.getWidth());
		assertEquals(100, container.getHeight());
		
	}
	
	@Test
	public void createSubspaceTest() {
		Coordinate coord = new Coordinate(1, 2, 3);
		
		Subspace sub = VolumeObjectFactory.createSubspace(coord, 1, 2, 3);
		
		assertEquals(coord, sub.getCoordinate());
		assertEquals(1, sub.getLength());
		assertEquals(2, sub.getWidth());
		assertEquals(3, sub.getHeight());
		
		
	}
}
