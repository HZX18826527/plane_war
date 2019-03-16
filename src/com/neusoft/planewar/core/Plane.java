package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Random;

import com.neusoft.planewar.client.PlaneWarClient;
import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.util.ImageUtil;
import com.neusoft.planewar.util.MusiceUtil;

public class Plane extends PlaneWarObject {
	public double speed = 10;
	public boolean left, up, right, down;
	public boolean start;
	private int score;
	public int blood;

	/**
	 * 多张图片组
	 */
	public static Image[] imgs = new Image[16];
	static {
		for (int i = 0; i < 16; i++) {
			imgs[i] = ImageUtil.images.get("myplane_" + (i + 1));
		}
	}

	/**
	 * 无参构造方法
	 */
	public Plane() {

	}

	public Plane(PlaneWarClient pwc, boolean good) {
		this.x = 200;
		this.y = 500;
		this.fire = false;
		this.superfire = false;
		this.pwc = pwc;
		this.img = ImageUtil.images.get("myplane_1");
		this.height = img.getHeight(null);
		this.width = img.getWidth(null);
		this.good = good;
		this.score = 0;
		this.blood = Constant.MYPLANE_MAX_BLOOD;
		this.changenum=changenum;
	}

	/**
	 * 有参构造方法
	 */
	public Plane(int x, int y, Image img, int width, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.img = img;
	}

	public Plane(int x, int y, String key) {
		this.x = x;
		this.y = y;
		this.img = ImageUtil.images.get(key);
		this.height = img.getHeight(null);
		this.width = img.getWidth(null);
	}

	@Override
	public void move() {
		if (left)
			x -= speed;
		if (right)
			x += speed;
		if (up)
			y -= speed;
		if (down)
			y += speed;
		outOfBounds();
		if (fire) {
			fire();
			new MusiceUtil("src/music/Bullet1.mp3", false).start();
		}
		if (superfire) {
			if (r.nextInt(1000) > 500) {
				fire();
				superfire();
				new MusiceUtil("src/music/Bullet2.mp3", false).start();
			}
		}
	}
	public static Random r = new Random();
	/**
	 * 判断我方飞机出界问题
	 * 
	 * @param e
	 */
	private void outOfBounds() {
		if (x <= 0)
			this.x = 0;
		if (x >= Constant.GAME_WIDTH - width)
			x = Constant.GAME_WIDTH - width;
		if (y <= 28)
			this.y = 28;
		if (y >= Constant.GAME_HEIGHT - height)
			y = Constant.GAME_HEIGHT - height;
	}

	/**
	 * 判断开火
	 */
	public boolean fire = true;
	public boolean superfire = true;
	public boolean live = true;

	// 按住键盘
	public void keyPressed(KeyEvent e) throws Exception {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			left = true;
			break;
		case KeyEvent.VK_D:
			right = true;
			break;
		case KeyEvent.VK_W:
			up = true;
			break;
		case KeyEvent.VK_S:
			down = true;
			break;
		case KeyEvent.VK_J:
			fire = true;
			break;
		case KeyEvent.VK_K:
			superfire = true;
			break;
		case KeyEvent.VK_Q:
			start = false;
			break;
		case KeyEvent.VK_E:
			start = true;
			break;
		default:
			break;
		}

	}

	// 松开键盘
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			left = false;
			break;
		case KeyEvent.VK_D:
			right = false;
			break;
		case KeyEvent.VK_W:
			up = false;
			break;
		case KeyEvent.VK_S:
			down = false;
			break;
		case KeyEvent.VK_J:
			fire = false;
			break;
		case KeyEvent.VK_K:
			superfire = false;
			break;
		default:
			break;
		}

	}

	public void fire() {
		// 发射子弹
		Missile m = new Missile(this.pwc, x + 23 + this.width / 2, y - 34 + this.height / 3, "h_01_1", 5, good);
		// 向管家的missile中添加子弹
		pwc.missiles.add(m);
	}

	public void superfire() {
		// 发射子弹
		Missile n1 = new Missile(this.pwc, x + 23 + this.width / 2, y - 34 + this.height / 3, "h_01_1", 5, good);
		Missile n2 = new Missile(this.pwc, x + 23 + this.width / 2, y - 34 + this.height / 3, "h_01_1", 5, good);
		Missile n3 = new Missile(this.pwc, x + 23 + this.width / 2, y - 34 + this.height / 3, "h_01_1", 5, good);
		Missile n4 = new Missile(this.pwc, x + 23 + this.width / 2, y - 34 + this.height / 3, "h_01_1", 5, good);
		Missile n5 = new Missile(this.pwc, x + 23 + this.width / 2, y - 34 + this.height / 3, "h_01_1", 5, good);
		pwc.missiles.add(n1);
		pwc.missiles.add(n2);
		pwc.missiles.add(n3);
		pwc.missiles.add(n4);
		pwc.missiles.add(n5);
	}

	/**
	 * 好飞机还是坏飞机
	 */
	public boolean good;

	public boolean isGood() {
		return good;
	}

	public void setGood(boolean good) {
		this.good = good;
	}

	public int count = 0;

	@Override
	public void draw(Graphics g) {
		if (live && blood <= 0) {
			live = false;
			Explode explode = new Explode(pwc, x, y);
			new MusiceUtil("src/music/Explosion2.mp3", false).start();
			pwc.explodes.add(explode);
			pwc.start(pwc);
			PlaneWarClient pwc = new PlaneWarClient();
			pwc.start(pwc);
			pwc.lodingFrame();
		}
		// 判断
		if (count >= 16) {
			count = 0;
		}
		g.drawImage(imgs[count], x, y, null);
		count++;
		move();

	}

	public int getScore() {
		return 5;
	}

}
