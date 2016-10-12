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
	
	//为游戏角色定义数据结构：一个英雄，一个敌人数组，一个子弹数组
	public Hero hero=new Hero();
	//一个数组既保存敌机又保存蜜蜂，所以用父类型
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
		game.action();
		
		
		
		
		
		
		
		
		
		
		

	}
	/**
	 * 游戏启动时要做的事，创建定时器
	 */
	public void action(){
		//游戏开始时，定义鼠标位置的监听
		//1.创建mouseadapter匿名内部类--事件的响应程序
		MouseAdapter l=new MouseAdapter() {
			//2.重写希望鼠标事件方法-鼠标移动
			@Override
			public void mouseMoved(MouseEvent e) {
				// 3.获得鼠标新位置x,y
				int x=e.getX();
				int y=e.getY();
				//4.将鼠标位置传给英雄机move方法
				hero.move(x, y);
			}
		};//匿名内部类
		//5.要响应鼠标事件，必须将鼠标事件添加到程序的监听器
		this.addMouseMotionListener(l);//支持鼠标移动事件
		//**************************************************
		//创建定时器
		Timer timer=new Timer();
		//调用schedule方法做计划，
		//	第一个参数：timertask类型的匿名内部类
		//			必须重写run方法，定义了要做什么事
		timer.schedule(new TimerTask() {
			//首先定义一个计时器变量index，记录run方法执行次数
			private int runtimes=0;
			@Override
			public void run() {
				runtimes++;
				if(runtimes%50==0){
				// 自动随机创建对象
				nextone();
				}
				// 然后遍历对象，调用其step方法
				for(int i=0;i<flyers.length;i++){
					flyers[i].step();
				}
				//每300ms创建一个子弹
				if(runtimes%30==0){
					shoot();//创建一次子弹
				}
				//遍历子弹数组，移动位置
				for(int i=0;i<bullets.length;i++){
					bullets[i].step();
				}
				//英雄机动画效果
				hero.step();
				//只要界面有变化，就需要重新绘制
				repaint();
			}
		}, 10,10);
	}
	
	
	@Override
	public void paint(Graphics g) {
		//画图实验，从（10,10）到（100,100）画直线
		//g.drawLine(10, 10, 100, 100);
		//以（10,10）为左上角画一个100的正方形
		//g.drawRect(10, 10, 100, 100);
		g.drawImage(background, 0, 0, null);
		paintHero(g);
		paintFlyers(g);
		paintBullets(g);
		
	}
	//绘制英雄的方法
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
	 * 随机生成一个敌人对象，
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
	//获得英雄机对象发射的子弹对象，并将新子弹对象保存在子弹数组中
	public void shoot(){
		//获得英雄寄返回的新子弹数组
		Bullet[] newBullets=hero.shoot();
		//根据返回新子弹的数量，扩容数组
		bullets=Arrays.copyOf(bullets, bullets.length+newBullets.length);
		//从newBullets数组中拷贝所有元素到末尾
		System.arraycopy(newBullets, 0 , bullets , bullets.length-newBullets.length, newBullets.length);
		
	}
	/**
	 * 遍历子弹数组和敌人数组，进行碰撞检测
	 * 一旦碰撞，敌人核子弹都减少一个
	 */
	public void bang(){
		for(int i=0;i<bullets.length;i++){//取出每颗子弹
			for(int j=0;j<flyers.length;j++){//和每个敌人检测
				if(Flyer.bang(bullets[i], flyers[j])){
					//从敌人数组中删除被击中的敌机
					//1.用最后一个元素替换当前位置被击中的敌人
					flyers[j]=flyers[flyers.length-1];
					//2.压缩数组，
					flyers=Arrays.copyOf(flyers, flyers.length-1);
					//从子弹数组中删除击中敌人的子弹
					bullets[i]=bullets[bullets.length-1];
					bullets=Arrays.copyOf(bullets, bullets.length-1);
					
				}
			}
		}
	}


		
		
	
	
}
