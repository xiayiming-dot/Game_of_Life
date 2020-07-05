
public class World { // ����������
	public final int row = 40; // ������Ϊ40
	public final int col = 40; // ������Ϊ40
	public Cell[][] cell = new Cell[row][col];

	World() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				cell[i][j] = new Cell(i, j);
			}
		}
	}

	public int getCellNeighbors(Cell cell) { // ���ϸ�����ھ���
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

	public boolean judgeAlive(Cell cell) { // �ж��ھӻ�ϸ�����������ݴ˷���ϸ����һ�׶�״̬
		if (cell.getNeighbors() == 2) {
			return cell.isAlive();
		} else if (cell.getNeighbors() == 3) {
			return true;
		} else
			return false;
	}

	public void nextWorld() { // ��һ������
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				this.cell[i][j].setNeighbors(getCellNeighbors(this.cell[i][j]));
				this.cell[i][j].setState(judgeAlive(this.cell[i][j]));
			}
	}

	public int countAliveCell() { // ͳ�����л�ϸ������
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
