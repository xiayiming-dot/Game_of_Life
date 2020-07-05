
public class Cell { // ����ϸ����
	private boolean state; // ״̬
	private int position_x; // ������
	private int position_y; // ������
	private int neighbors; // �ھ�����

	Cell(int y, int x) {
		this.position_x = x;
		this.position_y = y;
		this.state = false; // ��ʼ״̬Ϊ��ϸ��
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

	public boolean isAlive() { // �Ƿ�Ϊ��ϸ��
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

	public int getNeighbors() { // ����ھ���
		return neighbors;
	}

	public void setNeighbors(int num) {
		this.neighbors = num;
	}

}
