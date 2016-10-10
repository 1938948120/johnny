package game;

public class Bullet extends Flyer {
	private int speed=3;
	/**
	 * 子弹的带参构造方法，根据英雄的位置传入x，y
	 * @param x
	 * @param y
	 */
	public Bullet(int x,int y) {
		image=Game.bullet;
		width=image.getWidth();
		height=image.getHeight();
		this.x=x;
		this.y=y;
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
