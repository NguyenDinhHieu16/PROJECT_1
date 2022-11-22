package com.hieu.effect;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import com.hieu.userinterface.BackGr2_Play;

public class GameWork {

	private BufferedImage imgBgr;
	private BufferedImage person1, person2, person3, person4;
	
	private FileReader fr;
	private BufferedReader br;
	
	private point tdImg;
	private ArrayList<point> listTD;
	
	private String line;
	
	private int x, y;
	public static int a=0 ,b=0 ,c=0 ,d=0, temp, temp1;
	
	private Random rand;
	private int numRan1, numRan2, turn, turnfirst;
	
	private controller control = new controller();
	
	public boolean isClickRoll, first = true;
	
	public GameWork() {
		
		isClickRoll = false;
		try {
			imgBgr = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/gameWorkbgr.png"));
			person1 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/play1.png"));
			person2 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/play2.png"));
			person3 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/play3.png"));
			person4 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/play4.png"));
			
			fr = new FileReader("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\data/td.txt");
			br =new BufferedReader(fr);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listTD = new ArrayList<point>();
		
		try {
			line = br.readLine();
			while (line != null) {
				String str[] = line.split(" ");
				x = Integer.parseInt(str[0]);
				y = Integer.parseInt(str[1]);
				
				tdImg = new point(x, y);
				listTD.add(tdImg);
				line = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GameWorkPanel.jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clickRoll();
			}
		});
		
	}
	
	public void clickRoll() {
		isClickRoll = true;
		rand = new Random();
		numRan1 = rand.nextInt(6) +1;
		numRan2 = rand.nextInt(6) +1;
		
		control.setVisi(true);
		
		if (isClickRoll == true && first == true)
			turn = TurnFirst();
		if (isClickRoll == true && first == false)
			if(BackGr2_Play.isClickPlayer4) {
				TurnNext4();
				
			}
			else if(BackGr2_Play.isClickPlayer3) {
				TurnNext3();

		}
			else if(BackGr2_Play.isClickPlayer2) {
				TurnNext2();
				
			}
			
		control.setVisible(control.getVisi());
		if(temp1 == 4) {
 
			temp = d;
			
		}
		else if(temp1 == 3) {
			temp = c;

		}
		else if(temp1 == 2) {
			temp = b;
		}
		else temp = a;
		control.setBox(control.getMark()[temp]);
		
	}
	
	public int TurnFirst() {
		rand = new Random();
		turnfirst = rand.nextInt(4) +1;
		
		if(BackGr2_Play.isClickPlayer4) {
			if (turnfirst == 1) {
				a= a+ numRan1+numRan2;
				
			}
			if (turnfirst == 2) {
				b= b+ numRan1+numRan2;
				
			}
			if (turnfirst == 3) {
				c=c+numRan1+numRan2;

			}
			if (turnfirst == 4) {
				d=d+numRan1+numRan2;
				
			}
			temp1 = turnfirst;
		}
		
		else if(BackGr2_Play.isClickPlayer3) {
			
			if (turnfirst == 4) {
				turnfirst %= 3 +1;
				
			}
			if (turnfirst == 1) {
				a= a+ numRan1+numRan2;

			}
			if (turnfirst == 2) {
				b= b+ numRan1+numRan2;
				
			}
			if (turnfirst == 3) {
				c=c+numRan1+numRan2;

			}

		}
		
		else if(BackGr2_Play.isClickPlayer2) {
			if (turnfirst == 4) {
				turnfirst %= 2 +1;
				
			}
			if (turnfirst == 3) {
				turnfirst %= 2 +1;
				
			}
			if (turnfirst == 1) {
				a= a+ numRan1+numRan2;

			}
			if (turnfirst == 2) {
				b= b+ numRan1+numRan2;
				
			}
			
		}
		
		first = false;
		return turnfirst;
	}
	
	public void TurnNext2() {
		turn++;
		
		if (turn == 3) {
			turn = 1;
		}
		if (turn == 1) {
			a+=numRan1+numRan2;
			if (a > 31) a = a % 31 -1;
		}
		if (turn == 2) {
			b+=numRan1+numRan2;
			if (b > 31) b = b % 31 -1;
		}
		temp1 = turn;
	}
	
	public void TurnNext3() {
		turn++;
		
		if (turn == 4) {
			turn = 1;
		}
		if (turn == 1) {
			a+=numRan1+numRan2;
			if (a > 31) a = a % 31 -1;
		}
		if (turn == 2) {
			b+=numRan1+numRan2;
			if (b > 31) b = b % 31 -1;
		}
		if (turn == 3) {
			c+=numRan1+numRan2;
			if (c > 31) c = c % 31 -1;
		}
		temp1 = turn;
	}
	
	public void TurnNext4() {
		turn++;
		
		if (turn == 5) {
			turn = 1;
		}
		if (turn == 1) {
			a+=numRan1+numRan2;
			if (a > 31) a = a % 31 -1;
		}
		if (turn == 2) {
			b+=numRan1+numRan2;
			if (b > 31) b = b % 31 -1;
		}
		if (turn == 3) {
			c+=numRan1+numRan2;
			if (c > 31) c = c % 31 -1;
		}
		if (turn == 4) {
			d+=numRan1+numRan2;
			if (d > 31) d = d % 31 -1;
		}
		temp1 = turn;
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(imgBgr, 0, 0, null);
		
		if(BackGr2_Play.isClickPlayer2) {
			g2.drawImage(person1, listTD.get(a).getX(), listTD.get(a).getY(), null);
			g2.drawImage(person2, listTD.get(b).getX(), listTD.get(b).getY(), null);
			
		}
		
		if(BackGr2_Play.isClickPlayer3) {
			g2.drawImage(person1, listTD.get(a).getX(), listTD.get(a).getY(), null);
			g2.drawImage(person2, listTD.get(b).getX(), listTD.get(b).getY(), null);
			g2.drawImage(person3, listTD.get(c).getX(), listTD.get(c).getY(), null);

		}
		
		if(BackGr2_Play.isClickPlayer4) {
			g2.drawImage(person1, listTD.get(a).getX(), listTD.get(a).getY(), null);
			g2.drawImage(person2, listTD.get(b).getX(), listTD.get(b).getY(), null);
			g2.drawImage(person3, listTD.get(c).getX(), listTD.get(c).getY(), null);
			g2.drawImage(person4, listTD.get(d).getX(), listTD.get(d).getY(), null);
			
		}
	}

}
