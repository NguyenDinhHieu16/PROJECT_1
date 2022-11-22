package com.hieu.effect;

import java.awt.BorderLayout;

import com.hieu.userinterface.BackGr2_Play;
import com.hieu.userinterface.GameFrame;

public class GameWorkFrame {
	
	private GameFrame gameFrame2 = new GameFrame();
	private GameWorkPanel gameWorkPanel = new GameWorkPanel();
	
	public GameWorkFrame() {
		
		
		GameFrame.gameFrame1.setVisible(!BackGr2_Play.isClickPlay);
		
		gameFrame2.setLayout(new BorderLayout());
		gameFrame2.setVisible(BackGr2_Play.isClickPlay);
		gameFrame2.add(gameWorkPanel);
		
		
	}
}
