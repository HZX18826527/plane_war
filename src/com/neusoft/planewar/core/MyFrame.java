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
		this.setTitle("����������");
		this.setResizable(false);//�������¸ı��С
		this.enableInputMethods(false);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e){  
                System.exit(0);  
            }             
        });
		this.setBackground(Color.WHITE);
		
		//�����Զ����߳�
		new MyThread().start();
		}

	
	class MusicThread extends Thread {
		// ��дrun()����
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
		//��дrun()����
		@Override
		public void run() {
			while(true) {
				//���ۿ�ʶ��ÿ��20��
				//�����߳�˯��50ms
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
	
	//���ͼƬ��˸���⣬��˫���巽�������˸����
		Image backImg = null;
		//��дupdate�����������ڴ��������һ�������ͼƬ
		@Override
		public void update(Graphics g) {
			// TODO Auto-generated method stub
			if(backImg==null) {
				//�������ͼƬ�����ڣ�����һ���ʹ���һ����С��ͼƬ
				backImg=createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
			}
			//��ȡ����ͼƬ�Ļ���
			Graphics backg =backImg.getGraphics();
			Color c = backg.getColor();
			backg.setColor(Color.WHITE);
			backg.fillRect(0, 0,Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
			backg.setColor(c);
			//��������ͼƬ��paint����������û50msˢ��һ��
			paint(backg);
			g.drawImage(backImg, 0, 0, null);
		}
}
