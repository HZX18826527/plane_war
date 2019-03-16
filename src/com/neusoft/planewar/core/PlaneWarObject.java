package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.neusoft.planewar.client.PlaneWarClient;

public abstract class PlaneWarObject implements Moveable, Drawable {
	//������ϵ(��ܼ�)
	//��ͣ�����ģʽ
	public PlaneWarClient pwc;
	public int x;
	public int y;
	public Image img;
	public int width;
	public int height;
	public double speed;
	public static int changenum = 1;
	
	/**
	 * ���зɻ���ս��Ŀ��ͳһ�ķ���
	 */
	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
		move();
	}


	/**
	 * �������Լ�ʵ���˶��ķ���
	 */	
	@Override
	public abstract void move();
	
	
	/**
	 * ��ȡͼƬ����Ӧ���εķ���
	 */
	public Rectangle geRectangle() {
		return new Rectangle(x,y,width,height);
	}
}
