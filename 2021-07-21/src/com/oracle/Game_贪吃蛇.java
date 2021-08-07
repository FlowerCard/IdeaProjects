package com.oracle;

/**
 * 软件开发=框架 + 插入点
 *	本UI框架，第15次课，详细讲解,学员都能“自主”写出来！
 */
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class Game_贪吃蛇
{
	//TODO:变量“声明”在此
	int fx = 0;
	int[] x = new int[200];
	int[] y = new int[200];
	int len = 3;
	int douX = (int)(Math.random()*19+1);
	int douY = (int)(Math.random()*19+1);
	
	boolean flag = false;
	boolean flag2 = false;
	int superDou = (int)(Math.random()*10+1);
	int count = 0;
	
	窗口	ck	= null;
	定时器	ds1	= null;

	Game_贪吃蛇()
	{
	    
	   
	    
	    //TODO:程序初始化在此
		x[0] = 7;
		y[0] = 7;
		
		x[1] = 6;
		y[1] = 7;
		
		x[2] = 5;
		y[2] = 7;

		ck = new 窗口();
		//窗口 宽+2*立体边, 高+2*立体边+标题栏
		ck.setSize(5 * 2 + 830, 645 + 2 * 5 + 25);
		//设定窗口可见性setVisible  true/false
		ck.setVisible(true);
		//延时的毫秒
		ds1 = new 定时器(200);
	}

	class 窗口 extends JFrame
	{
		菜单		cd		= null;
		面板		mb		= null;
		窗口监听器	exit	= null;
		键盘监听器	jp		= null;

		窗口()
		{
			jp = new 键盘监听器();
			this.addKeyListener(jp);

			cd = new 菜单();
			this.setJMenuBar(cd);

			mb = new 面板();
			this.add(mb);

			exit = new 窗口监听器();
			this.addWindowListener(exit);

			this.repaint();
		}

		class 菜单 extends JMenuBar
		{
			JMenu		dan;	//菜单
			JMenuItem	xiang1; //菜单项

			菜单监听器		cdjtq;

			菜单()
			{
				dan = new JMenu("游戏"); //菜单
				xiang1 = new JMenuItem("开局"); //菜单项

				this.add(dan);
				dan.add(xiang1);

				cdjtq = new 菜单监听器();
				xiang1.addActionListener(cdjtq);
			}

			class 菜单监听器 implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
				{
					//TODO:菜单事件处理
					if (e.getSource() == xiang1)
					{

					}
				}
			}
		}

		class 窗口监听器 extends WindowAdapter
		{
			public void windowClosing(WindowEvent e)
			{
				ds1.xc.stop();
				System.exit(0);
			}
		}

		class 键盘监听器 implements KeyListener
		{
			//TODO:键盘处理，可加入KeyEvent.VK_XXX
			public void keyPressed(KeyEvent e)
			{
				
					switch (e.getKeyCode())
					{
						case KeyEvent.VK_LEFT://左
							if(fx == 0) {
								
							}else {
								fx = 2;
								
							}
							break;
						case KeyEvent.VK_RIGHT://右
							if(fx == 2) {
								
							}else {
								fx = 0;
							}
							break;
						case KeyEvent.VK_UP://上
							if(fx == 3) {
								
							}else {
								fx = 1;
							}
							break;
						case KeyEvent.VK_DOWN://下
							if(fx==1) {
								
							}else {
								fx = 3;
							}
							break;
					}
					
				
				repaint();
			}

			public void keyReleased(KeyEvent e)
			{
			}

			public void keyTyped(KeyEvent e)
			{
			}
		}

		class 面板 extends JPanel
		{
			鼠标监听器	sb	= null;

			面板()
			{
				sb = new 鼠标监听器();
				this.addMouseListener(sb);
				this.addMouseMotionListener(sb);
			}

			class 鼠标监听器 extends MouseAdapter implements MouseMotionListener
			{
				public void mousePressed(MouseEvent e)
				{
				}

				public void mouseDragged(MouseEvent e)
				{
				}

				public void mouseMoved(MouseEvent e)
				{
				}

				public void mouseReleased(MouseEvent e)
				{
				}

				public void mouseClicked(MouseEvent e)//鼠标单击
				{
					//mx my鼠标的位置
					int mx = e.getX();
					int my = e.getY();
					//鼠标左键	BUTTON1、右键BUTTON3
					if (e.getButton() == MouseEvent.BUTTON1)
					{
						//TODO:鼠标左键单击 

					}

					repaint();
				}
			}

			public void paint(Graphics g)
			{
				//g.setColor(Color.BLUE);	//设定颜色：RED GREEN  BLUE  ORANGE  WHITE  GRAY BLACK PINK
				//g.drawRect(左,上,宽,高);	//矩形
				//g.fillRect(左,上,宽,高);	//实心矩形
				//g.drawOval(左,上,宽,高);	//椭圆
				//g.fillOval(左,上,宽,高);		//实心椭圆

				//Image  tu=(new ImageIcon( 路径 )).getImage();	//路径：图片-右键-属性-路径src/	
				//g.drawImage(tu,x,y,null);						

				//TODO:绘图在此
				Image backGround = (new ImageIcon("贪吃蛇/背景.png")).getImage();
				g.drawImage(backGround,0,0,null);
				
				Image head = (new ImageIcon("贪吃蛇/头" + fx + ".png")).getImage();
				g.drawImage(head, x[0]*30+10, y[0]*30+10, null);
				
				if(flag) {
					Image gameOver = (new ImageIcon("贪吃蛇/gameover.png")).getImage();
					g.drawImage(gameOver, 270, 270, null);
				}
				
				for (int i = 1; i < len; i++) {
					Image body = (new ImageIcon("贪吃蛇/身.png")).getImage();
					g.drawImage(body, x[i]*30+10, y[i]*30+10, null);
				}
				
				if(!flag2) {
					Image dou = (new ImageIcon("贪吃蛇/豆.png")).getImage();
					g.drawImage(dou,douX*30+10,douY*30+10,null);
				}else {
					Image superDou = (new ImageIcon("贪吃蛇/超级豆.png")).getImage();
					g.drawImage(superDou, douX*30+10, douY*30+10, null);
				}
			
				
			}
		}
	}

	class 定时器 implements Runnable//实现Runnable接口
	{
		Thread	xc	= null;
		long	jianGe;

		定时器(long jianGe)
		{
			this.jianGe = jianGe;
			xc = new Thread(this);
			xc.start();
		}

		public void run()
		{
			while (true)
			{
				try
				{
					xc.sleep(jianGe);

					if (this == ds1)
					{
						if (!flag) {
							for(int i=len ; i>=1 ; i--) {
								x[i] = x[i-1];
								y[i] = y[i-1];
							}
							
							if(fx==0) {
								x[0]++;
							}else if(fx==1) {
								y[0]--;
							}else if(fx==2) {
								x[0]--;
							}else if(fx==3) {
								y[0]++;
							}
							
							for(int i=len ; i>=1 ; i--) {
								if(x[0] == x[i] &&  y[0] == y[i]) {
									flag = true;
								}
							}
						}
						
						if(x[0] == 20 || x[0] < 0 || y[0] == 20 || y[0] < 0) {
							flag = true;
						}
						
						
						
						
						
						if(x[0] == douX && y[0] == douY) {
							douX = (int)(Math.random()*19+1);
							douY = (int)(Math.random()*19+1);
							len++;
							count++;
						}
						
						if(count == superDou) {
							flag2 = true;
						}else if(count > superDou) {
							flag2 = false;
							superDou = (int)(Math.random()*10+1);
							count = 0;
						}
						
						
						ck.repaint();
					}
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	//main主方法 ，主类的“入口方法”
	public static void main(String[] args)
	{
		new Game_贪吃蛇();
		
	}
}
