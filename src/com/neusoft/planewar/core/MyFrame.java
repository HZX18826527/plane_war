package com.neusoft.planewar.core;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.neusoft.planewar.constant.Constant;

public class MyFrame extends Frame {
	public void lodingFrame() {
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		//this.setLocation(0, 0);
		this.setLocationRelativeTo(null);
		this.setTitle("公主斗恶龙");
		this.setResizable(false);//不能重新改变大小
		this.enableInputMethods(false);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e){  
                System.exit(0);  
            }             
        });
		this.setBackground(Color.WHITE);
		
		//启动自定义线程
		new MyThread().start();
		}

	
	class MusicThread extends Thread {
		// 重写run()方法
		@Override
		public void run() {
			while (true) {
				
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	class MyThread extends Thread {
		//重写run()方法
		@Override
		public void run() {
			while(true) {
				//人眼可识别每秒20次
				//设置线程睡眠50ms
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//解决图片闪烁问题，用双缓冲方法解决闪烁问题
		Image backImg = null;
		//重写update（）方法，在窗口里添加一个虚拟的图片
		@Override
		public void update(Graphics g) {
			// TODO Auto-generated method stub
			if(backImg==null) {
				//如果虚拟图片不存在，创建一个和窗口一样大小的图片
				backImg=createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
			}
			//获取虚拟图片的画笔
			Graphics backg =backImg.getGraphics();
			Color c = backg.getColor();
			backg.setColor(Color.WHITE);
			backg.fillRect(0, 0,Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
			backg.setColor(c);
			//调用虚拟图片的paint（）方法，没50ms刷新一次
			paint(backg);
			g.drawImage(backImg, 0, 0, null);
		}
}
