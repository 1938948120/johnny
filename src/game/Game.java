package game;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

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
	
	//Ϊ��Ϸ��ɫ�������ݽṹ��һ��Ӣ�ۣ�һ���������飬һ���ӵ�����
	public Hero hero=new Hero();
	//һ������ȱ���л��ֱ����۷䣬�����ø�����
	public Flyer[] flyers={};
	public Bullet[] bullets={};
	
	
	
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
		game.action();
		
		
		
		
		
		
		
		
		
		
		

	}
	/**
	 * ��Ϸ����ʱҪ�����£�������ʱ��
	 */
	public void action(){
		//��Ϸ��ʼʱ���������λ�õļ���
		//1.����mouseadapter�����ڲ���--�¼�����Ӧ����
		MouseAdapter l=new MouseAdapter() {
			//2.��дϣ������¼�����-����ƶ�
			@Override
			public void mouseMoved(MouseEvent e) {
				// 3.��������λ��x,y
				int x=e.getX();
				int y=e.getY();
				//4.�����λ�ô���Ӣ�ۻ�move����
				hero.move(x, y);
			}
		};//�����ڲ���
		//5.Ҫ��Ӧ����¼������뽫����¼���ӵ�����ļ�����
		this.addMouseMotionListener(l);//֧������ƶ��¼�
		//**************************************************
		//������ʱ��
		Timer timer=new Timer();
		//����schedule�������ƻ���
		//	��һ��������timertask���͵������ڲ���
		//			������дrun������������Ҫ��ʲô��
		timer.schedule(new TimerTask() {
			//���ȶ���һ����ʱ������index����¼run����ִ�д���
			private int runtimes=0;
			@Override
			public void run() {
				runtimes++;
				if(runtimes%50==0){
				// �Զ������������
				nextone();
				}
				// Ȼ��������󣬵�����step����
				for(int i=0;i<flyers.length;i++){
					flyers[i].step();
				}
				//ÿ300ms����һ���ӵ�
				if(runtimes%30==0){
					shoot();//����һ���ӵ�
				}
				//�����ӵ����飬�ƶ�λ��
				for(int i=0;i<bullets.length;i++){
					bullets[i].step();
				}
				//Ӣ�ۻ�����Ч��
				hero.step();
				//ֻҪ�����б仯������Ҫ���»���
				repaint();
			}
		}, 10,10);
	}
	
	
	@Override
	public void paint(Graphics g) {
		//��ͼʵ�飬�ӣ�10,10������100,100����ֱ��
		//g.drawLine(10, 10, 100, 100);
		//�ԣ�10,10��Ϊ���Ͻǻ�һ��100��������
		//g.drawRect(10, 10, 100, 100);
		g.drawImage(background, 0, 0, null);
		paintHero(g);
		paintFlyers(g);
		paintBullets(g);
		
	}
	//����Ӣ�۵ķ���
	public void paintHero(Graphics g){
		g.drawImage(hero.image, hero.x, hero.y, null);
	}
	public void paintFlyers(Graphics g){
		for(int i=0;i<flyers.length;i++){
			g.drawImage(flyers[i].image, flyers[i].x, flyers[i].y, null);
		}
	}
	public void paintBullets(Graphics g){
		for(int i=0;i<bullets.length;i++){
			g.drawImage(bullets[i].image, bullets[i].x, bullets[i].y, null);
		}
	}
	
	
	
	/**
	 * �������һ�����˶���
	 */
	public void nextone(){
		Random r=new Random();
		Flyer f=null;
		if(r.nextInt(10)==0){
			f=new Bee();
		}else{
			f=new Airplane();
		}
		flyers=Arrays.copyOf(flyers, flyers.length+1);
		flyers[flyers.length-1]=f;
		
	}
	//���Ӣ�ۻ���������ӵ����󣬲������ӵ����󱣴����ӵ�������
	public void shoot(){
		//���Ӣ�ۼķ��ص����ӵ�����
		Bullet[] newBullets=hero.shoot();
		//���ݷ������ӵ�����������������
		bullets=Arrays.copyOf(bullets, bullets.length+newBullets.length);
		//��newBullets�����п�������Ԫ�ص�ĩβ
		System.arraycopy(newBullets, 0 , bullets , bullets.length-newBullets.length, newBullets.length);
		
	}
	/**
	 * �����ӵ�����͵������飬������ײ���
	 * һ����ײ�����˺��ӵ�������һ��
	 */
	public void bang(){
		for(int i=0;i<bullets.length;i++){//ȡ��ÿ���ӵ�
			for(int j=0;j<flyers.length;j++){//��ÿ�����˼��
				if(Flyer.bang(bullets[i], flyers[j])){
					//�ӵ���������ɾ�������еĵл�
					//1.�����һ��Ԫ���滻��ǰλ�ñ����еĵ���
					flyers[j]=flyers[flyers.length-1];
					//2.ѹ�����飬
					flyers=Arrays.copyOf(flyers, flyers.length-1);
					//���ӵ�������ɾ�����е��˵��ӵ�
					bullets[i]=bullets[bullets.length-1];
					bullets=Arrays.copyOf(bullets, bullets.length-1);
					
				}
			}
		}
	}


		
		
	
	
}
