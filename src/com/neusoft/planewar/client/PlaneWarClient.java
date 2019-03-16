package com.neusoft.planewar.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import com.neusoft.planewar.core.BackGround;
import com.neusoft.planewar.core.Boss;
import com.neusoft.planewar.core.Cream;
import com.neusoft.planewar.core.EnemyPlane;
import com.neusoft.planewar.core.Explode;
import com.neusoft.planewar.core.Missile;
import com.neusoft.planewar.core.MyFrame;
import com.neusoft.planewar.core.Plane;
import com.neusoft.planewar.util.ImageUtil;
import com.neusoft.planewar.util.MusiceUtil;

public class PlaneWarClient extends MyFrame {

	public BackGround bg1 = new BackGround(this);

	// 我方飞机对象
	public Plane myplane = new Plane(this, true);
	// 敌方飞机对象

	// 存放子弹容器
	public List<Missile> missiles = new ArrayList<>();

	// 存放地方飞机的容器
	public List<EnemyPlane> enemyplanes1 = new ArrayList<>();
	public List<EnemyPlane> enemyplanes2 = new ArrayList<>();
	public List<EnemyPlane> enemyplanes3 = new ArrayList<>();
	// 存放Boss
	public List<Boss> boss1 = new ArrayList<>();
	public List<Boss> boss2 = new ArrayList<>();
	public List<Boss> boss3 = new ArrayList<>();
	// 存放精英
	public List<Cream> creams = new ArrayList<>();
	public static int changenum = 1;

	public void init(PlaneWarClient pwc, int changenum) {
		pwc.boss1.clear();
		pwc.boss2.clear();
		pwc.boss3.clear();
		switch (changenum) {
		case 1:
			for (int i = 0; i < 10; i++) {
				EnemyPlane enemyplane_1 = new EnemyPlane(pwc, 500 +  + (i * 80 + 15), 10 + (i * 80 + 15), 1, false);
				pwc.enemyplanes1.add(enemyplane_1);
			}
			for (int i = 0; i < 10; i++) {
				EnemyPlane enemyplane_2 = new EnemyPlane(pwc, 500 + (i * 80 + 15), 500 + (i * 80 + 15), 2, false);
				pwc.enemyplanes1.add(enemyplane_2);
			}
			for (int i = 0; i < 10; i++) {
				EnemyPlane enemyplane_3 = new EnemyPlane(pwc, 900 , 1800 + (i * 80 + 80), 3, false);
				pwc.enemyplanes1.add(enemyplane_3);
			}
			for (int i = 0; i < 10; i++) {
				EnemyPlane enemyplane_4 = new EnemyPlane(pwc, 1200 , -3800 + (i * 80 + 15), 4, false);
				pwc.enemyplanes1.add(enemyplane_4);
			}
			for (int i = 0; i < 10; i++) {
				EnemyPlane enemyplane_5 = new EnemyPlane(pwc, 500 + (i * 80 + 15), 4000 + (i * 80 + 15), 5, false);
				pwc.enemyplanes1.add(enemyplane_5);
			}
			for (int i = 0; i < 10; i++) {
				EnemyPlane enemyplane_6 = new EnemyPlane(pwc, 700 + (i * 80 + 15), 4800 + (i * 80 + 15), 6, false);
				pwc.enemyplanes1.add(enemyplane_6);
			}
			for (int i = 0; i < 1; i++) {
				Boss boss_1 = new Boss(pwc, 5000, 350, 19, false);
				pwc.boss1.add(boss_1);
			}
			for (int i = 0; i < 1; i++) {
				Cream cream_1 = new Cream(pwc, 2550, 100, 30, false);
				pwc.creams.add(cream_1);
			}
			for (int i = 0; i < 1; i++) {
				Cream cream_2 = new Cream(pwc, 4550, 100, 31, false);
				pwc.creams.add(cream_2);
			}
			for (int i = 0; i < 1; i++) {
				Cream cream_3 = new Cream(pwc, 5550, 750, 32, false);
				pwc.creams.add(cream_3);
			}
			for (int i = 0; i < 1; i++) {
				Cream cream_4 = new Cream(pwc, 5150, 750, 33, false);
				pwc.creams.add(cream_4);
			}
			break;
		case 2:
			for (int i = 0; i < 10; i++) {
				EnemyPlane enemyplane_7 = new EnemyPlane(pwc, 500 + (i * 80 + 15), 5200 + (i * 80 + 15), 7, false);
				pwc.enemyplanes2.add(enemyplane_7);
			}
			for (int i = 0; i < 10; i++) {
				EnemyPlane enemyplane_8 = new EnemyPlane(pwc,  5000 + (i * 80 + 15), 200 + (i * 80 + 15), 8, false);
				pwc.enemyplanes2.add(enemyplane_8);
			}
			for (int i = 0; i < 10; i++) {
				EnemyPlane enemyplane_9 = new EnemyPlane(pwc, 400 + (i * 80 + 15), -5500 - (i * 80 + 15), 9, false);
				pwc.enemyplanes2.add(enemyplane_9);
			}
			for (int i = 0; i < 10; i++) {
				EnemyPlane enemyplane_10 = new EnemyPlane(pwc, 600 + (i * 80 + 15), 6800 + (i * 80 + 15), 10, false);
				pwc.enemyplanes2.add(enemyplane_10);
			}
			for (int i = 0; i < 10; i++) {
				EnemyPlane enemyplane_11 = new EnemyPlane(pwc,  500 + (i * 80 + 15), 5800 + (i * 80 + 15), 11, false);
				pwc.enemyplanes2.add(enemyplane_11);
			}
			for (int i = 0; i < 10; i++) {
				EnemyPlane enemyplane_12 = new EnemyPlane(pwc, 500 + (i * 80 + 15), 7500 + (i * 80 + 15), 12, false);
				pwc.enemyplanes2.add(enemyplane_12);
			}
			for (int i = 0; i < 1; i++) {
				Boss boss_2 = new Boss(pwc, 5800, 350, 20, false);
				pwc.boss2.add(boss_2);
			}
			for (int i = 0; i < 1; i++) {
				Cream cream_1 = new Cream(pwc, 2550, 100, 30, false);
				pwc.creams.add(cream_1);
			}
			for (int i = 0; i < 1; i++) {
				Cream cream_2 = new Cream(pwc, 4550, 100, 31, false);
				pwc.creams.add(cream_2);
			}
			for (int i = 0; i < 1; i++) {
				Cream cream_3 = new Cream(pwc, 5550, 750, 32, false);
				pwc.creams.add(cream_3);
			}
			for (int i = 0; i < 1; i++) {
				Cream cream_4 = new Cream(pwc, 5150, 750, 33, false);
				pwc.creams.add(cream_4);
			}
			break;
		case 3:
			for (int i = 0; i < 10; i++) {
				EnemyPlane enemyplane_13 = new EnemyPlane(pwc, 500 + (i * 80 + 15), 5300 - (i * 80 + 15), 13, false);
				pwc.enemyplanes3.add(enemyplane_13);
			}
			for (int i = 0; i < 10; i++) {
				EnemyPlane enemyplane_14 = new EnemyPlane(pwc,  500 + (i * 80 + 15), 5900 + (i * 80 + 15), 14, false);
				pwc.enemyplanes3.add(enemyplane_14);
			}
			for (int i = 0; i < 10; i++) {
				EnemyPlane enemyplane_15 = new EnemyPlane(pwc, 500 + (i * 80 + 15), -6500 - (i * 80 + 15), 15, false);
				pwc.enemyplanes3.add(enemyplane_15);
			}
			for (int i = 0; i < 10; i++) {
				EnemyPlane enemyplane_16 = new EnemyPlane(pwc, 550 + (i * 80 + 15), 7100 + (i * 80 + 15), 16, false);
				pwc.enemyplanes3.add(enemyplane_16);
			}
			for (int i = 0; i < 10; i++) {
				EnemyPlane enemyplane_17 = new EnemyPlane(pwc,500 + (i * 80 + 15), 7700 + (i * 80 + 15), 17, false);
				pwc.enemyplanes3.add(enemyplane_17);
			}
			for (int i = 0; i < 10; i++) {
				EnemyPlane enemyplane_18 = new EnemyPlane(pwc, 300 + (i * 80 + 15), 8300 + (i * 80 + 15), 18, false);
				pwc.enemyplanes3.add(enemyplane_18);
			}
			for (int i = 0; i < 1; i++) {
				Boss boss_3 = new Boss(pwc, 6300, 350, 21, false);
				pwc.boss3.add(boss_3);
			}
			for (int i = 0; i < 1; i++) {
				Cream cream_1 = new Cream(pwc, 2550, 100, 30, false);
				pwc.creams.add(cream_1);
			}
			for (int i = 0; i < 1; i++) {
				Cream cream_2 = new Cream(pwc, 4550, 100, 31, false);
				pwc.creams.add(cream_2);
			}
			for (int i = 0; i < 1; i++) {
				Cream cream_3 = new Cream(pwc, 4850, 750, 32, false);
				pwc.creams.add(cream_3);
			}
			for (int i = 0; i < 1; i++) {
				Cream cream_4 = new Cream(pwc, 4050, 750, 33, false);
				pwc.creams.add(cream_4);
			}
			break;
		default:
			break;

		}
		pwc.missiles.clear();
	}

	@Override
	public void lodingFrame() {
		super.lodingFrame();
		// 添加键盘监听器
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					myplane.keyPressed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

				myplane.keyReleased(e);
			}
		});
		// 启动音乐进程
		new MusiceUtil("src/music/MONACA - 砂塵ノ記憶：丁.mp3", false).start();
	}

	public List<Explode> explodes = new ArrayList<>();

	@Override
	public void paint(Graphics g) {
		super.paintComponents(g);
		switch (changenum) {
		case 1:
			bg1.draw(g);
			if (myplane.live)
				myplane.draw(g);
			// 敌方飞机
			for (int i = 0; i < enemyplanes1.size(); i++) {
				EnemyPlane enemyplane = enemyplanes1.get(i);
				enemyplane.draw(g);
			}
			for (int i = 0; i < boss1.size(); i++) {
				Boss boss = boss1.get(i);
				boss.draw(g);
			}
			for (int i = 0; i < creams.size(); i++) {
				Cream cream = creams.get(i);
				cream.draw(g);
			}
			for (int i = 0; i < missiles.size(); i++) {
				Missile missile = missiles.get(i);
				missile.draw(g);
				missile.hitPlanes(enemyplanes1);
				missile.hitPlanes1(boss1);
				missile.hitPlanes2(creams);
				if (myplane.live)
					missile.hitPlane(myplane);
			}

			for (int i = 0; i < explodes.size(); i++) {
				Explode explode = explodes.get(i);
				explode.draw(g);
			}
			Missile m = new Missile();
			g.setColor(Color.WHITE);
			g.setFont(new Font("微软雅黑", Font.BOLD, 30));
			// g.drawString("plane's speed:" + myplane.x + myplane.y, 50, 100);
			// g.drawString("missiles's size:" + missiles.size(), 50, 150);
			g.drawString("enemyplaen's size:" + enemyplanes1.size(), 50, 60);
			g.drawString("score:" + m.score, 50, 100);
			g.drawString("life:" + myplane.blood, 50, 150);
			break;
		case 2:
			if (myplane.live)
				myplane.draw(g);
			// 敌方飞机
			for (int i = 0; i < enemyplanes2.size(); i++) {
				EnemyPlane enemyplane = enemyplanes2.get(i);
				enemyplane.draw(g);
			}
			for (int i = 0; i < boss2.size(); i++) {
				Boss boss = boss2.get(i);
				boss.draw(g);
			}
			for (int i = 0; i < creams.size(); i++) {
				Cream cream = creams.get(i);
				cream.draw(g);
			}
			for (int i = 0; i < missiles.size(); i++) {
				Missile missile = missiles.get(i);
				missile.draw(g);
				missile.hitPlanes(enemyplanes2);
				missile.hitPlanes1(boss2);
				missile.hitPlanes2(creams);
				if (myplane.live)
					missile.hitPlane(myplane);
			}

			for (int i = 0; i < explodes.size(); i++) {
				Explode explode = explodes.get(i);
				explode.draw(g);
			}
			Missile m1 = new Missile();
			g.setColor(Color.WHITE);
			g.setFont(new Font("微软雅黑", Font.BOLD, 30));
			// g.drawString("plane's speed:" + myplane.x + myplane.y, 50, 100);
			// g.drawString("missiles's size:" + missiles.size(), 50, 150);
			g.drawString("enemyplaen's size:" + enemyplanes2.size(), 50, 60);
			g.drawString("score:" + m1.score, 50, 100);
			g.drawString("life:" + myplane.blood, 50, 150);
			break;
		default:
			if (myplane.live)
				myplane.draw(g);
			// 敌方飞机
			for (int i = 0; i < enemyplanes3.size(); i++) {
				EnemyPlane enemyplane = enemyplanes3.get(i);
				enemyplane.draw(g);
			}
			for (int i = 0; i < boss3.size(); i++) {
				Boss boss = boss3.get(i);
				boss.draw(g);
			}
			for (int i = 0; i < creams.size(); i++) {
				Cream cream = creams.get(i);
				cream.draw(g);
			}
			for (int i = 0; i < missiles.size(); i++) {
				Missile missile = missiles.get(i);
				missile.draw(g);
				missile.hitPlanes(enemyplanes3);
				missile.hitPlanes1(boss3);
				missile.hitPlanes2(creams);
				if (myplane.live)
					missile.hitPlane(myplane);
			}

			for (int i = 0; i < explodes.size(); i++) {
				Explode explode = explodes.get(i);
				explode.draw(g);
			}
			Missile m2 = new Missile();
			g.setColor(Color.WHITE);
			g.setFont(new Font("微软雅黑", Font.BOLD, 30));
			// g.drawString("plane's speed:" + myplane.x + myplane.y, 50, 100);
			// g.drawString("missiles's size:" + missiles.size(), 50, 150);
			g.drawString("enemyplaen's size:" + enemyplanes3.size(), 50, 60);
			g.drawString("score:" + m2.score, 50, 100);
			g.drawString("life:" + myplane.blood, 50, 150);
			break;
		}

	}

	public void start(PlaneWarClient pwc) {
		switch (changenum) {
		case 1:
			Panel startP1 = new Panel() {
				@Override
				public void paint(Graphics g) {
					Image img1 = ImageUtil.images.get("Book1");
					// 图片随窗体大小而变化
					g.drawImage(img1, 0, 0, pwc.getSize().width, pwc.getSize().height, pwc);
					super.paint(g);
				}
			};
			Label startL1 = new Label("按任意键开始游戏。。。");
			pwc.setLayout(null);
			pwc.add(startP1);
			startP1.setBounds(0, 0, 1500, 800);
			startP1.add(startL1);
			startP1.setLayout(null);
			startL1.setBackground(Color.black);
			startL1.setForeground(Color.white);
			startL1.setFont(new Font("宋体", Font.BOLD, 30));
			startL1.setBounds(580, 700, 400, 30);
			pwc.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					pwc.remove(startP1);
					pwc.removeKeyListener(this);
					pwc.init(pwc, changenum);
				}
			});
			break;
		case 2:
			Panel startP2 = new Panel() {
				@Override
				public void paint(Graphics g) {
					Image img1 = ImageUtil.images.get("Book2");
					// 图片随窗体大小而变化
					g.drawImage(img1, 0, 0, pwc.getSize().width, pwc.getSize().height, pwc);
					super.paint(g);
				}
			};
			Label startL2 = new Label("按任意键开始游戏。。。");
			pwc.setLayout(null);
			pwc.add(startP2);
			startP2.setBounds(0, 0, 1500, 800);
			startP2.add(startL2);
			startP2.setLayout(null);
			startL2.setBackground(Color.black);
			startL2.setForeground(Color.white);
			startL2.setFont(new Font("宋体", Font.BOLD, 30));
			startL2.setBounds(580, 700, 400, 30);
			pwc.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					pwc.remove(startP2);
					pwc.removeKeyListener(this);
					pwc.init(pwc, changenum);
				}
			});
			break;
		case 3:
			Panel startP3 = new Panel() {
				@Override
				public void paint(Graphics g) {
					Image img1 = ImageUtil.images.get("Book3");
					// 图片随窗体大小而变化
					g.drawImage(img1, 0, 0, pwc.getSize().width, pwc.getSize().height, pwc);
					super.paint(g);
				}
			};
			Label startL3 = new Label("按任意键开始游戏。。。");
			pwc.setLayout(null);
			pwc.add(startP3);
			startP3.setBounds(0, 0, 1500, 800);
			startP3.add(startL3);
			startP3.setLayout(null);
			startL3.setBackground(Color.black);
			startL3.setForeground(Color.white);
			startL3.setFont(new Font("宋体", Font.BOLD, 30));
			startL3.setBounds(580, 700, 400, 30);
			pwc.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					pwc.remove(startP3);
					pwc.removeKeyListener(this);
					pwc.init(pwc, changenum);
				}
			});
			break;
		default:
			Panel startP4 = new Panel() {
				@Override
				public void paint(Graphics g) {
					Image img1 = ImageUtil.images.get("Book4");
					// 图片随窗体大小而变化
					g.drawImage(img1, 0, 0, pwc.getSize().width, pwc.getSize().height, pwc);
					super.paint(g);
				}
			};
			Label startL4 = new Label("按任意键开始游戏。。。");
			pwc.setLayout(null);
			pwc.add(startP4);
			startP4.setBounds(0, 0, 1500, 800);
			startP4.add(startL4);
			startP4.setLayout(null);
			startL4.setBackground(Color.black);
			startL4.setForeground(Color.white);
			startL4.setFont(new Font("宋体", Font.BOLD, 30));
			startL4.setBounds(580, 700, 400, 30);
			pwc.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					pwc.remove(startP4);
					pwc.removeKeyListener(this);
					pwc.init(pwc, changenum);
				}
			});
			break;
		}

	}

	public static void main(String[] args) {
		PlaneWarClient pwc = new PlaneWarClient();
		pwc.start(pwc);
		pwc.lodingFrame();
	}
}