package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.neusoft.planewar.client.PlaneWarClient;

public abstract class PlaneWarObject implements Moveable, Drawable {
	//建立关系(大管家)
	//调停者设计模式
	public PlaneWarClient pwc;
	public int x;
	public int y;
	public Image img;
	public int width;
	public int height;
	public double speed;
	public static int changenum = 1;
	
	/**
	 * 所有飞机大战项目中统一的方法
	 */
	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
		move();
	}


	/**
	 * 让子类自己实现运动的方法
	 */	
	@Override
	public abstract void move();
	
	
	/**
	 * 获取图片所对应矩形的方法
	 */
	public Rectangle geRectangle() {
		return new Rectangle(x,y,width,height);
	}
}
