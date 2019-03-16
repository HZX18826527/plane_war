package com.neusoft.planewar.util;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusiceUtil extends Thread {
	// 创建一个播放器对象
	private Player player;
	// 创建一个音乐文件
	private File musicFile;
	private boolean loop;
	private boolean stop;
	public MusiceUtil() {
		
	}

	public MusiceUtil(String musicPath) {
		musicFile = new File(musicPath);
	}
	
	public MusiceUtil(String musicPath,boolean loop) {
		this(musicPath);
		this.loop=loop;
	}
	

	@Override
	public void run() {
		super.run();
		try {
			if(loop)
				while(true) {
					play();
				}
			else {
				play();
			}
		} catch (FileNotFoundException | JavaLayerException e) {
			e.printStackTrace();
		}

	}

	public void play() throws FileNotFoundException , JavaLayerException {
		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(musicFile));
		player = new Player(buffer);
		player.play();

	}
}