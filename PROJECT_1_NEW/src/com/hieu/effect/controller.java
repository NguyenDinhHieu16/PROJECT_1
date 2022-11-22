package com.hieu.effect;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.Box.Filler;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.hieu.userinterface.BackGr2_Play;

public class controller extends JFrame implements ItemListener{

	private int cost_0[] = {0, 60, 60, 60, 200, 100, 100, 120, 0, 140, 140, 160, 0, 180, 200, 200, 50, 220, 200, 240, 0, 260, 260, 280, 50, 200, 300, 320, 0, 350, 0, 400};
	private int cost_1[] = {0, 110, 110, 110, 200, 150, 150, 170, 200, 240, 240, 260, 0, 280, 200, 300, 50, 370, 200, 390, 0, 410, 410, 430, 50, 200, 500, 520, 0, 550, 0, 600};
	private int cost_2[] = {0, 160, 160, 160, 200, 200, 200, 220, 0, 340, 340, 360, 0, 380, 200, 400, 50, 520, 200, 540, 0, 560, 560, 580, 50, 200, 700, 720, 0, 750, 0, 800};
	private int cost_3[] = {0, 210, 210, 210, 200, 250, 250, 270, 0, 440, 440, 460, 0, 480, 200, 500, 50, 670, 200, 690, 0, 710, 710, 730, 50, 200, 900, 920, 0, 950, 0, 1000};
	private int cost_4[] = {0, 360, 360, 360, 200, 400, 400, 420, 0, 690, 690, 710, 0, 730, 200, 750, 50, 1045, 200, 1065, 0, 1085, 1085, 1105, 50, 200, 1400, 1420, 0, 1450, 0, 1500};
	
	private int wallet1 = 2000, wallet2 = 2000, wallet3 = 2000, wallet4 = 2000;
	
	private int check = 0;
	
	private int[] mark = new int[33];
	private int[] markTurn = new int[33];
	
	private boolean visi = false;
	private JPanel jPanel;
	
	private JButton jButton;
	
	private JCheckBox jCheckBox1, jCheckBox2, jCheckBox3, jCheckBox4;
	
	public controller() {
		
		jPanel = new JPanel();
		
		this.setTitle("Buy?");
		this.setSize(600, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		Arrays.fill(mark, -1);
		Arrays.fill(markTurn, 0);
		
		jButton = new JButton("DON'T UP");
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisi(false);
				setVisible(visi);
				markTurn[GameWork.temp] = GameWork.temp1;
				mark[GameWork.temp] = checkbox();
				output(mark, 33);
				output(markTurn, 33);
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
		
		jPanel.setLayout(new FlowLayout());
		jPanel.add(Box.createRigidArea(new Dimension(600, 25)));
		jPanel.add(jCheckBox1);
		jPanel.add(jCheckBox2);
		jPanel.add(jCheckBox3);
		jPanel.add(jCheckBox4);
		jPanel.add(Box.createRigidArea(new Dimension(600, 50)));
	    
        jPanel.add(jButton);
        this.add(jPanel);
		
        this.setVisible(visi);
	
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

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if (e.getSource() == jCheckBox1) {
			if (jCheckBox1.isSelected() == false) {
				jCheckBox2.setSelected(false);
				jCheckBox3.setSelected(false);
				jCheckBox4.setSelected(false);
				jButton.setText("DON'T BUY");
			}
			else jButton.setText("BUY FOR " + cost_0[GameWork.temp]);
		}
		
		if (e.getSource() == jCheckBox2) {
			if (jCheckBox2.isSelected() == false) {
				jCheckBox3.setSelected(false);
				jCheckBox4.setSelected(false);
				jButton.setText("BUY FOR " + cost_0[GameWork.temp]);
			}
			else {
				jCheckBox1.setSelected(true);
				jButton.setText("BUY FOR " + cost_1[GameWork.temp]);
			}
		}
		
		if (e.getSource() == jCheckBox3) {
			if (jCheckBox3.isSelected() == false) {
				jCheckBox4.setSelected(false);
				jButton.setText("BUY FOR " + cost_1[GameWork.temp]);
			}
			else {
				jCheckBox1.setSelected(true);
				jCheckBox2.setSelected(true);
				jButton.setText("BUY FOR " + cost_2[GameWork.temp]);
			}
		}
		
		if (e.getSource() == jCheckBox4) {
			if (jCheckBox4.isSelected() == false) {
				jButton.setText("BUY FOR " + cost_3[GameWork.temp]);
			}
			else {
				jCheckBox1.setSelected(true);
				jCheckBox2.setSelected(true);
				jCheckBox3.setSelected(true);
				jButton.setText("BUY FOR " + cost_4[GameWork.temp]);
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
	
	
}
