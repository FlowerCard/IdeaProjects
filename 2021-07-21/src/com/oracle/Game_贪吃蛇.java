package com.oracle;

/**
 * �������=��� + �����
 *	��UI��ܣ���15�οΣ���ϸ����,ѧԱ���ܡ�������д������
 */
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class Game_̰����
{
	//TODO:�������������ڴ�
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
	
	����	ck	= null;
	��ʱ��	ds1	= null;

	Game_̰����()
	{
	    
	   
	    
	    //TODO:�����ʼ���ڴ�
		x[0] = 7;
		y[0] = 7;
		
		x[1] = 6;
		y[1] = 7;
		
		x[2] = 5;
		y[2] = 7;

		ck = new ����();
		//���� ��+2*�����, ��+2*�����+������
		ck.setSize(5 * 2 + 830, 645 + 2 * 5 + 25);
		//�趨���ڿɼ���setVisible  true/false
		ck.setVisible(true);
		//��ʱ�ĺ���
		ds1 = new ��ʱ��(200);
	}

	class ���� extends JFrame
	{
		�˵�		cd		= null;
		���		mb		= null;
		���ڼ�����	exit	= null;
		���̼�����	jp		= null;

		����()
		{
			jp = new ���̼�����();
			this.addKeyListener(jp);

			cd = new �˵�();
			this.setJMenuBar(cd);

			mb = new ���();
			this.add(mb);

			exit = new ���ڼ�����();
			this.addWindowListener(exit);

			this.repaint();
		}

		class �˵� extends JMenuBar
		{
			JMenu		dan;	//�˵�
			JMenuItem	xiang1; //�˵���

			�˵�������		cdjtq;

			�˵�()
			{
				dan = new JMenu("��Ϸ"); //�˵�
				xiang1 = new JMenuItem("����"); //�˵���

				this.add(dan);
				dan.add(xiang1);

				cdjtq = new �˵�������();
				xiang1.addActionListener(cdjtq);
			}

			class �˵������� implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
				{
					//TODO:�˵��¼�����
					if (e.getSource() == xiang1)
					{

					}
				}
			}
		}

		class ���ڼ����� extends WindowAdapter
		{
			public void windowClosing(WindowEvent e)
			{
				ds1.xc.stop();
				System.exit(0);
			}
		}

		class ���̼����� implements KeyListener
		{
			//TODO:���̴����ɼ���KeyEvent.VK_XXX
			public void keyPressed(KeyEvent e)
			{
				
					switch (e.getKeyCode())
					{
						case KeyEvent.VK_LEFT://��
							if(fx == 0) {
								
							}else {
								fx = 2;
								
							}
							break;
						case KeyEvent.VK_RIGHT://��
							if(fx == 2) {
								
							}else {
								fx = 0;
							}
							break;
						case KeyEvent.VK_UP://��
							if(fx == 3) {
								
							}else {
								fx = 1;
							}
							break;
						case KeyEvent.VK_DOWN://��
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

		class ��� extends JPanel
		{
			��������	sb	= null;

			���()
			{
				sb = new ��������();
				this.addMouseListener(sb);
				this.addMouseMotionListener(sb);
			}

			class �������� extends MouseAdapter implements MouseMotionListener
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

				public void mouseClicked(MouseEvent e)//��굥��
				{
					//mx my����λ��
					int mx = e.getX();
					int my = e.getY();
					//������	BUTTON1���Ҽ�BUTTON3
					if (e.getButton() == MouseEvent.BUTTON1)
					{
						//TODO:���������� 

					}

					repaint();
				}
			}

			public void paint(Graphics g)
			{
				//g.setColor(Color.BLUE);	//�趨��ɫ��RED GREEN  BLUE  ORANGE  WHITE  GRAY BLACK PINK
				//g.drawRect(��,��,��,��);	//����
				//g.fillRect(��,��,��,��);	//ʵ�ľ���
				//g.drawOval(��,��,��,��);	//��Բ
				//g.fillOval(��,��,��,��);		//ʵ����Բ

				//Image  tu=(new ImageIcon( ·�� )).getImage();	//·����ͼƬ-�Ҽ�-����-·��src/	
				//g.drawImage(tu,x,y,null);						

				//TODO:��ͼ�ڴ�
				Image backGround = (new ImageIcon("̰����/����.png")).getImage();
				g.drawImage(backGround,0,0,null);
				
				Image head = (new ImageIcon("̰����/ͷ" + fx + ".png")).getImage();
				g.drawImage(head, x[0]*30+10, y[0]*30+10, null);
				
				if(flag) {
					Image gameOver = (new ImageIcon("̰����/gameover.png")).getImage();
					g.drawImage(gameOver, 270, 270, null);
				}
				
				for (int i = 1; i < len; i++) {
					Image body = (new ImageIcon("̰����/��.png")).getImage();
					g.drawImage(body, x[i]*30+10, y[i]*30+10, null);
				}
				
				if(!flag2) {
					Image dou = (new ImageIcon("̰����/��.png")).getImage();
					g.drawImage(dou,douX*30+10,douY*30+10,null);
				}else {
					Image superDou = (new ImageIcon("̰����/������.png")).getImage();
					g.drawImage(superDou, douX*30+10, douY*30+10, null);
				}
			
				
			}
		}
	}

	class ��ʱ�� implements Runnable//ʵ��Runnable�ӿ�
	{
		Thread	xc	= null;
		long	jianGe;

		��ʱ��(long jianGe)
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

	//main������ ������ġ���ڷ�����
	public static void main(String[] args)
	{
		new Game_̰����();
		
	}
}
