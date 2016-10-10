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
	
	
}
