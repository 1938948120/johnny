package game;

import java.util.Random;

public class Hero extends Flyer {
	private int doublefire;
	private int life;
	private int score;
	/**
	 * 
	 * @return ֻ����ȡ����ֵ
	 */
	public int getlife(){
		return life;
	}
	/**
	 * 
	 * @return ֻ����ȡ����
	 */
	public int getScore(){
		return score;
	}
	/**
	 * Ӣ�ۻ����޲ι��췽��
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
	 * ʵ��Ӣ�ۻ�����Ч������Ӣ�ۻ���ͼƬ������ͼƬ�����л�
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
	 * Ӣ�ۻ�������ƶ�
	 * @param x
	 * @param y
	 */
	public void move(int x,int y){
		//�����x,y������λ��
		this.x=x-width/2;
		this.y=y-height/2;
	}
	/**
	 * Ӣ�ۻ���ý����ķ���
	 * @param f �����ͱ���
	 * 			����ָ����˻�Ӣ��
	 */
	public void getScore_Award(Flyer f){
		
	}
	/**
	 * �����ӵ�
	 * @return �´��������ӵ�����
	 * 			����������˫������
	 */
	public Bullet[] shoot(){
		Bullet[] bullets=null;
		//��ʱ����˫������
		if(doublefire!=0){//˫������
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
	 * ��ײ���
	 * @param f ������ײ�ĵ��ˣ��۷��л�
	 * @return �Ƿ���ײ
	 */
	public boolean hit(Flyer f){
		return false;
	}
}
