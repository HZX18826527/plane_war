package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.Image;

import com.neusoft.planewar.client.PlaneWarClient;
import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.util.ImageUtil;

public class Cream extends Plane {
	
	public int type;
	
	public static Image[] imgs = new Image[32];
	static {
		for (int i = 0; i < 8; i++) {
			imgs[i] = ImageUtil.images.get("cream_1_" + (i + 1));
		}
		for (int i = 8; i < 16; i++) {
			imgs[i] = ImageUtil.images.get("cream_2_" + (i - 7));
		}
		for (int i = 16; i < 24; i++) {
			imgs[i] = ImageUtil.images.get("cream_3_" + (i - 15));
		}
		for (int i = 24; i < 32; i++) {
			imgs[i] = ImageUtil.images.get("cream_4_" + (i - 23));
		}
	}
	
	/**
	 * ÎÞ²Î¹¹Ôì·½·¨
	 */
	public Cream() {

	}

	/**
	 * µÐ·½·É»úÓÐ²Î¹¹Ôì·½·¨
	 * 
	 * @param x
	 * @param y
	 * @param key
	 */
	public Cream(int x, int y, String key) {
		this.x = x;
		this.y = y;
		this.img = ImageUtil.images.get(key);
		this.height = img.getHeight(null);
		this.width = img.getWidth(null);
		this.speed = 0.01;
		this.blood=Constant.CREAM_MAX_BLOOD;
	}

	public Cream(PlaneWarClient pwc, int x, int y, int type, boolean good) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.pwc = pwc;
		this.height = imgs[0].getHeight(null);
		this.width = imgs[0].getWidth(null);
		this.speed = 10;
		this.good = good;
		this.blood=Constant.CREAM_MAX_BLOOD;
	}
	double theta = Math.PI/6;
	@Override
	public void move() {
		switch (type) {
		case 30:
			x+=speed*Math.cos(theta);
			y+=speed*Math.sin(theta);
			if(y > Constant.GAME_HEIGHT-height||y<28)
				theta=-theta;
			//×óÓÒ±ß
			if(x > Constant.GAME_WIDTH-width||x<400)
				theta=Math.PI-theta;
			if(speed<=0)
				speed=0;
			else
				speed-=0.000001;
			break;
		case 31:
			x+=speed*Math.cos(theta);
			y+=speed*Math.sin(theta);
			if(y > Constant.GAME_HEIGHT-height||y<28)
				theta=-theta;
			//×óÓÒ±ß
			if(x > Constant.GAME_WIDTH-width||x<400)
				theta=Math.PI-theta;
			if(speed<=0)
				speed=0;
			else
				speed-=0.000001;
			break;
		case 32:
			x+=speed*Math.cos(theta);
			y+=speed*Math.sin(theta);
			if(y > Constant.GAME_HEIGHT-height||y<28)
				theta=-theta;
			//×óÓÒ±ß
			if(x > Constant.GAME_WIDTH-width||x<400)
				theta=Math.PI-theta;
			if(speed<=0)
				speed=0;
			else
				speed-=0.000001;
			break;
		case 33:
			x+=speed*Math.cos(theta);
			y+=speed*Math.sin(theta);
			if(y > Constant.GAME_HEIGHT-height||y<28)
				theta=-theta;
			//×óÓÒ±ß
			if(x > Constant.GAME_WIDTH-width||x<400)
				theta=Math.PI-theta;
			if(speed<=0)
				speed=0;
			else
				speed-=0.000001;
			break;
			
		default:
			break;
		}
	}
	
	int count_30 = 8;int count_31 = 16;int count_32 = 24;int count_33=32;
	
	@Override
	public void draw(Graphics g) {
		if(live&&blood<=0) {
			live=false;
			pwc.creams.remove(this);
		}
		switch (type) {
		case 30:
			// ÅÐ¶Ï
			if (count_30 >= 8) {
				count_30 = 0;
			}
			g.drawImage(imgs[count_30], x, y, null);
			count_30++;
			break;
		case 31:
			// ÅÐ¶Ï
			if (count_31 >= 16) {
				count_31 = 8;
			}
			g.drawImage(imgs[count_31], x, y, null);
			count_31++;
			break;
		case 32:
			// ÅÐ¶Ï
			if (count_32 >= 24) {
				count_32 = 16;
			}
			g.drawImage(imgs[count_32], x, y, null);
			count_32++;
			break;
		case 33:
			// ÅÐ¶Ï
			if (count_33 >= 32) {
				count_33 = 24;
			}
			g.drawImage(imgs[count_33], x, y, null);
			count_33++;
			break;
			
		default:
			break;
		} 
		move();
	}
	
}

