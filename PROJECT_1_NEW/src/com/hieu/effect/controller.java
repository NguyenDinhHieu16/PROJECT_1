package com.hieu.effect;

import java.awt.Dimension;
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
import javax.swing.JPanel;

import com.hieu.userinterface.BackGr2_Play;

public class controller extends JFrame implements ItemListener{

	private int cost_0[] = {0, 60, 60, 60, 200, 100, 100, 120, 0, 140, 140, 160, 0, 180, 200, 200, 50, 220, 200, 240, 0, 260, 260, 280, 50, 200, 300, 320, 0, 350, 0, 400};
	private int cost_1[] = {0, 110, 110, 110, 200, 150, 150, 170, 200, 240, 240, 260, 0, 280, 200, 300, 50, 370, 200, 390, 0, 410, 410, 430, 50, 200, 500, 520, 0, 550, 0, 600};
	private int cost_2[] = {0, 160, 160, 160, 200, 200, 200, 220, 0, 340, 340, 360, 0, 380, 200, 400, 50, 520, 200, 540, 0, 560, 560, 580, 50, 200, 700, 720, 0, 750, 0, 800};
	private int cost_3[] = {0, 210, 210, 210, 200, 250, 250, 270, 0, 440, 440, 460, 0, 480, 200, 500, 50, 670, 200, 690, 0, 710, 710, 730, 50, 200, 900, 920, 0, 950, 0, 1000};
	private int cost_4[] = {0, 360, 360, 360, 200, 400, 400, 420, 0, 690, 690, 710, 0, 730, 200, 750, 50, 1045, 200, 1065, 0, 1085, 1085, 1105, 50, 200, 1400, 1420, 0, 1450, 0, 1500};
	
	public static int wallet1 = 2000, wallet2 = 2000, wallet3 = 2000, wallet4 = 2000;
	
	private int check = 0;
	
	private int[] mark = new int[33];//danh dau cap nha da mua
	private int[] markTurn = new int[33];//danh dau vi tri da mua
	
	private boolean visi = false;//set an hien jframe thong bao
	private JPanel jPanel;
	
	private JButton jButton;
	
	private int lose = 0, lose1, lose2, lose3, lose4;
	private JCheckBox jCheckBox1, jCheckBox2, jCheckBox3, jCheckBox4;
	
	public static JLabel jLabel1, jLabel2, jLabel3, jLabel4;
	
	private Graphics2D g2;
	private BufferedImage bufferedImage1;
	public static boolean drawN = false;
	
	
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
		Arrays.fill(mark, -1);
		Arrays.fill(markTurn, 0);
		
		g2 = (Graphics2D)jPanel.getGraphics();
		try {
			bufferedImage1 = ImageIO.read(new File("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/green1.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		jLabel1 = new JLabel("" + wallet1);
//		jLabel2 = new JLabel("" + wallet2);
//		jLabel3 = new JLabel("" + wallet3);
//		jLabel4 = new JLabel("" + wallet4);
//		
//		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
//        this.setLayout(layout);
//		
//		layout.setHorizontalGroup(
//	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//	            .addGroup(layout.createSequentialGroup()
//	                    .addGap(600)
//	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//	                        .addComponent(jLabel2)
//	                        .addComponent(jLabel1))
//	                    .addContainerGap(188, Short.MAX_VALUE))
//	                .addGroup(layout.createSequentialGroup()
//	                    .addComponent(jLabel3)
//	                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//	                    .addComponent(jLabel4))
//	        );
//	        layout.setVerticalGroup(
//	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//	                    .addComponent(jLabel2)
//	                    .addGap(275)
//	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//	                        .addComponent(jLabel3)
//	                        .addComponent(jLabel4))
//	                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
//	                    .addComponent(jLabel1))
//	        );
		
		
		jButton = new JButton("DON'T UP");
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisi(false);
				setVisible(visi);
				markTurn[GameWork.temp] = GameWork.temp1;
				mark[GameWork.temp] = checkbox();
				loseMoney();
				drawN = true;
//				output(mark, 33);
//				output(markTurn, 33);
				
			}
		});
		
//		jCheckBox1 = new JCheckBox(new ImageIcon("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/house1.png"));
//		jCheckBox2 = new JCheckBox(new ImageIcon("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/house2.png"));
//		jCheckBox3 = new JCheckBox(new ImageIcon("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/house3.png"));
//		jCheckBox4 = new JCheckBox(new ImageIcon("C:\\Users\\HieuNGUYXN\\eclipse-workspace\\PROJECT_1_NEW\\imageBackground/land.png"));
		
		
		jCheckBox1 = createCheckBox("Land");
		jCheckBox2 = createCheckBox("House1");
		jCheckBox3 = createCheckBox("House2");
		jCheckBox4 = createCheckBox("House3");
		
        this.setVisible(visi);
	
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(bufferedImage1, 100, 100, null);
	}
	
	//voi o khong co chuc nang
	public void init1() {
		jPanel.removeAll();
		this.add(jPanel);
//		jPanel.setLayout(new FlowLayout());
		jPanel.add(Box.createRigidArea(new Dimension(600, 25)));
		jPanel.add(jCheckBox1);
		jPanel.add(jCheckBox2);
		jPanel.add(jCheckBox3);
		jPanel.add(jCheckBox4);
		jPanel.add(Box.createRigidArea(new Dimension(600, 50)));
	    jButton.setText("DON'T UP");
        jPanel.add(jButton);
        this.add(jPanel);
        this.repaint();
	}
	
	//tru tiwn khi mua
	public void loseMoney() {
		if (GameWork.temp1 == 1) { 
			this.wallet1 -= lose;
			System.out.println(wallet1);
			lose1 = lose;
		}
		else if (GameWork.temp1 == 2) { 
			this.wallet2 -= lose;
			System.out.println(wallet2);
			lose2 = lose;
		}
		else if (GameWork.temp1 == 3) { 
			this.wallet3 -= lose;
			System.out.println(wallet3);
			lose3 = lose;
		}
		else if (GameWork.temp1 == 4) { 
			this.wallet4 -= lose;
			System.out.println(wallet4);
			lose4 = lose;
		}
		System.out.println(lose);
	}
	
	//o start
	public void start() {
		jPanel.removeAll();
//		jPanel.add(Box.createRigidArea(new Dimension(600, 100)));
		jButton.setText("YOU COME START");
		jPanel.add(jButton);
		this.add(jPanel);
	    this.repaint();
	}
	
	//o K, I, N, G
	public void King() {
		jPanel.removeAll();
//		jPanel.add(Box.createRigidArea(new Dimension(600, 100)));
		jButton.setText("BUY CARD FOR 200");
		jPanel.add(jButton);
		this.add(jPanel);
	    this.repaint();
	}
	
	//voi o lo den vu tru
	public void BlackHole() {
		jPanel.removeAll();
//		jPanel.add(Box.createRigidArea(new Dimension(600, 100)));
		jButton.setText("YOU COME BLACK HOLE");
	    jPanel.add(jButton);
		this.add(jPanel);
		this.repaint();
	}
	
	// o may man
	public void lucky() {
		jPanel.removeAll();
//		jPanel.add(Box.createRigidArea(new Dimension(600, 100)));
		jButton.setText("YOUR ROOL LUCKY");
	    jPanel.add(jButton);
		this.add(jPanel);
		this.repaint();
	}
	
	//o world cup
	public void WorldCup() {
		jPanel.removeAll();
//		jPanel.add(Box.createRigidArea(new Dimension(600, 100)));
		jButton.setText("YOU WANT TO BUY WORLD CUP FOR 50");
	    jPanel.add(jButton);
		this.add(jPanel);
		this.repaint();
	}
	
	//o teleport
	public void teleport() {
		jPanel.removeAll();
//		jPanel.add(Box.createRigidArea(new Dimension(600, 100)));
		jButton.setText("YOU WANT TO TELEPORT");
	    this.repaint();
	    jPanel.add(jButton);
		this.add(jPanel);
	}
	
	//nop thue
	public void tax() {
		jPanel.removeAll();
//		jPanel.add(Box.createRigidArea(new Dimension(600, 100)));
		jButton.setText("YOU NEED TAX");
	    this.repaint();
	    jPanel.add(jButton);
		this.add(jPanel);
	}
	
	public void output(int[] mark, int n) {
		for (int i= 0 ;i <n; i++) {
			System.out.print(mark[i]+" ");
		}
		System.out.println();
	}
	
//	public void setVistWithTurn() {
//		if (GameWork.temp1 == 1) {
//			markTurn[GameWork.temp] = 1;
//		}
//		if (GameWork.temp1 == 2) {
//			markTurn[GameWork.temp] = 2;
//		}
//		if (GameWork.temp1 == 3) {
//			markTurn[GameWork.temp] = 3;
//		}
//		if (GameWork.temp1 == 1) {
//			markTurn[GameWork.temp] = 1;
//		}
//	}
	
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

	public int getWallet1() {
		return wallet1;
	}

	public void setWallet1(int wallet1) {
		this.wallet1 = wallet1;
	}

	public int getWallet2() {
		return wallet2;
	}

	public void setWallet2(int wallet2) {
		this.wallet2 = wallet2;
	}

	public int getWallet3() {
		return wallet3;
	}

	public void setWallet3(int wallet3) {
		this.wallet3 = wallet3;
	}

	public int getWallet4() {
		return wallet4;
	}

	public void setWallet4(int wallet4) {
		this.wallet4 = wallet4;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getLose1() {
		return lose1;
	}

	public void setLose1(int lose1) {
		this.lose1 = lose1;
	}

	public int getLose2() {
		return lose2;
	}

	public void setLose2(int lose2) {
		this.lose2 = lose2;
	}

	public int getLose3() {
		return lose3;
	}

	public void setLose3(int lose3) {
		this.lose3 = lose3;
	}

	public int getLose4() {
		return lose4;
	}

	public void setLose4(int lose4) {
		this.lose4 = lose4;
	}
	
	
	
}
