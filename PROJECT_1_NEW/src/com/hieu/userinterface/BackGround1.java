package com.hieu.userinterface;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
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

public class BackGround1 extends JPanel implements MouseListener {
	
	private BufferedImage bgr1, textName, menu;
	private BufferedImage btn1, btn2, btn3;
	
	private Rectangle2D rect = new Rectangle2D.Float(775f, 350f, 340f, 120f);
	
//	private GamePanel gamePanel = new GamePanel();
	
	public BackGround1() {
		
//		this.addMouseListener(gamePanel);
		try {
			bgr1 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/background.png"));
			textName = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/textName.png"));
			menu = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/menu.png"));
			
			btn1 = menu.getSubimage(26, 59, 346, 124);
			btn2 = menu.getSubimage(26, 230, 346, 124);
			btn3 = menu.getSubimage(26, 399, 346, 124);
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
            g2d.fill(rect);
             
         
        g2d.dispose();
    }
	
	public void draw(Graphics2D g2) {
		
		g2.drawImage(bgr1, 0, 0, null);
		g2.drawImage(textName, 0, 0, null);
		g2.drawImage(btn1, 775, 350, null);
		g2.drawImage(btn2, 775, 475, null);
		g2.drawImage(btn3, 775, 600, null);
		doDrawing(g2);
		
	}
//	JButton button = new JButton("Start", new ImageIcon("images/start.gif"));

	@Override
	public void mouseClicked(MouseEvent e) {

		int x = e.getX();
		int y = e.getY();
		if (rect.contains(x, y)) {
				System.out.println("u click create");
				GamePanel.isClickPlay = true;
				
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
