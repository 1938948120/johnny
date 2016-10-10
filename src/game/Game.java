package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel {
	//��Ϸ������
	public static final int WIDTH=400;
	public static final int HEIGHT=700;
	//����ͼƬ���ڴ�
	public static BufferedImage background;
	public static BufferedImage start;
	public static BufferedImage airplane;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	public static BufferedImage pause;
	public static BufferedImage end;
	//��̬�飬���ؾ�̬��Դ
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
		 * java�л��ƴ��壺JFrame����--����
		 * 			   JPanel-----�������
		 */
		JFrame frame=new JFrame("�ɻ���ս");//���ɻ���ս���Ǵ��������
		frame.setSize(WIDTH, HEIGHT);
		frame.setAlwaysOnTop(true);//�������ϲ�
		//���ô���ر�ͬʱ���˳�����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);//���ô����ʼλ�ã�null����
		
		//�ڴ�����Ƕ�뱳��������--JPanel
		Game game=new Game();//��������������
		frame.add(game);//������������Ƕ�뵽���������
		//����Ĭ�ϲ��ɼ�
		frame.setVisible(true);//�Զ�����paint����
		//���崴����ɣ�������paint�������
		//*******************************
		
		
		
		
		
		
		
		
		
		
		
		

	}
	
	
	
	@Override
	public void paint(Graphics g) {
		//��ͼʵ�飬�ӣ�10,10������100,100����ֱ��
		//g.drawLine(10, 10, 100, 100);
		//�ԣ�10,10��Ϊ���Ͻǻ�һ��100��������
		//g.drawRect(10, 10, 100, 100);
		g.drawImage(background, 0, 0, null);
		
	}


		
		
	
	
}
