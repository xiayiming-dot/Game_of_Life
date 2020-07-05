
public class Cell { // 设置细胞类
	private boolean state; // 状态
	private int position_x; // 横坐标
	private int position_y; // 纵坐标
	private int neighbors; // 邻居数量

	Cell(int y, int x) {
		this.position_x = x;
		this.position_y = y;
		this.state = false; // 初始状态为死细胞
	}

	public int getX() {
		return position_x;
	}

	public int getY() {
		return position_y;
	}

	public void setX(int x) {
		this.position_x = x;
	}

	public void setY(int y) {
		this.position_y = y;
	}

	public boolean isAlive() { // 是否为活细胞
		if (state == true)
			return true;
		else
			return false;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public int getNeighbors() { // 获得邻居数
		return neighbors;
	}

	public void setNeighbors(int num) {
		this.neighbors = num;
	}

}
