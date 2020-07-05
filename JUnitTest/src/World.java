
public class World { // 设置世界类
	public final int row = 40; // 行设置为40
	public final int col = 40; // 宽设置为40
	public Cell[][] cell = new Cell[row][col];

	World() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				cell[i][j] = new Cell(i, j);
			}
		}
	}

	public int getCellNeighbors(Cell cell) { // 获得细胞的邻居数
		int num = 0;
		for (int i = cell.getY() - 1; i <= cell.getY() + 1; i++) {
			for (int j = cell.getX() - 1; j <= cell.getX() + 1; j++) {
				if (i == cell.getY() && j == cell.getX()) {
				} else if (i < 0 || i >= row || j < 0 || j >= col) {
				} else if (this.cell[i][j].isAlive()) {
					num++;
				}
			}
		}
		return num;
	}

	public boolean judgeAlive(Cell cell) { // 判断邻居活细胞数量，并据此返回细胞下一阶段状态
		if (cell.getNeighbors() == 2) {
			return cell.isAlive();
		} else if (cell.getNeighbors() == 3) {
			return true;
		} else
			return false;
	}

	public void nextWorld() { // 下一个世界
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				this.cell[i][j].setNeighbors(getCellNeighbors(this.cell[i][j]));
				this.cell[i][j].setState(judgeAlive(this.cell[i][j]));
			}
	}

	public int countAliveCell() { // 统计所有活细胞数量
		int num = 0;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				if (this.cell[i][j].isAlive()) {
					num++;
				}
			}
		return num;
	}
}
