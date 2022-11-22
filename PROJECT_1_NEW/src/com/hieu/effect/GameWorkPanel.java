package com.hieu.effect;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.hieu.userinterface.BackGr2_Play;
import com.hieu.userinterface.GameFrame;
import com.hieu.userinterface.GamePanel;

public class GameWorkPanel extends JPanel implements Runnable {
	
	private BufferedImage bufferedImage;
	private Graphics2D g2d;
	
	private JLabel jLabel1, jLabel2, jLabel3, jLabel4;
	
	public static JButton jButton1 = new JButton("ROLL");
	
	private boolean isRunning;
	
	private GameWork gameWork = new GameWork();
	
	private Random rand;
	private int intRand;
	
	private controller control = new controller();
	
	public GameWorkPanel() {
		 
		this.setLayout(new BorderLayout());
		
		jLabel1 = new JLabel(GamePanel.jTextField1.getText(), new ImageIcon("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/img1.png"), JLabel.LEFT);
		jLabel2 = new JLabel(GamePanel.jTextField2.getText(), new ImageIcon("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/img2.png"), JLabel.RIGHT);
		jLabel3 = new JLabel(GamePanel.jTextField3.getText(), new ImageIcon("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/img3.png"), JLabel.CENTER);
		jLabel4 = new JLabel(GamePanel.jTextField4.getText(), new ImageIcon("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/img4.png"), JLabel.CENTER);
		jLabel1.setForeground(Color.white);
		jLabel2.setForeground(Color.white);
		jLabel3.setForeground(Color.white);
		jLabel4.setForeground(Color.white);
		this.add(jLabel1,BorderLayout.WEST);
		this.add(jLabel2, BorderLayout.EAST);
		this.add(jLabel3, BorderLayout.NORTH);
		this.add(jLabel4, BorderLayout.SOUTH);
		
		jLabel1.setVisible(BackGr2_Play.isClickPlayer2);
		jLabel2.setVisible(BackGr2_Play.isClickPlayer2);
		jLabel3.setVisible(BackGr2_Play.isClickPlayer3);
		jLabel4.setVisible(BackGr2_Play.isClickPlayer4);
		
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
		
       
       
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(625)
                .addComponent(jButton1)
                .addContainerGap(181, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                    .addGap(600)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addContainerGap(188, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(350)
                .addComponent(jButton1)
                .addContainerGap(208, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jLabel2)
                    .addGap(275)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                    .addComponent(jLabel1))
        );
        
       
		startGame();
	}
	
	public void setClickPlayer() {
		if (BackGr2_Play.isClickPlayer3) {
			BackGr2_Play.isClickPlayer2 = true;
		}
		
		if (BackGr2_Play.isClickPlayer4) {
			BackGr2_Play.isClickPlayer2 = true;
			BackGr2_Play.isClickPlayer3 = true;
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		g.drawImage(bufferedImage, 0, 0, this);
		setOpaque(false);
		super.paintComponent(g);
		
	}
	
	public void startGame() {
		
		isRunning = true;
		Thread thread = new Thread(this);
		thread.start();
		
	}
	
	
	public void Render(Graphics2D g2) {
		
		if (bufferedImage == null) {
			bufferedImage = new BufferedImage(1366, 768, BufferedImage.TYPE_INT_ARGB);
		}
		
		if (bufferedImage != null) {
			g2 =(Graphics2D) bufferedImage.getGraphics();
		}
		
		if (g2 != null) {
			gameWork.draw(g2);
		}
	}

	@Override
	public void run() {
		
		int FPS = 40;
		long period = 1000000000/FPS;
		long deltaTime, sleepTime, beginTime;
		beginTime = System.nanoTime();
		
		while (true) {
			
			Render(g2d);
			repaint();
			
			deltaTime = System.nanoTime() - beginTime;
			sleepTime = period - deltaTime;
			
			try {
				if (sleepTime > 0)
					Thread.sleep(sleepTime/1000000);
				else Thread.sleep(period/2000000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			beginTime = System.nanoTime();
			
		}
		
	}

}
