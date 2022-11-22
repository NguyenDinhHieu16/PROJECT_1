package com.hieu.userinterface;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class GameFrame extends JFrame {
	
	public static GameFrame gameFrame1;
	
	public GameFrame() {
		this.setTitle("King of Galaxy");
		
		Toolkit toolkit = this.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		
		this.setSize(dimension.width, dimension.height);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
	}
	
	public static void main(String[] args) {
		
		GamePanel gamePanel = new GamePanel();
		gameFrame1 = new GameFrame();
		gameFrame1.add(gamePanel);
		gameFrame1.setVisible(true);
		
	}
	
}
