package game;

import java.util.Random;

public class Bee extends Flyer {
	//����˫������
	public static final int DOUBLE_FIRE=0;
	//��������
	public static final int LIFE=0;
	private int xspeed=1;//ˮƽ�ٶ�
	private int yspeed=2;
	private int awardType;//�۷�Ľ�������
	public int getAwardType(){
		return awardType;
	}
	/**
	 * �۷������޲ι��췽��
	 */
	public Bee(){
		//1.���������л��ͼƬ
		image=Game.bee;
		//2.��ͼƬ�Ŀ�����ö���Ŀ��
		width=image.getWidth();
		height=image.getHeight();
		//3.�����۷�����ĸ߶�
		y=-height;
		//4.�۷������x����
		Random r=new Random();
		x=r.nextInt(Game.WIDTH-width);
		//5.��������
		//ע�⣺�����    ***��Сֵ<=�����<���ֵ***
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
