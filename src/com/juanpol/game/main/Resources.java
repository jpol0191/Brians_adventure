package com.juanpol.game.main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.juanpol.framework.animation.Animation;
import com.juanpol.framework.animation.Frame;

public class Resources {

	public static BufferedImage welcome, iconimage,block,cloud1,cloud2,duck,grass,jump,run1,run2,run3,
	run4,run5,selector,brian;
	
	public static AudioClip hit,onjump;
	
	public static Color skyBlue;
	
	public static Animation runAnim;
	
	public static void load() {
		welcome = loadImage("flagtitle.png");
		iconimage = loadImage("iconimage.png");
		block = loadImage("block.png");
		cloud1 = loadImage("cloud1.png");
		cloud2 = loadImage("cloud2.png");
		duck = loadImage("Briancarmodelduck.png");
		brian = loadImage("Briancarmodel.png");
		grass = loadImage("grass.png");
		jump = loadImage("BrainMericaCar.png");
		run1 = loadImage("run_anim1.png");
		run2 = loadImage("run_anim2.png");
		run3 = loadImage("run_anim3.png");
		run4 = loadImage("run_anim4.png");
		run5 = loadImage("run_anim5.png");
		selector = loadImage("selector.png");
		hit = loadSound("hit.wav");
		onjump = loadSound("onjump.wav");
		skyBlue = new Color(208, 244, 247);
		
		Frame f1 = new Frame(run1, .1f);
		Frame f2 = new Frame(run2, .1f);
		Frame f3 = new Frame(run3, .1f);
		Frame f4 = new Frame(run4, .1f);
		Frame f5 = new Frame(run5, .1f);
		runAnim = new Animation(f1,f2,f3,f4,f5,f3,f2);
	}

	private static AudioClip loadSound(String filename) {
		URL fileURL = Resources.class.getResource("/resources/" + filename);
		return Applet.newAudioClip(fileURL);
	}

	private static BufferedImage loadImage(String filename) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(Resources.class.getResourceAsStream("/resources/" + filename));
		} catch (IOException e) {
			System.out.println("Error while reading: " + filename);
			e.printStackTrace();
		}
		return img;
	}
}