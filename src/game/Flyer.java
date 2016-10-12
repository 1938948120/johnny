package game;

import java.awt.image.BufferedImage;

/**
 * 飞行器类
 * @author Johnny
 *
 */
public abstract class Flyer {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected BufferedImage image;//飞行物用的图片
	/**
	 * 移动方法，让子类各自实现
	 */
	public abstract void step();
	/**
	 * 检查是否越界
	 * @return
	 */
	public abstract boolean outOfBounds();
	/**
	 * 检测两个矩形飞行物是否碰撞
	 * 和具体对象无关，所以定义为静态方法
	 * @param f1
	 * @param f2
	 * @return 如果true碰撞
	 */
	public static boolean bang(Flyer f1,Flyer f2){
		//1.求出两个矩形的中心点
		int f1_x=f1.x+f1.width/2;
		int f1_y=f1.x+f1.height/2;
		int f2_x=f2.x+f2.width/2;
		int f2_y=f2.y+f2.height/2;
		//2.横向和纵向碰撞检测
		boolean H=Math.abs(f1_x-f2_x)<(f1.width+f2.width)/2;
		boolean V=Math.abs(f1_y-f2_y)<(f1.height+f2.height)/2;
		//3. 必须两个方向都碰撞，才真碰撞了
		return H&V;
	}
	
}
