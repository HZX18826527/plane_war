package com.neusoft.planewar.core;

import java.util.List;

import com.neusoft.planewar.client.PlaneWarClient;
import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.core.MyFrame.MyThread;
import com.neusoft.planewar.util.ImageUtil;
import com.neusoft.planewar.util.MusiceUtil;

public class Missile extends PlaneWarObject {
	public int type;
	public boolean live;
	
	public Missile() {

	}

	public Missile(PlaneWarClient pwc, int x, int y, String key, boolean good) {
		this.pwc = pwc;
		this.live = true;
		this.x = x;
		this.y = y;
		this.img = ImageUtil.images.get(key);
		this.speed = 30;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.good = good;
	}

	/**
	 * 子弹类型
	 * 
	 * @param pwc
	 * @param x
	 * @param y
	 * @param key
	 */
	public Missile(PlaneWarClient pwc, int x, int y, String key, int type, boolean good) {
		this(pwc, x, y, key, good);
		this.good = good;
		this.type = type;
	}

	@Override
	public void move() {
		switch (type) {
		case 1:
			this.x -= speed;
			break;
		case 2:
			this.x -= speed;
			break;
		case 3:
			this.x -= speed;
			break;
		case 4:
			this.x -= speed;
			break;
		case 5:
			this.x += speed;
			break;
			
		default:
			this.x -= speed;
			break;
		}
		outOfBounds();
	}

	/**
	 * 子弹出界判断方法
	 */
	private void outOfBounds() {
		if (x <= 0 || x >= Constant.GAME_WIDTH - width || y <= 28 || y >= Constant.GAME_HEIGHT - height) {
			this.live = false;
			pwc.missiles.remove(this);
		}
	}

	/**
	 * 子弹击打飞机的方法
	 */
	//分数
	public static int score;
	
	public boolean hitPlane(Plane p) {
		if (this.geRectangle().intersects(p.geRectangle()) && this.good != p.isGood()) {
			this.live = false;
			// 飞机减血
			p.blood-=20;
			// 打飞机死
			pwc.missiles.remove(this);
			if(p.blood==0) {
				score+=p.getScore();
			}
			return true;
		}
		return false;
	}

	public boolean hitPlanes(List<EnemyPlane> es) {
		for (int i = 0; i < es.size(); i++) {
			EnemyPlane enemyplane = es.get(i);
			if (this.hitPlane(enemyplane)) {
				return true;
			}
		}
		return false;
	}
	public boolean hitPlanes1(List<Boss> q) {
		for (int i = 0; i < q.size(); i++) {
			Boss boss = q.get(i);
			if (this.hitPlane(boss)) {
				return true;
			}
		}
		return false;
	}
	public boolean hitPlanes2(List<Cream> p) {
		for (int i = 0; i < p.size(); i++) {
			Cream cream = p.get(i);
			if (this.hitPlane(cream)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 判断我方发出还是敌方发出
	 */
	public boolean good;

	public boolean isGood() {
		return good;
	}

	public void setGood(boolean good) {
		this.good = good;
	}
}
