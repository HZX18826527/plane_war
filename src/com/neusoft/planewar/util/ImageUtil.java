package com.neusoft.planewar.util;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import com.neusoft.planewar.constant.Constant;

/**
 * 存放项目中所有的图片<br>
 * 使用Map结构存放时，使用静态代码块和<br>
 * @author XY
 *
 */
public class ImageUtil {
	public static Map<String,Image> images = new HashMap<>();
	static {
		//我方飞机
		for(int i = 1;i<=16;i++)
			images.put("myplane_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/hero_01_"+i+".png"));
		//boss
		for(int i = 1;i<=10;i++)
			images.put("boss_1_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/boss/boss_01_"+i+".png"));
		for(int i = 1;i<=10;i++)
			images.put("boss_2_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/boss/boss_02_"+i+".png"));
		for(int i = 1;i<=11;i++)
			images.put("boss_3_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/boss/boss_03_"+i+".png"));
		//精英
		for(int i = 1;i<=8;i++)
			images.put("cream_1_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/cream/j_01_"+i+".png"));
		for(int i = 1;i<=8;i++)
			images.put("cream_2_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/cream/j_02_"+i+".png"));
		for(int i = 1;i<=8;i++)
			images.put("cream_3_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/cream/j_03_"+i+".png"));
		for(int i = 1;i<=8;i++)
			images.put("cream_4_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/cream/j_04_"+i+".png"));
		//敌方飞机
		for(int i = 1;i<=11;i++)
			images.put("enemyplane_1_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/g_01_"+i+".png"));
		for(int i = 1;i<=11;i++)
			images.put("enemyplane_2_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/g_02_"+i+".png"));
		for(int i = 1;i<=11;i++)
			images.put("enemyplane_3_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/g_03_"+i+".png"));
		for(int i = 1;i<=14;i++)
			images.put("enemyplane_4_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/g_04_"+i+".png"));
		for(int i = 1;i<=13;i++)
			images.put("enemyplane_5_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/g_05_"+i+".png"));
		for(int i = 1;i<=13;i++)
			images.put("enemyplane_6_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/g_06_"+i+".png"));
		for(int i = 1;i<=11;i++)
			images.put("enemyplane_7_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/g_07_"+i+".png"));
		for(int i = 1;i<=9;i++)
			images.put("enemyplane_8_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/g_08_"+i+".png"));
		for(int i = 1;i<=10;i++)
			images.put("enemyplane_9_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/g_09_"+i+".png"));
		for(int i = 1;i<=8;i++)
			images.put("enemyplane_10_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/g_010_"+i+".png"));
		for(int i = 1;i<=9;i++)
			images.put("enemyplane_11_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/g_011_"+i+".png"));
		for(int i = 1;i<=9;i++)
			images.put("enemyplane_12_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/g_012_"+i+".png"));
		for(int i = 1;i<=9;i++)
			images.put("enemyplane_13_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/g_013_"+i+".png"));
		for(int i = 1;i<=11;i++)
			images.put("enemyplane_14_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/g_014_"+i+".png"));
		for(int i = 1;i<=13;i++)
			images.put("enemyplane_15_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/g_015_"+i+".png"));
		for(int i = 1;i<=8;i++)
			images.put("enemyplane_16_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/g_016_"+i+".png"));
		for(int i = 1;i<=11;i++)
			images.put("enemyplane_17_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/g_017_"+i+".png"));
		for(int i = 1;i<=11;i++)
			images.put("enemyplane_18_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/g_018_"+i+".png"));
		//我方飞机子弹
		images.put("h_01_1", GameUtil.getImage(Constant.IMG_PRE+"missile/myplane/h_01_1.png"));
		//敌方飞机子弹
		images.put("m_01", GameUtil.getImage(Constant.IMG_PRE+"missile/enmyplane/m_01.png"));
		images.put("m_02", GameUtil.getImage(Constant.IMG_PRE+"missile/enmyplane/m_02.png"));
		images.put("m_03", GameUtil.getImage(Constant.IMG_PRE+"missile/enmyplane/m_03.png"));
		images.put("m_04", GameUtil.getImage(Constant.IMG_PRE+"missile/enmyplane/m_04.png"));
		images.put("m_05", GameUtil.getImage(Constant.IMG_PRE+"missile/enmyplane/m_05.png"));
		images.put("m_06", GameUtil.getImage(Constant.IMG_PRE+"missile/enmyplane/m_06.png"));
		images.put("m_07", GameUtil.getImage(Constant.IMG_PRE+"missile/enmyplane/m_07.png"));
		images.put("m_09", GameUtil.getImage(Constant.IMG_PRE+"missile/enmyplane/m_09.png"));
		images.put("m_010", GameUtil.getImage(Constant.IMG_PRE+"missile/enmyplane/m_010.png"));
		images.put("m_011", GameUtil.getImage(Constant.IMG_PRE+"missile/enmyplane/m_011.png"));
		images.put("m_012", GameUtil.getImage(Constant.IMG_PRE+"missile/enmyplane/m_012.png"));
		images.put("m_013", GameUtil.getImage(Constant.IMG_PRE+"missile/enmyplane/m_013.png"));
		images.put("m_014", GameUtil.getImage(Constant.IMG_PRE+"missile/enmyplane/m_014.png"));
		images.put("m_015", GameUtil.getImage(Constant.IMG_PRE+"missile/enmyplane/m_015.png"));
		images.put("m_016", GameUtil.getImage(Constant.IMG_PRE+"missile/enmyplane/m_016.png"));
		images.put("m_017", GameUtil.getImage(Constant.IMG_PRE+"missile/enmyplane/m_017.png"));
		images.put("m_018", GameUtil.getImage(Constant.IMG_PRE+"missile/enmyplane/m_018.png"));
		images.put("b_01", GameUtil.getImage(Constant.IMG_PRE+"missile/boss/b_01.png"));
		images.put("b_02", GameUtil.getImage(Constant.IMG_PRE+"missile/boss/b_02.png"));
		images.put("b_03", GameUtil.getImage(Constant.IMG_PRE+"missile/boss/b_03.png"));
		images.put("b_04", GameUtil.getImage(Constant.IMG_PRE+"missile/boss/b_04.png"));
		images.put("b_04", GameUtil.getImage(Constant.IMG_PRE+"missile/boss/b_05.png"));
		//爆炸
		for(int i = 1;i<=13;i++)
			images.put("e_"+i, GameUtil.getImage(Constant.IMG_PRE+"explode/e_"+i+".png"));
		images.put("bg1", GameUtil.getImage(Constant.IMG_PRE+"bg/BackGround01.png"));
		images.put("Book1", GameUtil.getImage(Constant.IMG_PRE+"bg/Book1.png"));
		images.put("Book2", GameUtil.getImage(Constant.IMG_PRE+"bg/Book2.png"));
		images.put("Book3", GameUtil.getImage(Constant.IMG_PRE+"bg/Book3.png"));
		images.put("Book4", GameUtil.getImage(Constant.IMG_PRE+"bg/Book4.png"));

	}
}
