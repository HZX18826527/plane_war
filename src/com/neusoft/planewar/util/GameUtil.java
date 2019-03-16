package com.neusoft.planewar.util;

import java.awt.Image;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;


//������ķ���ͨ��Ϊ��̬����
public class GameUtil {
	/**
	 * ��ȡͼƬ����
	 * 
	 * @param imagPathͼƬ�����·��
	 * @return img����
	 */
	public static Image getImage(String imagPath) {
		URL u = GameUtil.class.getClassLoader().getResource(imagPath);
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
}
