package com.neusoft.planewar.core;

import java.awt.Graphics;

import com.neusoft.planewar.client.PlaneWarClient;
import com.neusoft.planewar.util.ImageUtil;

public class BackGround extends PlaneWarObject {
	
	public BackGround() {
		
	}
	
	public BackGround(PlaneWarClient pwc) {
			this.pwc=pwc;
			this.img=ImageUtil.images.get("bg1");
			this.x=0;
			this.y=0;
			this.speed=20;
	}

	@Override
	public void move() {
		this.x-=5;
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		
	}
}
