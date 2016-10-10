package game;

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
		doublefire=0;
		life=3;
		score=0;
	}
	
	
	
	@Override
	public void step() {
		// TODO Auto-generated method stub
		
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
		Bullet[] bullet=null;
		return bullet;
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
