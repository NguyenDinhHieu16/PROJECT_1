package com.hieu.userinterface;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePanel extends JPanel implements Runnable {
	
	private BufferedImage bufferedImage;
	private Graphics2D g2;
	private boolean isRunning;
	public static boolean isClickPlay;
	
	private Font font = new Font("Arial", Font.BOLD, 40);
		
	
	//here

//		private JLabel jLabel = new JLabel(new ImageIcon("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/start.png"));
	public static JTextField jTextField1 = new JTextField(6);
	public static JTextField jTextField2 = new JTextField(6);
	public static JTextField jTextField3 = new JTextField(6);
	public static JTextField jTextField4 = new JTextField(6);
	
	private JLabel jLabel = new JLabel();
	
		//here
	
	private BackGround1 bgr1 = new BackGround1();
	
	private BackGr2_Play bgr2 = new BackGr2_Play();
	
	
	public GamePanel() {
		
//		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		jTextField1.setBackground(Color.green);
		jTextField2.setBackground(Color.pink);
		jTextField3.setBackground(Color.yellow);
		jTextField4.setBackground(Color.blue);
		
		jTextField1.setFont(font);
		jTextField2.setFont(font);
		jTextField3.setFont(font);
		jTextField4.setFont(font);
		this.setLayout(new FlowLayout((int) RIGHT_ALIGNMENT, 600, 60));
		
		
		this.add(Box.createRigidArea(new Dimension(250, 25)));
		
		
		
//		jTextField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		//this.add(jLabel);
		this.add(jTextField1);
		
		this.add(jTextField2);
		this.add(jTextField3);
		this.add(jTextField4);
		
		
		startGame();
		
		this.addMouseListener(bgr1);
		this.addMouseListener(bgr2);
		
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(bufferedImage, 0, 0, this);
		
		setOpaque(false);
		setClickPlayer();
		jTextField1.setVisible(BackGr2_Play.isClickPlayer2);
		jTextField2.setVisible(BackGr2_Play.isClickPlayer2);
		jTextField3.setVisible(BackGr2_Play.isClickPlayer3);
		jTextField4.setVisible(BackGr2_Play.isClickPlayer4);
		
		super.paint(g);				
	
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
//	public void eventClickPlay() {
//		bgr1.setVisible(false);
//		bgr2.setVisible(true);
//	}
//	
//	public void eventClickBack() {
//		bgr1.setVisible(true);
//		bgr2.setVisible(false);
//	}
	
	public void RenderBgr() {
		
		if (bufferedImage == null) {
			bufferedImage = new BufferedImage(1366, 768, BufferedImage.TYPE_INT_ARGB);
		}
		if (bufferedImage != null) {
			g2 = (Graphics2D) bufferedImage.getGraphics();
		}
		if (g2 != null) {
			if (isClickPlay == false)
				bgr1.draw(g2);
			else {
				bgr2.draw(g2);
			}
		}
		
	}
	
//	public void RenderBgr2_Play() {
//			
//			if (bufferedImage == null) {
//				bufferedImage = new BufferedImage(1366, 768, BufferedImage.TYPE_INT_ARGB);
//			}
//			if (bufferedImage != null) {
//				g2 = (Graphics2D) bufferedImage.getGraphics();
//			}
//			if (g2 != null) {
//				bgr2.draw(g2);
//			}
//			
//	}
	
	public void startGame() {
		isRunning = true;
		isClickPlay = false;
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		
		int FPS = 40;
		long period = 1000000000/FPS;
		long deltaTime, sleepTime, beginTime;
		beginTime = System.nanoTime();
		
		while (isRunning) {
			
			RenderBgr();
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
			if (BackGr2_Play.isClickPlay) {
				Thread.interrupted();
			}
			beginTime = System.nanoTime();
			
		}
	}



	public JTextField getjTextField1() {
		return jTextField1;
	}



	public void setjTextField1(JTextField jTextField1) {
		this.jTextField1 = jTextField1;
	}



	public JTextField getjTextField2() {
		return jTextField2;
	}



	public void setjTextField2(JTextField jTextField2) {
		this.jTextField2 = jTextField2;
	}



	public JTextField getjTextField3() {
		return jTextField3;
	}



	public void setjTextField3(JTextField jTextField3) {
		this.jTextField3 = jTextField3;
	}



	public JTextField getjTextField4() {
		return jTextField4;
	}



	public void setjTextField4(JTextField jTextField4) {
		this.jTextField4 = jTextField4;
	}
	
	

//	@Override
//	public void mouseClicked(MouseEvent e) {
//
//		int x = e.getX();
//		int y = e.getY();
//		if (x >= 775 && x <= 775+346) {
//			if (y >= 350 && y <= 350+124) {
//				System.out.println("u click");
//				isClickPlay = true;
//			}
//		}
//		
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//		

}
