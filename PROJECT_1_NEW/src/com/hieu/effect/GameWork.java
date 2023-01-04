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
import java.util.zip.CheckedOutputStream;

import javax.imageio.ImageIO;

import com.hieu.userinterface.BackGr2_Play;
import com.hieu.userinterface.GamePanel;

public class GameWork {

	private BufferedImage imgBgr;
	private BufferedImage person1, person2, person3, person4;
	

	
	private FileReader fr;
	private BufferedReader br;
	
	private point tdImg;
	public static ArrayList<point> listTD;
	
	private String line;
	
	private int x, y;
	
	//temp1 la luot choi cua player nao
	//temp la vi tri player do
	public static int a=0 ,b=0 ,c=0 ,d=0, temp, temp1;
	private int t;
	
	private Random rand;
	private int numRan1, numRan2, turn, turnfirst;
	
	private controller control = new controller();
	
	public boolean isClickRoll, first = true;
	private int black[] = {3, 3, 3, 3, 3};
	
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
				control.loseMoney();
				
				if ((a == 0 && temp1 == 1) ||
					(b == 0 && temp1 == 2) ||
					(c == 0 && temp1 == 3) ||
					(d == 0 && temp1 == 4))
				{
					control.start();
				}
				else if (((a == 4 || a == 14 || a==18 || a == 25) && temp1 == 1) ||
						 ((b == 4 || b == 14 || b==18 || b == 25) && temp1 == 2) ||
						 ((c == 4 || c == 14 || c==18 || c == 25) && temp1 == 3) ||
						 ((d == 4 || d == 14 || d==18 || d == 25) && temp1 == 4))
				{
					control.King();
				}
				else if ((a == 8 && temp1 == 1) ||
						 (b == 8 && temp1 == 2) ||
						 (c == 8 && temp1 == 3) ||
						 (d == 8 && temp1 == 4))
				{
					control.BlackHole();
				}
				else if (((a == 12 || a == 20 || a==28) && temp1 == 1) ||
						 ((b == 12 || b == 20 || b==28) && temp1 == 2) ||
						 ((c == 12 || c == 20 || c==28) && temp1 == 3) ||
						 ((d == 12 || d == 20 || d==28) && temp1 == 4))
				{
					control.lucky();
				}
				else if ((a == 16 && temp1 == 1) ||
						 (b == 16 && temp1 == 2) ||
						 (c == 16 && temp1 == 3) ||
						 (d == 16 && temp1 == 4))
				{
					control.WorldCup();
				}
				else if ((a == 24 && temp1 == 1) ||
						 (b == 24 && temp1 == 2) ||
						 (c == 24 && temp1 == 3) ||
						 (d == 24 && temp1 == 4))
				{
					control.teleport();
				}
				else if ((a == 30 && temp1 == 1) ||
						 (b == 30 && temp1 == 2) ||
						 (c == 30 && temp1 == 3) ||
						 (d == 30 && temp1 == 4))
				{
					control.tax();
				}
				else if (control.isLose == false) 
					control.init1();
				control.isLose = true;
				control.setTurnName();
				
				if (temp1 == 1) {
					control.cantUp(1, a);
				}
				else if (temp1 ==2) {
					control.cantUp(2, b);
				}
				else if (temp1 == 3) {
					control.cantUp(3, c);
				}
				else if (temp1 == 4) {
					control.cantUp(4, d);
				}
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
		else if (isClickRoll == true && first == false)
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
		control.setBuyBack();
					
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
		temp1 = turnfirst;
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
		
		do {
			turn++;
			
			if (turn == 4) {
				turn = 1;
			}
		}
		while (control.losePlayer() != 0);
		
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
		
		do {
			turn++;
			
			if (turn == 5) {
				turn = 1;
			}
		}
		while (control.losePlayer() != 0);
		
		
	
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
	
//	public void workBlack() {
//		
//		if (control.getBlack()[temp1] == 1) {
//			if (black[temp1] != 0) {
//				turnNext();
//				black[temp1]--;
//			}
//			else {
//				black[temp1] = 3;
//				control.setBlack(0, temp1);
//			}
//			
//		}
//	}
	
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
