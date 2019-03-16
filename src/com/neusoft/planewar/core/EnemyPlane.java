package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import com.neusoft.planewar.client.PlaneWarClient;
import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.util.ImageUtil;
import com.neusoft.planewar.util.MusiceUtil;

public class EnemyPlane extends Plane {
	/**
	 * 敌方飞机的种类
	 */
	public int type;
	/**
	 * 多张图片组
	 */
	public static Image[] imgs = new Image[192];
	static {
		for (int i = 0; i < 11; i++) {
			imgs[i] = ImageUtil.images.get("enemyplane_1_" + (i + 1));
		}
		for (int i = 11; i < 22; i++) {
			imgs[i] = ImageUtil.images.get("enemyplane_2_" + (i - 10));
		}
		for (int i = 22; i < 33; i++) {
			imgs[i] = ImageUtil.images.get("enemyplane_3_" + (i - 21));
		}
		for (int i = 33; i < 47; i++) {
			imgs[i] = ImageUtil.images.get("enemyplane_4_" + (i - 32));
		}
		for (int i = 47; i < 60; i++) {
			imgs[i] = ImageUtil.images.get("enemyplane_5_" + (i - 46));
		}
		for (int i = 60; i < 73; i++) {
			imgs[i] = ImageUtil.images.get("enemyplane_6_" + (i - 59));
		}
		for (int i = 73; i < 84; i++) {
			imgs[i] = ImageUtil.images.get("enemyplane_7_" + (i - 72));
		}
		for (int i = 84; i < 93; i++) {
			imgs[i] = ImageUtil.images.get("enemyplane_8_" + (i - 83));
		}
		for (int i = 93; i < 103; i++) {
			imgs[i] = ImageUtil.images.get("enemyplane_9_" + (i - 92));
		}
		for (int i = 103; i < 111; i++) {
			imgs[i] = ImageUtil.images.get("enemyplane_10_" + (i - 102));
		}
		for (int i = 111; i < 120; i++) {
			imgs[i] = ImageUtil.images.get("enemyplane_11_" + (i - 110));
		}
		for (int i = 120; i < 129; i++) {
			imgs[i] = ImageUtil.images.get("enemyplane_12_" + (i - 119));
		}
		for (int i = 129; i < 138; i++) {
			imgs[i] = ImageUtil.images.get("enemyplane_13_" + (i - 128));
		}
		for (int i = 138; i < 149; i++) {
			imgs[i] = ImageUtil.images.get("enemyplane_14_" + (i - 137));
		}
		for (int i = 149; i < 162; i++) {
			imgs[i] = ImageUtil.images.get("enemyplane_15_" + (i - 148));
		}
		for (int i = 162; i < 170; i++) {
			imgs[i] = ImageUtil.images.get("enemyplane_16_" + (i - 161));
		}
		for (int i = 170; i < 181; i++) {
			imgs[i] = ImageUtil.images.get("enemyplane_17_" + (i - 169));
		}
		for (int i = 181; i < 192; i++) {
			imgs[i] = ImageUtil.images.get("enemyplane_18_" + (i - 180));
		}
	}

	/**
	 * 无参构造方法
	 */
	public EnemyPlane() {

	}

	/**
	 * 敌方飞机有参构造方法
	 * 
	 * @param x
	 * @param y
	 * @param key
	 */
	public EnemyPlane(int x, int y, String key) {
		this.x = x;
		this.y = y;
		this.img = ImageUtil.images.get(key);
		this.height = img.getHeight(null);
		this.width = img.getWidth(null);
		this.speed = 0.01;
		this.blood = Constant.ENEMYPLANE_MAX_BLOOD;
	}

	public EnemyPlane(PlaneWarClient pwc, int x, int y, int type, boolean good) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.pwc = pwc;
		this.height = imgs[0].getHeight(null);
		this.width = imgs[0].getWidth(null);
		this.speed = 5;
		this.good = good;
		this.blood = Constant.ENEMYPLANE_MAX_BLOOD;
		this.changenum = changenum;
	}

	double theta = Math.PI / 6;

	@Override
	public void move() {
		switch (type) {
		case 1:
			x+=speed*Math.cos(theta);
			y+=speed*Math.sin(theta);
			//上下边
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
		case 2:
			x+=speed*Math.cos(theta);
			y+=speed*Math.sin(theta);
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
		case 3:
			this.y -= speed/2;
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
		case 4:
			this.y += speed/2;
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
		case 5:
			this.y -= speed/2;
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
		case 6:
			this.y -= speed/2;
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
		case 7:
			this.y -= speed/2;
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
		case 8:
			this.x -= speed;
			break;
		case 9:
			this.y += speed/2;
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
		case 10:
			this.y -= speed/2;
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
		case 11:
			this.y -= speed/2;
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
		case 12:
			this.y -= speed/2;
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
		case 13:
			this.y += speed/2;
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
		case 14:
			this.y -= speed/2;
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
		case 15:
			this.y += speed/2;
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
		case 16:
			this.y -= speed/2;
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
		case 17:
			this.y -= speed/2;
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
		case 18:
			this.y -= speed/2;
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

	int count_1 = 0;
	int count_2 = 11;
	int count_3 = 22;
	int count_4 = 33;
	int count_5 = 47;
	int count_6 = 60;
	int count_7 = 73;
	int count_8 = 84;
	int count_9 = 93;
	int count_10 = 103;
	int count_11 = 111;
	int count_12 = 120;
	int count_13 = 129;
	int count_14 = 138;
	int count_15 = 149;
	int count_16 = 162;
	int count_17 = 170;
	int count_18 = 181;
	// 分数
	public static int score;

	@Override
	public void draw(Graphics g) {
		if (live && blood <= 0) {
			live = false;
			pwc.enemyplanes1.remove(this);
			pwc.enemyplanes2.remove(this);
			pwc.enemyplanes3.remove(this);
			Explode explode = new Explode(pwc, x, y);
			//new MusiceUtil("src/music/Explosion2.mp3", false).start();
			pwc.explodes.add(explode);
		}
		switch (changenum) {
		case 1:
			switch (type) {
			case 1:
				// 判断
				if (count_1 >= 11) {
					count_1 = 0;
				}
				g.drawImage(imgs[count_1], x, y, null);
				count_1++;
				break;
			case 2:
				// 判断
				if (count_2 >= 22) {
					count_2 = 11;
				}
				g.drawImage(imgs[count_2], x, y, null);
				count_2++;
				break;
			case 3:
				// 判断
				if (count_3 >= 33) {
					count_3 = 22;
				}
				g.drawImage(imgs[count_3], x, y, null);
				count_3++;
				break;
			case 4:
				// 判断
				if (count_4 >= 47) {
					count_4 = 33;
				}
				g.drawImage(imgs[count_4], x, y, null);
				count_4++;
				break;
			case 5:
				// 判断
				if (count_5 >= 60) {
					count_5 = 47;
				}
				g.drawImage(imgs[count_5], x, y, null);
				count_5++;
				break;
			case 6:
				// 判断
				if (count_6 >= 73) {
					count_6 = 60;
				}
				g.drawImage(imgs[count_6], x, y, null);
				count_6++;
				break;
			default:
				break;
			}
			move();
			// 条件限制
			if (r.nextInt(1000) > 950)
				fire();
		case 2:
			switch (type) {
			case 7:
				// 判断
				if (count_7 >= 84) {
					count_7 = 73;
				}
				g.drawImage(imgs[count_7], x, y, null);
				count_7++;
				break;
			case 8:
				// 判断
				if (count_8 >= 93) {
					count_8 = 84;
				}
				g.drawImage(imgs[count_8], x, y, null);
				count_8++;
				break;
			case 9:
				// 判断
				if (count_9 >= 103) {
					count_9 = 93;
				}
				g.drawImage(imgs[count_9], x, y, null);
				count_9++;
				break;
			case 10:
				// 判断
				if (count_10 >= 111) {
					count_10 = 103;
				}
				g.drawImage(imgs[count_10], x, y, null);
				count_10++;
				break;
			case 11:
				// 判断
				if (count_11 >= 120) {
					count_11 = 111;
				}
				g.drawImage(imgs[count_11], x, y, null);
				count_11++;
				break;
			case 12:
				// 判断
				if (count_12 >= 129) {
					count_12 = 120;
				}
				g.drawImage(imgs[count_12], x, y, null);
				count_12++;
				break;
			default:
				break;

			}
			move();
			// 条件限制
			if (r.nextInt(1000) > 950)
				fire();
		case 3:
			switch (type) {
			case 13:
				// 判断
				if (count_13 >= 138) {
					count_13 = 129;
				}
				g.drawImage(imgs[count_13], x, y, null);
				count_13++;
				break;
			case 14:
				// 判断
				if (count_14 >= 149) {
					count_14 = 138;
				}
				g.drawImage(imgs[count_14], x, y, null);
				count_14++;
				break;
			case 15:
				// 判断
				if (count_15 >= 162) {
					count_15 = 149;
				}
				g.drawImage(imgs[count_15], x, y, null);
				count_15++;
				break;
			case 16:
				// 判断
				if (count_16 >= 170) {
					count_16 = 162;
				}
				g.drawImage(imgs[count_16], x, y, null);
				count_16++;
				break;
			case 17:
				// 判断
				if (count_17 >= 181) {
					count_17 = 170;
				}
				g.drawImage(imgs[count_17], x, y, null);
				count_17++;
				break;
			case 18:
				// 判断
				if (count_18 >= 192) {
					count_18 = 181;
				}
				g.drawImage(imgs[count_18], x, y, null);
				count_18++;
				break;

			default:
				break;
			}
			move();
			// 条件限制
			if (r.nextInt(1000) > 950)
				fire();
		default:
			break;
		}
	}

	public static Random r = new Random();

	@Override
	public void fire() {
		switch (type) {
		case 1:
			// 发射子弹
			Missile m1 = new Missile(pwc, x - 5 - this.width / 6, y - 12 + this.height / 2, "m_01", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(m1);
			break;
		case 2:
			// 发射子弹
			Missile m2 = new Missile(pwc, x - 5 - this.width / 6, y - 12 + this.height / 2, "m_02", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(m2);
			break;
		case 3:
			// 发射子弹
			Missile m3 = new Missile(pwc, x + 25 - this.width / 6, y + 12 + this.height / 2, "m_03", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(m3);
			break;
		case 4:
			// 发射子弹
			Missile m4 = new Missile(pwc, x + 21 - this.width / 6, y - 6 + this.height / 2, "m_04", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(m4);
			break;
		case 5:
			// 发射子弹
			Missile m5 = new Missile(pwc, x + 21 - this.width / 6, y - 6 + this.height / 2, "m_05", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(m5);
			break;
		case 6:
			// 发射子弹
			Missile m6 = new Missile(pwc, x + 15 - this.width / 6, y + 10 + this.height / 2, "m_06", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(m6);
			break;
		case 7:
			// 发射子弹
			Missile m7 = new Missile(pwc, x - 12 - this.width / 6, y + this.height / 2, "m_07", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(m7);
			break;
		case 9:
			// 发射子弹
			Missile m9 = new Missile(pwc, x - 3 - this.width / 6, y - 20 + this.height / 2, "m_09", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(m9);
			break;
		case 10:
			// 发射子弹
			Missile m10 = new Missile(pwc, x - this.width / 6, y - 10 + this.height / 2, "m_010", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(m10);
			break;
		case 11:
			// 发射子弹
			Missile m11 = new Missile(pwc, x - this.width / 6, y - 15 + this.height / 2, "m_011", 1, good);
			// 向管家的missile中添加子
			pwc.missiles.add(m11);
			break;
		case 12:
			// 发射子弹
			Missile m12 = new Missile(pwc, x - this.width / 6, y - 15 + this.height / 2, "m_012", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(m12);
			break;
		case 13:
			// 发射子弹
			Missile m13 = new Missile(pwc, x - this.width / 6, y - 18 + this.height / 2, "m_013", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(m13);
			break;
		case 14:
			// 发射子弹
			Missile m14 = new Missile(pwc, x - this.width / 6, y + this.height / 2, "m_014", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(m14);
			break;
		case 15:
			// 发射子弹
			Missile m15 = new Missile(pwc, x - this.width / 6, y + this.height / 2, "m_015", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(m15);
			break;
		case 16:
			// 发射子弹
			Missile m16 = new Missile(pwc, x - 12 - this.width / 6, y - 25 + this.height / 2, "m_016", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(m16);
			break;
		case 17:
			// 发射子弹
			Missile m17 = new Missile(pwc, x - 3 - this.width / 6, y - 13 + this.height / 2, "m_017", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(m17);
			break;
		case 18:
			// 发射子弹
			Missile m18 = new Missile(pwc, x - 2 - this.width / 6, y - 10 + this.height / 2, "m_018", 1, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(m18);
			break;
		case 22:
			// 发射子弹
			Missile n1 = new Missile(pwc, x - this.width / 6, y + this.height / 2, "h_01_", type, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(n1);
			break;
		case 23:
			// 发射子弹
			Missile n2 = new Missile(pwc, x - this.width / 6, y + this.height / 2, "h_01_", type, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(n2);
			break;
		case 24:
			// 发射子弹
			Missile n3 = new Missile(pwc, x - this.width / 6, y + this.height / 2, "h_01_", type, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(n3);
			break;
		case 25:
			// 发射子弹
			Missile n4 = new Missile(pwc, x - this.width / 6, y + this.height / 2, "h_01_", type, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(n4);
			break;
		case 26:
			// 发射子弹
			Missile n5 = new Missile(pwc, x - this.width / 6, y + this.height / 2, "h_01_", type, good);
			// 向管家的missile中添加子弹
			pwc.missiles.add(n5);
			break;
			
		default:
			break;
		}
	}
}
