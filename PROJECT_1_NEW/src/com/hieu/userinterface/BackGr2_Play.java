package com.hieu.userinterface;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.hieu.effect.GameWorkFrame;

public class BackGr2_Play extends JPanel implements MouseListener {
	
	private BufferedImage bgr2, bgrplayer;
	private BufferedImage player4, player2, player3;
	private BufferedImage back, play;
	private BufferedImage playernamebig;
	private BufferedImage playername1, playername2, playername3, playername4;
	
	
	
	
	private Rectangle2D rectback = new Rectangle2D.Float(60f, 620f, 135f, 45f);
	private Rectangle2D rectplay = new Rectangle2D.Float(1150f, 620f, 135f, 45f);
	private Rectangle2D rect2 = new Rectangle2D.Float(370f, 183f, 317f, 78f);
	private Rectangle2D rect3 = new Rectangle2D.Float(670f, 300f, 317f, 78f);
	private Rectangle2D rect4 = new Rectangle2D.Float(370f, 385f, 317f, 78f);
	
	public static boolean isClickPlayer2, isClickPlayer3, isClickPlayer4;
	public static boolean isClickPlay;
	
	private GamePanel gamePanel;
	
	public BackGr2_Play() {
		
		isClickPlayer2 = false;
		isClickPlayer3 = false;
		isClickPlayer4 = false;
		isClickPlay = false;
		
		try {
			bgr2 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/background2.png"));
			bgrplayer = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/player.png"));
			player2 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/player2.png"));
			player3 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/player3.png"));
			player4 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/player4.png"));
			back = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/back.png"));
			play = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/start.png"));
			playernamebig = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/playernamebig.png"));
			playername1 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/playername1.png"));
			playername2 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/playername2.png"));
			playername3 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/playername3.png"));
			playername4 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/playername4.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	private void doDrawing(Graphics g) {        
        
        Graphics2D g2d = (Graphics2D) g.create();
        
             
            AlphaComposite alcom = AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, 0);
            g2d.setComposite(alcom);
            g2d.fill(rectback);
            g2d.fill(rectplay);
            g2d.fill(rect2);
            g2d.fill(rect3);
            g2d.fill(rect4);
             
         
        g2d.dispose();
    }
	
	public void draw(Graphics2D g2) {
		g2.drawImage(bgr2, 0, 0, null);
		g2.drawImage(bgrplayer, 270, 100, null);
		g2.drawImage(player2, 270, 100, null);
		g2.drawImage(player3, 270, 100, null);
		g2.drawImage(player4, 270, 100, null);
		g2.drawImage(back, 50, 400, null);
		
		doDrawing(g2);
		if(isClickPlayer2) {
			g2.drawImage(playernamebig, 233, 50, null);
			g2.drawImage(playername1, 215, 50, null);
			g2.drawImage(playername2, 215, 50, null);
			g2.drawImage(play, 1150, 620, null);
			
		}
		
		if(isClickPlayer3) {
			g2.drawImage(playernamebig, 233, 50, null);
			g2.drawImage(playername1, 215, 50, null);
			g2.drawImage(playername2, 215, 50, null);
			g2.drawImage(playername3, 215, 50, null);
			g2.drawImage(play, 1150, 620, null);
		
			
		}
		
		if(isClickPlayer4) {
			g2.drawImage(playernamebig, 233, 50, null);
			g2.drawImage(playername1, 215, 50, null);
			g2.drawImage(playername2, 215, 50, null);
			g2.drawImage(playername3, 215, 50, null);
			g2.drawImage(playername4, 215, 50, null);
			g2.drawImage(play, 1150, 620, null);
			
		}
		
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {

		int x = e.getX();
		int y = e.getY();
		if (rectback.contains(x, y)) {
				System.out.println("u click back");
				GamePanel.isClickPlay = false;
				isClickPlayer2 = false;
				isClickPlayer3 = false;
				isClickPlayer4 = false;
		}
		
		if (rectplay.contains(x, y)) {
			System.out.println("u click play");
			isClickPlay = true;
			new GameWorkFrame();
		}
			
		
		if (rect2.contains(x, y)) {
			System.out.println("u click 2 player");
			isClickPlayer2 = true;
		}
		
		if (rect3.contains(x, y)) {
			System.out.println("u click 3 player");
			isClickPlayer3 = true;
		}
		
		if (rect4.contains(x, y)) {
			System.out.println("u click 4 player");
			isClickPlayer4 = true;
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
