package game;

import java.util.Random;

public class Airplane extends Flyer {
	private int speed=2;
	private int score=5;
	public int getScore(){
		return score;
	}
	/**
	 * �л����޲ι��췽��
	 */
	public Airplane() {
		image=Game.airplane;
		width=image.getWidth();
		height=image.getHeight();
		y=-height;
		Random r=new Random();
		x=r.nextInt(Game.WIDTH-width);
	}
	
	@Override
	public void step() {
		//ÿ������һ��speed
		y+=speed;
		
	}
	@Override
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		return false;
	}
}
