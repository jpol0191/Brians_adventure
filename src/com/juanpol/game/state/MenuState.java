package com.juanpol.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.juanpol.game.main.GameMain;
import com.juanpol.game.main.Resources;

public class MenuState extends State {
	
	
	@Override
	public void init() {
		// do nothing
	}

	@Override
	public void update(float delta) {
		// Do Nothing
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Resources.welcome, 0, 0, null);
		
	}

	@Override
	public void onClick(MouseEvent e) {
		setCurrentState(new PlayState());
	}

	@Override
	public void onKeyPress(KeyEvent e) {
		
	}

	@Override
	public void onKeyRelease(KeyEvent e) {
		// nothing
	}

}
