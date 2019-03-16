package com.neusoft.planewar.core;

import java.awt.Graphics;
import java.awt.Image;

import com.neusoft.planewar.client.PlaneWarClient;
import com.neusoft.planewar.util.ImageUtil;

public class Explode extends PlaneWarObject {

	/**
	 * ����ͼƬ��ը��
	 */
	public static Image[] imgs = new Image[13];
	static {
		for (int i = 0; i < 13; i++) {
			imgs[i] = ImageUtil.images.get("e_" + (i + 1));
		}
	}

	public Explode() {

	}

	public Explode(PlaneWarClient pwc, int x, int y) {
		this.pwc = pwc;
		this.x = x;
		this.y = y;
		this.height = imgs[0].getHeight(null);
		this.width = imgs[0].getWidth(null);
	}

	public boolean live = true;

	public int count = 0;

	@Override
	public void draw(Graphics g) {
		// �ж�
		if (count >= 13) {
			count = 0;
			live = false;
			pwc.explodes.remove(this);
			return;
		}
		g.drawImage(imgs[count++], x, y, null);
	}

	@Override
	public void move() {
		// ����Ҫʹ��
	}

}
