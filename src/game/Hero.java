package game;

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
	 * Ӣ�ۻ�������ƶ�
	 * @param x
	 * @param y
	 */
	public void move(int x,int y){
		
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
		Bullet[] bullet=null;
		return bullet;
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
