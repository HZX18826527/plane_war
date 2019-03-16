package com.neusoft.planewar.util;

import java.awt.Image;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;


//工具类的方法通常为静态方法
public class GameUtil {
	/**
	 * 获取图片方法
	 * 
	 * @param imagPath图片的相对路径
	 * @return img对象
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
