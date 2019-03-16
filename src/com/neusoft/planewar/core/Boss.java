package com.neusoft.planewar.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import com.neusoft.planewar.client.PlaneWarClient;
import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.util.ImageUtil;
import com.neusoft.planewar.util.MusiceUtil;

public class Boss extends Plane {

	public int type;

	public static Image[] imgs = new Image[31];
	static {
		for (int i = 0; i < 10; i++) {
			imgs[i] = ImageUtil.images.get("boss_1_" + (i + 1));
		}
		for (int i = 10; i < 20; i++) {
			imgs[i] = ImageUtil.images.get("boss_2_" + (i - 9));
		}
		for (int i = 20; i < 31; i++) {
			imgs[i] = ImageUtil.images.get("boss_3_" + (i - 19));
		}
	}

	/**
	 * 无参构造方法
	 */
	public Boss() {

	}

	/**
	 * 敌方飞机有参构造方法
	 * 
	 * @param x
	 * @param y
	 * @param key
	 */
	public Boss(int x, int y, String key) {
		this.x = x;
		this.y = y;
		this.img = ImageUtil.images.get(key);
		this.height = img.getHeight(null);
		this.width = img.getWidth(null);
		this.speed = 0.01;
		this.blood = Constant.BOOS_MAX_BLOOD;
	}

	public Boss(PlaneWarClient pwc, int x, int y, int type, boolean good) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.pwc = pwc;
		this.height = imgs[0].getHeight(null);
		this.width = imgs[0].getWidth(null);
		this.speed = 10;
		this.good = good;
		this.blood = Constant.BOOS_MAX_BLOOD;
	}

	double theta = Math.PI/6;
	@Override
	public void move() {
		switch (type) {
		case 19:
			this.x -= speed/2;
			if(y > Constant.GAME_HEIGHT-height||y<28)
				theta=-theta;
			//左右边
			if(x > Constant.GAME_WIDTH-width||x<400)
				theta=Math.PI-theta;
			if(speed<=0)
				speed=0;
			else
				speed-=0.000001;
			break;
		case 20:
			this.x -= speed/2;
			if(y > Constant.GAME_HEIGHT-height||y<28)
				theta=-theta;
			//左右边
			if(x > Constant.GAME_WIDTH-width||x<400)
				theta=Math.PI-theta;
			if(speed<=0)
				speed=0;
			else
				speed-=0.000001;
			break;
		case 21:
			this.x -= speed/2;
			if(y > Constant.GAME_HEIGHT-height||y<28)
				theta=-theta;
			//左右边
			if(x > Constant.GAME_WIDTH-width||x<400)
				theta=Math.PI-theta;
			if(speed<=0)
				speed=0;
			else
				speed-=0.000001;
			break;
		case 40:
			this.x -= speed/2;
			if(y > Constant.GAME_HEIGHT-height||y<28)
				theta=-theta;
			//左右边
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

	int count_19 = 10;
	int count_20 = 20;
	int count_21 = 31;

	@Override
	public void draw(Graphics g) {
		if (live && blood <= 0) {
			live = false;
			pwc.boss1.remove(this);
			pwc.boss2.remove(this);
			pwc.boss3.remove(this);
			Explode explode = new Explode(pwc, x, y);
			new MusiceUtil("src/music/Explosion2.mp3", false).start();
			new MusiceUtil("src/music/Victory1.mp3", false).start();
			pwc.explodes.add(explode);
			PlaneWarClient.changenum++;
			pwc.start(pwc);
			pwc.lodingFrame();
		}
		switch (PlaneWarClient.changenum) {
		case 1:
			// 判断
			if (count_19 >= 10) {
				count_19 = 0;
			}
			g.drawImage(imgs[count_19], x, y, null);
			count_19++;
			break;
		case 2:
			// 判断
			if (count_20 >= 20) {
				count_20 = 10;
			}
			g.drawImage(imgs[count_20], x, y, null);
			count_20++;
			break;
		case 3:
			// 判断
			if (count_21 >= 31) {
				count_21 = 20;
			}
			g.drawImage(imgs[count_21], x, y, null);
			count_21++;
			break;

		default:
			break;
		}
		move();
		if (r.nextInt(1000) > 500)
			fire();
	}
	public static Random r = new Random();
	
	@Override
	public void fire() {
		switch (type) {
		case 19:
			// 发射子弹
			Missile b1 = new Missile(pwc, x - 5 - this.width / 6, y - 12 + this.height / 2, "b_01", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(b1);
			break;
		case 20:
			// 发射子弹
			Missile b2 = new Missile(pwc, x - 5 - this.width / 6, y - 24 + this.height / 2, "b_02",1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(b2);
			break;
		case 21:
			// 发射子弹
			Missile b3 = new Missile(pwc, x + 25 - this.width / 6, y - 88 + this.height / 2, "b_03", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(b3);
			break;
		case 40:
			// 发射子弹
			Missile b4 = new Missile(pwc, x + 21 - this.width / 6, y - 6 + this.height / 2, "b_04", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(b4);
			break;
		case 41:
			// 发射子弹
			Missile b5 = new Missile(pwc, x + 21 - this.width / 6, y - 6 + this.height / 2, "b_05", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(b5);
			break;
		default:
			break;
		}
	}
}
