package game;

import java.util.Random;

public class Hero extends Flyer {
	private int doublefire;
	private int life;
	private int score;
	/**
	 * 
	 * @return 只读获取生命值
	 */
	public int getlife(){
		return life;
	}
	/**
	 * 
	 * @return 只读获取分数
	 */
	public int getScore(){
		return score;
	}
	/**
	 * 英雄机的无参构造方法
	 */
	public Hero(){
		image=Game.hero0;
		width=image.getWidth();
		height=image.getHeight();
		x=150;
		y=450;
		doublefire=20;
		life=3;
		score=0;
	}
	
	
	/**
	 * 实现英雄机动画效果，让英雄机的图片在两张图片来回切换
	 */
	@Override
	public void step() {
		Random r=new Random();
		if(r.nextInt(2)==0){
			image=Game.hero0;
		}else{
			image=Game.hero1;
		}
		
		
	}
	@Override
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 英雄机随鼠标移动
	 * @param x
	 * @param y
	 */
	public void move(int x,int y){
		//传入的x,y是鼠标的位置
		this.x=x-width/2;
		this.y=y-height/2;
	}
	/**
	 * 英雄机获得奖励的方法
	 * @param f 父类型变量
	 * 			可以指向敌人或英雄
	 */
	public void getScore_Award(Flyer f){
		
	}
	/**
	 * 发射子弹
	 * @return 新创建出的子弹对象
	 * 			用数组区别双倍火力
	 */
	public Bullet[] shoot(){
		Bullet[] bullets=null;
		//何时创建双倍火力
		if(doublefire!=0){//双倍火力
			bullets=new Bullet[2];
			Bullet b1=new Bullet(x+width/4,y-Game.bullet.getHeight());
			Bullet b2=new Bullet(x+width*3/4,y-Game.bullet.getHeight());
			bullets[0]=b1;
			bullets[1]=b2;
			doublefire-=2;
		}else{
		bullets=new Bullet[1];
		bullets[0]=new Bullet(x+width/2, y-Game.bullet.getHeight());
		}
		return bullets;
	}
	/**
	 * 碰撞检测
	 * @param f 发生碰撞的敌人，蜜蜂或敌机
	 * @return 是否碰撞
	 */
	public boolean hit(Flyer f){
		return false;
	}
}
