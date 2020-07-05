import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CellTest {
	private static Cell cell = new Cell(0, 0);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsAlive() {
		assertEquals(false, cell.isAlive());
		cell.setState(true);
		assertEquals(true, cell.isAlive());
	}
}
