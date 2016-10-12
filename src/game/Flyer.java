package game;

import java.awt.image.BufferedImage;

/**
 * ��������
 * @author Johnny
 *
 */
public abstract class Flyer {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected BufferedImage image;//�������õ�ͼƬ
	/**
	 * �ƶ����������������ʵ��
	 */
	public abstract void step();
	/**
	 * ����Ƿ�Խ��
	 * @return
	 */
	public abstract boolean outOfBounds();
	/**
	 * ����������η������Ƿ���ײ
	 * �;�������޹أ����Զ���Ϊ��̬����
	 * @param f1
	 * @param f2
	 * @return ���true��ײ
	 */
	public static boolean bang(Flyer f1,Flyer f2){
		//1.����������ε����ĵ�
		int f1_x=f1.x+f1.width/2;
		int f1_y=f1.x+f1.height/2;
		int f2_x=f2.x+f2.width/2;
		int f2_y=f2.y+f2.height/2;
		//2.�����������ײ���
		boolean H=Math.abs(f1_x-f2_x)<(f1.width+f2.width)/2;
		boolean V=Math.abs(f1_y-f2_y)<(f1.height+f2.height)/2;
		//3. ��������������ײ��������ײ��
		return H&V;
	}
	
}
