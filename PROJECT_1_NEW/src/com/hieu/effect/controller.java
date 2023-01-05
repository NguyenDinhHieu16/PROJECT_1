package com.hieu.effect;

import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore.PrivateKeyEntry;
import java.util.Arrays;
import java.util.zip.CheckedOutputStream;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.Box.Filler;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hieu.userinterface.BackGr2_Play;
import com.hieu.userinterface.GamePanel;

public class controller extends JFrame implements ItemListener{

	private int cost_0[] = {0, 60, 60, 60, 200, 100, 100, 120, 0, 140, 140, 160, 0, 180, 200, 200, 50, 220, 200, 240, 0, 260, 260, 280, 50, 200, 300, 320, 0, 350, 0, 400};
	private int cost_1[] = {0, 110, 110, 110, 200, 150, 150, 170, 0, 240, 240, 260, 0, 280, 200, 300, 50, 370, 200, 390, 0, 410, 410, 430, 50, 200, 500, 520, 0, 550, 0, 600};
	private int cost_2[] = {0, 160, 160, 160, 200, 200, 200, 220, 0, 340, 340, 360, 0, 380, 200, 400, 50, 520, 200, 540, 0, 560, 560, 580, 50, 200, 700, 720, 0, 750, 0, 800};
	private int cost_3[] = {0, 210, 210, 210, 200, 250, 250, 270, 0, 440, 440, 460, 0, 480, 200, 500, 50, 670, 200, 690, 0, 710, 710, 730, 50, 200, 900, 920, 0, 950, 0, 1000};
	private int cost_4[] = {0, 360, 360, 360, 200, 400, 400, 420, 0, 690, 690, 710, 0, 730, 200, 750, 50, 1045, 200, 1065, 0, 1085, 1085, 1105, 50, 200, 1400, 1420, 0, 1450, 0, 1500};
	public static int[] cost = new int[32];
	
	public static int wallet1 = 2000, wallet2 = 2000, wallet3 = 2000, wallet4 = 2000;
	
	private int check = 0, money = 0;
	
	public static int[] mark = new int[33];//danh dau cap nha da mua
	public static int[] markTurn = new int[33];//danh dau vi tri da mua cua player nao
	
	private boolean visi = false;//set an hien jframe thong bao
	private JPanel jPanel;
	
	private JButton jButton, jButton1;

	private JLabel jLabel;
	
	private BufferedImage p1l0, p1l1, p1l2, p1l3;
	private BufferedImage p2l0, p2l1, p2l2, p2l3;
	private BufferedImage p3l0, p3l1, p3l2, p3l3;
	private BufferedImage p4l0, p4l1, p4l2, p4l3;
	
	private int lose = 0;
	private JCheckBox jCheckBox1, jCheckBox2, jCheckBox3, jCheckBox4;
	
	public static boolean drawN = false, isLose = false;
	
	private String turnName;
	private int black[] = {0, 0, 0, 0, 0};
	private int lostPlayer[] = {0, 0, 0, 0, 0};
//	private JTextField jTextField = new JTextField(6);
	private int tele;
	
	@Override
	public Font getFont() {
		// TODO Auto-generated method stub
		return super.getFont();
	}
	
	public controller() {
		
		jPanel = new JPanel();
		
		this.setTitle("Buy?");
		this.setSize(600, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(jPanel);
		
		Arrays.fill(mark, -1);
		Arrays.fill(markTurn, 0);
		
		try {
			p1l0 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/blue0.png"));
			p1l1 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/blue1.png"));
			p1l2 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/blue2.png"));
			p1l3 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/blue3.png"));
			
			p2l0 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/green0.png"));
			p2l1 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/green1.png"));
			p2l2 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/green2.png"));
			p2l3 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/green3.png"));
			
			p3l0 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/pink0.png"));
			p3l1 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/pink1.png"));
			p3l2 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/pink2.png"));
			p3l3 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/pink3.png"));
			
			p4l0 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/yellow0.png"));
			p4l1 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/yellow1.png"));
			p4l2 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/yellow2.png"));
			p4l3 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/yellow3.png"));
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		jLabel = new JLabel();
		jLabel.setText("2 3 con muc");
		
		jButton = new JButton("DON'T UP");
		jButton1 = new JButton("CANT BUY");
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisi(false);
				setVisible(visi);
			}
		});
		
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisi(false);
				setVisible(visi);
				if (jButton.getText() == "BUY CARD FOR 200") {
					if (markTurn[GameWork.temp] == 0) {
						markTurn[GameWork.temp] = GameWork.temp1;
						mark[GameWork.temp] = 1;
					}
					else if (markTurn[GameWork.temp] == GameWork.temp1) {
						jButton.setText("OF U");
					}
					else if (markTurn[GameWork.temp] != GameWork.temp1) {
						jButton.setText("U lost money");
					}
				}
				
				else if (jButton.getText() == "YOU COME BLACK HOLE") {
//					if (GameWork.temp1 == 1) {
//						wallet1-= 50;
//					}
//					else if (GameWork.temp1 == 2) {
//						wallet2-= 50;
//					}
//					else if (GameWork.temp1 == 3) {
//						wallet3-= 50;
//					}
//					else if (GameWork.temp1 == 4) {
//						wallet4-= 50;
//					}
				}
				
				else if (jButton.getText() == "YOU WANT TO TELEPORT" ) {
//					jTextField.setVisible(false);
					if (GameWork.temp1 == 1) {
						wallet1-= 50;
					}
					else if (GameWork.temp1 == 2) {
						wallet2-= 50;
					}
					else if (GameWork.temp1 == 3) {
						wallet3-= 50;
					}
					else if (GameWork.temp1 == 4) {
						wallet4-= 50;
					}
				}
				
				else {
					if (markTurn[GameWork.temp] == GameWork.temp1) {
						lose = 0;
					}
					else if (markTurn[GameWork.temp] == 0) {
						markTurn[GameWork.temp] = GameWork.temp1;
						mark[GameWork.temp] = checkbox();
					}
				}
				buyMoney();
				drawN = true;
				setCost();
				
				win();
			}
		});
		
		
		jCheckBox1 = createCheckBox("Land");
		jCheckBox2 = createCheckBox("House1");
		jCheckBox3 = createCheckBox("House2");
		jCheckBox4 = createCheckBox("House3");
		this.init();
        this.setVisible(visi);
	
	}
	
//	public int workTele() {
//		jTextField.setVisible(true);
//		String teleString = jTextField.getText();
//		tele = Integer.parseInt(teleString);
//		return tele;
//	}
	
	public void setCost() {
		for (int i = 0; i<32; i++) {
			if (mark[i] == 0) {
				cost[i] = cost_0[i];
			}
			else if (mark[i] == 1) {
				cost[i] = cost_1[i];
			}
			else if (mark[i] == 2) {
				cost[i] = cost_2[i];
			}
			else if (mark[i] == 3) {
				cost[i] = cost_3[i];
			}
		}
	}
	
	public void draw(Graphics2D g2) {
		
		
		for (int i= 0; i < 32; i++) {
			if (markTurn[i] == 0) continue;
			else if (markTurn[i] == 1) {
				switch (mark[i]) {
				case 0:
				{
					g2.drawImage(p1l0, GameWork.listTD.get(i).getX(), GameWork.listTD.get(i).getY(), null);
					break;
				}
				
				case 1:
				{
					g2.drawImage(p1l1, GameWork.listTD.get(i).getX(), GameWork.listTD.get(i).getY(), null);
					break;
				}
				
				case 2:
				{
					g2.drawImage(p1l2, GameWork.listTD.get(i).getX(), GameWork.listTD.get(i).getY(), null);
					break;
				}
				
				case 3:
				{
					g2.drawImage(p1l3, GameWork.listTD.get(i).getX(), GameWork.listTD.get(i).getY(), null);
					break;
				}

				default:
					break;
				}
			}
			else if (markTurn[i] == 2) {
				switch (mark[i]) {
				case 0:
				{
					g2.drawImage(p2l0, GameWork.listTD.get(i).getX(), GameWork.listTD.get(i).getY(), null);
					break;
				}
				
				case 1:
				{
					g2.drawImage(p2l1, GameWork.listTD.get(i).getX(), GameWork.listTD.get(i).getY(), null);
					break;
				}
				
				case 2:
				{
					g2.drawImage(p2l2, GameWork.listTD.get(i).getX(), GameWork.listTD.get(i).getY(), null);
					break;
				}
				
				case 3:
				{
					g2.drawImage(p2l3, GameWork.listTD.get(i).getX(), GameWork.listTD.get(i).getY(), null);
					break;
				}

				default:
					break;
				}
			}
			
			else if (markTurn[i] == 3) {
				switch (mark[i]) {
				case 0:
				{
					g2.drawImage(p3l0, GameWork.listTD.get(i).getX(), GameWork.listTD.get(i).getY(), null);
					break;
				}
				
				case 1:
				{
					g2.drawImage(p3l1, GameWork.listTD.get(i).getX(), GameWork.listTD.get(i).getY(), null);
					break;
				}
				
				case 2:
				{
					g2.drawImage(p3l2, GameWork.listTD.get(i).getX(), GameWork.listTD.get(i).getY(), null);
					break;
				}
				
				case 3:
				{
					g2.drawImage(p3l3, GameWork.listTD.get(i).getX(), GameWork.listTD.get(i).getY(), null);
					break;
				}

				default:
					break;
				}
			}
			else if (markTurn[i] == 4) {
				switch (mark[i]) {
				case 0:
				{
					g2.drawImage(p4l0, GameWork.listTD.get(i).getX(), GameWork.listTD.get(i).getY(), null);
					break;
				}
				
				case 1:
				{
					g2.drawImage(p4l1, GameWork.listTD.get(i).getX(), GameWork.listTD.get(i).getY(), null);
					break;
				}
				
				case 2:
				{
					g2.drawImage(p4l2, GameWork.listTD.get(i).getX(), GameWork.listTD.get(i).getY(), null);
					break;
				}
				
				case 3:
				{
					g2.drawImage(p4l3, GameWork.listTD.get(i).getX(), GameWork.listTD.get(i).getY(), null);
					break;
				}

				default:
					break;
				}
			}
		}
	}
	
	public void init() {
		jPanel.add(Box.createRigidArea(new Dimension(600, 25)));
		jPanel.add(jLabel);
		jPanel.add(Box.createRigidArea(new Dimension(600, 50)));
		jPanel.add(jCheckBox1);
		jPanel.add(jCheckBox2);
		jPanel.add(jCheckBox3);
		jPanel.add(jCheckBox4);
		jPanel.add(Box.createRigidArea(new Dimension(600, 50)));
		jPanel.add(jButton1);
        jPanel.add(jButton);
        jPanel.add(Box.createRigidArea(new Dimension(600, 50)));
//        jPanel.add(jTextField);
//        jTextField.setVisible(false);
	}
	
	
	//voi o khong co chuc nang
	public void init1() {
		if (markTurn[GameWork.temp] != GameWork.temp1) {
			jButton.setText("BUY?");
		} else
			jButton.setText("DON'T UP");
	    jCheckBox1.setVisible(true);
	    jCheckBox2.setVisible(true);
	    jCheckBox3.setVisible(true);
	    jCheckBox4.setVisible(true);
	    jButton1.setVisible(true);
	}
	
	//tru tiwn khi mua
	public void buyMoney() {
		if (GameWork.temp1 == 1) { 
			this.wallet1 -= lose;
			
		}
		else if (GameWork.temp1 == 2) { 
			this.wallet2 -= lose;
			
			
		}
		else if (GameWork.temp1 == 3) { 
			this.wallet3 -= lose;
		
			
		}
		else if (GameWork.temp1 == 4) { 
			this.wallet4 -= lose;
			
			
		}
	
	}
	
	//tru tien khi di vao o  doi thu khac
	public void loseMoney() {
		isLose = true;
		if (GameWork.temp1 == 1 && markTurn[GameWork.a] != GameWork.temp1 && markTurn[GameWork.a] != 0) {
				this.money = setLoseMoneyLevel(mark[GameWork.a], GameWork.a);
				this.wallet1 -= this.money;
				addSub(markTurn[GameWork.a], this.money);
				return;
		}
		if (GameWork.temp1 == 2 && markTurn[GameWork.b] != GameWork.temp1 && markTurn[GameWork.b] != 0) {
			this.money = setLoseMoneyLevel(mark[GameWork.b], GameWork.b);
			this.wallet2 -= this.money;
			addSub(markTurn[GameWork.b], this.money);
			return;
		}
		if (GameWork.temp1 == 3 && markTurn[GameWork.c] != GameWork.temp1 && markTurn[GameWork.c] != 0) {
			this.money = setLoseMoneyLevel(mark[GameWork.c], GameWork.c);
			this.wallet3 -= this.money;
			addSub(markTurn[GameWork.c], this.money);
			return;
		}
		if (GameWork.temp1 == 4 && markTurn[GameWork.d] != GameWork.temp1 && markTurn[GameWork.d] != 0) {
			this.money = setLoseMoneyLevel(mark[GameWork.d], GameWork.d);
			this.wallet4 -= this.money;
			addSub(markTurn[GameWork.d], this.money);
			return;
		}
		isLose = false;
		
	}
	
	public void addSub(int t, int m) {
		switch (t) {
		case 1: {
			this.wallet1 += m;
			break;
		}
			
		case 2: {
			this.wallet2 += m;
			break;
		}
			
		case 3: {
			this.wallet3 += m;
			break;
		}
		
		case 4: {
			this.wallet4 += m;
			break;
		}
			
		default:
			break;
		}
	}
	
	public int setLoseMoneyLevel(int x, int y) {
		int money = 0;
		switch (x) {
		case 0:
		{
			money = cost_0[y]*10/100 + cost_0[y];	
			break;
		}
		
		case 1:
		{
			money = cost_1[y]*20/100 + cost_1[y];
			break;
		}
		
		case 2:
		{
			money = cost_2[y]*30/100 + cost_2[y];
			break;
		}
		
		case 3:
		{
			money = cost_3[y]*20/100 + cost_3[y];
			break;
		}
		
		case 4:
		{
			money = cost_4[y]*20/100 + cost_4[y];
			break;
		}

		default:
			break;
		}
		return money;
	}
	
	public void cantUp(int u, int v) {
		if (u != markTurn[v]) {
			if (u == 1 && wallet1 < cost[v]) {
				jButton.setText("CANT BUY");
				jCheckBox1.setVisible(false);
			    jCheckBox2.setVisible(false);
			    jCheckBox3.setVisible(false);
			    jCheckBox4.setVisible(false);
			}
			else if (u == 2 && wallet2 < cost[v]) {
				jButton.setText("CANT BUY");
				jCheckBox1.setVisible(false);
			    jCheckBox2.setVisible(false);
			    jCheckBox3.setVisible(false);
			    jCheckBox4.setVisible(false);
			}
			else if (u == 3 && wallet3 < cost[v]) {
				jButton.setText("CANT BUY");
				jCheckBox1.setVisible(false);
			    jCheckBox2.setVisible(false);
			    jCheckBox3.setVisible(false);
			    jCheckBox4.setVisible(false);
			}
			else if (u == 4 && wallet4 < cost[v]) {
				jButton.setText("CANT BUY");
				jCheckBox1.setVisible(false);
			    jCheckBox2.setVisible(false);
			    jCheckBox3.setVisible(false);
			    jCheckBox4.setVisible(false);
			}
		}
	}
	
	//o start
	public void start() {
	
		jButton.setText("YOU COME START");
		jCheckBox1.setVisible(false);
	    jCheckBox2.setVisible(false);
	    jCheckBox3.setVisible(false);
	    jCheckBox4.setVisible(false);
	    jButton1.setVisible(false);
	}
	
	//o K, I, N, G
	public void King() {
		jButton.setText("BUY CARD FOR 200");
		jCheckBox1.setVisible(false);
	    jCheckBox2.setVisible(false);
	    jCheckBox3.setVisible(false);
	    jCheckBox4.setVisible(false);
	}
	
	//voi o lo den vu tru
	public void BlackHole() {
	
		jButton.setText("YOU COME BLACK HOLE");
		jCheckBox1.setVisible(false);
	    jCheckBox2.setVisible(false);
	    jCheckBox3.setVisible(false);
	    jCheckBox4.setVisible(false);
	    jButton1.setVisible(false);
	    black[GameWork.temp1] = 1;
	}
	
	// o may man
	public void lucky() {

		jButton.setText("YOUR ROOL LUCKY");
		jCheckBox1.setVisible(false);
	    jCheckBox2.setVisible(false);
	    jCheckBox3.setVisible(false);
	    jCheckBox4.setVisible(false);
	    jButton1.setVisible(false);
	}
	
	//o world cup
	public void WorldCup() {
	
		jButton.setText("YOU WANT TO BUY WORLD CUP FOR 50");
		jCheckBox1.setVisible(false);
	    jCheckBox2.setVisible(false);
	    jCheckBox3.setVisible(false);
	    jCheckBox4.setVisible(false);
	   
	}
	
	//o teleport
	public void teleport() {
	
		jButton.setText("YOU WANT TO TELEPORT");
		jCheckBox1.setVisible(false);
	    jCheckBox2.setVisible(false);
	    jCheckBox3.setVisible(false);
	    jCheckBox4.setVisible(false);
	    
	    
	}
	
	//nop thue
	public void tax() {
		
		jButton.setText("YOU NEED TAX");
		jCheckBox1.setVisible(false);
	    jCheckBox2.setVisible(false);
	    jCheckBox3.setVisible(false);
	    jCheckBox4.setVisible(false);
	    jButton1.setVisible(false);
	}
	
	
	public void setBox(int i) {
		if (i == -1) {
			jCheckBox1.setSelected(false);
			jCheckBox2.setSelected(false);
			jCheckBox3.setSelected(false);
			jCheckBox3.setSelected(false);
			jCheckBox1.setEnabled(true);
			jCheckBox2.setEnabled(true);
			jCheckBox3.setEnabled(true);
			jCheckBox4.setEnabled(true);
			
		}
		if (i == 3) {
			jCheckBox1.setSelected(true);
			jCheckBox2.setSelected(true);
			jCheckBox3.setSelected(true);
			jCheckBox4.setSelected(true);
			jCheckBox1.setEnabled(false);
			jCheckBox2.setEnabled(false);
			jCheckBox3.setEnabled(false);
			jCheckBox4.setEnabled(false);
		}
		
		if (i == 2) {
			jCheckBox1.setSelected(true);
			jCheckBox2.setSelected(true);
			jCheckBox3.setSelected(true);
			jCheckBox1.setEnabled(false);
			jCheckBox2.setEnabled(false);
			jCheckBox3.setEnabled(false);
		}
		
		if (i == 1) {
			jCheckBox1.setSelected(true);
			jCheckBox2.setSelected(true);
			jCheckBox1.setEnabled(false);
			jCheckBox2.setEnabled(false);
		}
		if (i == 0) {
			jCheckBox1.setSelected(true);
			jCheckBox1.setEnabled(false);
		}
	}
	
	public int checkbox() {
		
		if (jCheckBox4.isSelected()) {
			return 3;
		}
		
		if (jCheckBox3.isSelected()) {
			return 2;
		}
		
		if (jCheckBox2.isSelected()) {
			return 1;
		}
		if (jCheckBox1.isSelected()) {
			return 0;
		}
		return -1;
		
	}

	private JCheckBox createCheckBox(String name) {
	    JCheckBox checkBox = new JCheckBox(name);
	    checkBox.addItemListener(this);
	    return checkBox;
	}
		
	public boolean getVisi() {
		return visi;
	}

	public void setVisi(boolean visi) {
		this.visi = visi;
	}
	
	//ham cho gia tri cua o bang 0 khi nguoi choi quay lai o gia tri do
	public void setBuyBack() {
		
		if (jCheckBox4.isEnabled() == false)
		{
			jButton.setText("BUY FOR 0");
		}
		
		else if (jCheckBox3.isEnabled() == false)
		{
			jButton.setText("BUY FOR 0");
		}
		
		else if (jCheckBox2.isEnabled() == false)
		{
			jButton.setText("BUY FOR 0");
		}
		else if (jCheckBox1.isEnabled() == false)
		{
			jButton.setText("BUY FOR 0");
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
		if (e.getSource() == jCheckBox1) {
			if (jCheckBox1.isSelected() == false) {
				jCheckBox2.setSelected(false);
				jCheckBox3.setSelected(false);
				jCheckBox4.setSelected(false);
				jButton.setText("DON'T BUY");
				this.lose = 0;
			}
			else { 
				jButton.setText("BUY FOR " + cost_0[GameWork.temp]);
				this.lose = cost_0[GameWork.temp];
			}
		}
		
		if (e.getSource() == jCheckBox2) {
			if (jCheckBox2.isSelected() == false) {
				jCheckBox3.setSelected(false);
				jCheckBox4.setSelected(false);
				jButton.setText("BUY FOR " + cost_0[GameWork.temp]);
				this.lose = cost_0[GameWork.temp];
			}
			else {
				jCheckBox1.setSelected(true);
				jButton.setText("BUY FOR " + cost_1[GameWork.temp]);
				this.lose = cost_1[GameWork.temp];
			}
		}
		
		if (e.getSource() == jCheckBox3) {
			if (jCheckBox3.isSelected() == false) {
				jCheckBox4.setSelected(false);
				jButton.setText("BUY FOR " + cost_1[GameWork.temp]);
				this.lose = cost_1[GameWork.temp];
			}
			else {
				jCheckBox1.setSelected(true);
				jCheckBox2.setSelected(true);
				jButton.setText("BUY FOR " + cost_2[GameWork.temp]);
				this.lose = cost_2[GameWork.temp];
			}
		}
		
		if (e.getSource() == jCheckBox4) {
			if (jCheckBox4.isSelected() == false) {
				jButton.setText("BUY FOR " + cost_3[GameWork.temp]);
				this.lose = cost_3[GameWork.temp];
			}
			else {
				jCheckBox1.setSelected(true);
				jCheckBox2.setSelected(true);
				jCheckBox3.setSelected(true);
				jButton.setText("BUY FOR " + cost_4[GameWork.temp]);
				this.lose = cost_4[GameWork.temp];
			}
		}
	
	}
	
	public void setTurnName() {
		if (GameWork.temp1 == 1) {
			turnName = GamePanel.jTextField1.getText();
		}
		else if (GameWork.temp1 == 2) {
			turnName = GamePanel.jTextField2.getText();
		}
		else if (GameWork.temp1 == 3) {
			turnName = GamePanel.jTextField3.getText();
		}
		else if (GameWork.temp1 == 4) {
			turnName = GamePanel.jTextField4.getText();
		}
		else turnName = "nguyen dinh hieu";
		
		jLabel.setText("Turn player " + turnName);
	}
	
	public int losePlayer() {
		if (wallet1 < 0) lostPlayer[1] = 1;
		if (wallet2 < 0) lostPlayer[2] = 1;
		if (wallet3 < 0) lostPlayer[3] = 1;
		if (wallet4 < 0) lostPlayer[4] = 1;
		for (int i = 0; i < 5; i++) {
			if(lostPlayer[i] == 1) {
				return 1;
			}
		}
		return 0;
	}
	
	public void win() {
		if ((markTurn[4] == markTurn[14] && markTurn[14] == markTurn[18] && markTurn[14] == markTurn[25] && markTurn[4] != 0)) {
			JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	        JOptionPane.showMessageDialog(frame,
	                "Player " + markTurn[4] + " Wins",
	                "WIN",
	                JOptionPane.INFORMATION_MESSAGE);
		}
		int d = 0;
		int win = 0;
		for (int i = 1; i<5; i++) {
			if (lostPlayer[i] == 1) {
				d++;
			}
			else win = i;
		}
		if (d == 3) {
			JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	        JOptionPane.showMessageDialog(frame,
	        		"Player " + win + " Wins",
	                "WIN",
	                JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public int[] getLostPlayer() {
		return lostPlayer;
	}

	public void setLostPlayer(int[] lostPlayer) {
		this.lostPlayer = lostPlayer;
	}

	public int[] getBlack() {
		return black;
	}

	public void setBlack(int n, int index) {
		this.black[index] = n;
	}

	public String getTurnName() {
		return turnName;
	}
	
	public int[] getMark() {
		return mark;
	}
	public void setMark(int[] mark) {
		this.mark = mark;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	public JButton getjButton() {
		return jButton;
	}
	public void setjButton(JButton jButton) {
		this.jButton = jButton;
	}
	public int[] getMarkTurn() {
		return markTurn;
	}
	public void setMarkTurn(int x, int y) {
		this.markTurn[x] = y;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}
	
}
