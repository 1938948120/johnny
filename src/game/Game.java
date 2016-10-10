package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel {
	//游戏界面宽度
	public static final int WIDTH=400;
	public static final int HEIGHT=700;
	//加载图片到内存
	public static BufferedImage background;
	public static BufferedImage start;
	public static BufferedImage airplane;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	public static BufferedImage pause;
	public static BufferedImage end;
	//静态块，加载静态资源
	static{
		try {
			background=ImageIO.read(Game.class.getResource("background.png"));
			start=ImageIO.read(Game.class.getResource("start.png"));
			airplane=ImageIO.read(Game.class.getResource("airplane.png"));
			bee=ImageIO.read(Game.class.getResource("bee.png"));
			bullet=ImageIO.read(Game.class.getResource("bullet.png"));
			hero0=ImageIO.read(Game.class.getResource("hero0.png"));
			hero1=ImageIO.read(Game.class.getResource("hero1.png"));
			pause=ImageIO.read(Game.class.getResource("pause.png"));
			end=ImageIO.read(Game.class.getResource("end.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		/**
		 * java中绘制窗体：JFrame对象--窗框
		 * 			   JPanel-----背景面板
		 */
		JFrame frame=new JFrame("飞机大战");//“飞机大战”是窗体的名字
		frame.setSize(WIDTH, HEIGHT);
		frame.setAlwaysOnTop(true);//总在最上层
		//设置窗体关闭同时，退出程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);//设置窗体初始位置，null居中
		
		//在窗体中嵌入背景面板对象--JPanel
		Game game=new Game();//创建北京面板对象
		frame.add(game);//将背景面板对象嵌入到窗体对象中
		//窗体默认不可见
		frame.setVisible(true);//自动调用paint方法
		//窗体创建完成，下面用paint方法填东西
		//*******************************
		
		
		
		
		
		
		
		
		
		
		
		

	}
	
	
	
	@Override
	public void paint(Graphics g) {
		//画图实验，从（10,10）到（100,100）画直线
		//g.drawLine(10, 10, 100, 100);
		//以（10,10）为左上角画一个100的正方形
		//g.drawRect(10, 10, 100, 100);
		g.drawImage(background, 0, 0, null);
		
	}


		
		
	
	
}
