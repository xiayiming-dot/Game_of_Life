package GOL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GOL  extends JFrame implements ActionListener{    //图形可视化类
	public World world;
	public Container contentPane;
	public JPanel p1,p2,p3;
	public JButton btn;
	public JButton[][] btns;      //每一个按钮对应一个细胞
	public JLabel jl;
	public GOL() {
		world = new World();
		contentPane=getContentPane();
		setTitle("生命游戏");
		setLocation(100, 50);
		setSize(500,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}
	public void initGUI() {
		btn=new JButton("点击产生下一代");
		p1=new JPanel();
		btn.addActionListener(this);
		p1.add(btn);
		contentPane.add(p1,BorderLayout.NORTH);
		jl=new JLabel("当前有0个活细胞");
		p3=new JPanel();
		p3.add(jl);
		contentPane.add(p3,BorderLayout.SOUTH);
		p2=new JPanel();
		p2.setLayout(new GridLayout(world.row,world.col));
		btns=new JButton[world.row][world.col];
		for(int i=0;i<world.row;i++)
			for(int j=0;j<world.col;j++) {
				btns[i][j] = new JButton();
				btns[i][j].setMargin(new Insets(0, 0, 0, 0));
				btns[i][j].setBackground(Color.white);
				btns[i][j].addActionListener(this);
				p2.add(btns[i][j]);
			}
		contentPane.add(p2,BorderLayout.CENTER);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		int num;
		for(int i=0;i<world.row;i++) {
			for(int j=0;j<world.col;j++) {
				if(e.getSource()==btns[i][j]) {
					if ((btns[i][j].getBackground()).equals(Color.white)) {   //点击后变为活细胞
						btns[i][j].setBackground(Color.black);
						world.cell[i][j].setState(true);
						num=world.countAliveCell();
						jl.setText("当前有"+num+"个活细胞");
					}
				}
			}
		}
		if(e.getSource()==btn) {
			world.nextWorld();     //鼠标点击按钮后，进入下一阶段
			for(int i=0;i<world.row;i++) {
				for(int j=0;j<world.col;j++) {
					if(world.cell[i][j].isAlive()) {
						btns[i][j].setBackground(Color.black);
					}
					else btns[i][j].setBackground(Color.white);
				}
			}
			num=world.countAliveCell();
			jl.setText("当前有"+num+"个活细胞");
		}
	}

}

