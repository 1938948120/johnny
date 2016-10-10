package game;

import java.util.Random;

public class Bee extends Flyer {
	//奖励双倍火力
	public static final int DOUBLE_FIRE=0;
	//奖励生命
	public static final int LIFE=0;
	private int xspeed=1;//水平速度
	private int yspeed=2;
	private int awardType;//蜜蜂的奖励类型
	public int getAwardType(){
		return awardType;
	}
	/**
	 * 蜜蜂对象的无参构造方法
	 */
	public Bee(){
		//1.从主程序中获得图片
		image=Game.bee;
		//2.用图片的宽高设置对象的宽高
		width=image.getWidth();
		height=image.getHeight();
		//3.设置蜜蜂下落的高度
		y=-height;
		//4.蜜蜂下落的x坐标
		Random r=new Random();
		x=r.nextInt(Game.WIDTH-width);
		//5.奖励类型
		//注意：随机数    ***最小值<=随机数<最大值***
		awardType=r.nextInt(2);
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
}
