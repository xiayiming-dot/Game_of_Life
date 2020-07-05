import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WorldTest {

	private static World world = new World();

	@Before
	public void setUp() throws Exception {
		world=new World();
	}

	@Test
	public void testGetCellNeighbors() {
		int num = world.getCellNeighbors(world.cell[5][5]);
		assertEquals(0, num);
		world.cell[5][5].setState(true);
		world.cell[5][4].setState(true);
		world.cell[4][4].setState(true);
		world.cell[6][6].setState(true);
		num = world.getCellNeighbors(world.cell[5][5]);
		assertEquals(3, num);
		world.cell[5][6].setState(true);
		num = world.getCellNeighbors(world.cell[5][5]);
		assertEquals(4, num);
	}

	@Test
	public void testJudgeAlive() {
		world.cell[0][0].setNeighbors(2);
		assertEquals(false, world.judgeAlive(world.cell[0][0]));
		world.cell[0][0].setState(true);
		world.cell[5][5].setNeighbors(3);
		world.cell[3][3].setNeighbors(1);
		world.cell[10][10].setNeighbors(6);
		assertEquals(true, world.judgeAlive(world.cell[0][0]));
		assertEquals(true, world.judgeAlive(world.cell[5][5]));
		assertEquals(false, world.judgeAlive(world.cell[3][3]));
		assertEquals(false, world.judgeAlive(world.cell[10][10]));
	}

	@Test
	public void testNextWorld() {
		World nextworld=new World();
		nextworld.cell[5][5].setState(true);
		nextworld.cell[5][6].setState(true);
		nextworld.cell[6][4].setState(true);
		nextworld.cell[7][4].setState(true);
		nextworld.cell[7][6].setState(true);
		nextworld.cell[8][5].setState(true);
		nextworld.cell[8][6].setState(true);
		for(int j=0;j<nextworld.row;j++) {
			for(int k=0;k<nextworld.col;k++) {
				nextworld.cell[j][k].setNeighbors(nextworld.getCellNeighbors(nextworld.cell[j][k]));
			}
		}
		for(int i=5;i<=8;i++)
		{
			world.cell[i][5].setState(true);
			world.cell[i][6].setState(true);
		}
		world.nextWorld();
		for(int j=0;j<world.row;j++) {
			for(int k=0;k<world.col;k++) {
				world.cell[j][k].setNeighbors(world.getCellNeighbors(world.cell[j][k]));
			}
		}
		for(int m=0;m<world.row;m++)
			for(int n=0;n<world.col;n++) {
				assertEquals(nextworld.cell[m][n].isAlive(), world.cell[m][n].isAlive());
				assertEquals(nextworld.cell[m][n].getNeighbors(),world.cell[m][n].getNeighbors());
			}
	}

	@Test
	public void testCountAliveCell() {
		world.cell[0][0].setState(true);
		world.cell[1][1].setState(true);
		world.cell[2][2].setState(true);
		world.cell[0][2].setState(true);
		world.cell[2][0].setState(true);
		assertEquals(5,world.countAliveCell());
		world.nextWorld();
		assertEquals(1,world.countAliveCell());
		world.nextWorld();
		assertEquals(0,world.countAliveCell());
	}

}
