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
	
	
}
