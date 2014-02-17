package client.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	// Fields
	private int mouseX,mouseY;
	private static int PEN_SIZE = 10;
	private BufferedImage image;
	public final static int PANEL_WIDTH = 800;
	public final static int PANEL_HEIGHT = 600;
	
	private long before;
	// Constructors
	public MainPanel(){
		this.mouseX = 200;
		this.mouseY = 200;
		
		this.image = new BufferedImage(MainPanel.PANEL_WIDTH,MainPanel.PANEL_HEIGHT,BufferedImage.TYPE_INT_ARGB);
		
		this.setPreferredSize(new Dimension(MainPanel.PANEL_WIDTH,MainPanel.PANEL_HEIGHT));

		
		MouseMotionListener mml =new MouseMotionListener() {
			public void mouseMoved(MouseEvent arg0) {
				MainPanel.this.mouseX = arg0.getX();
				MainPanel.this.mouseY = arg0.getY();
				MainPanel.this.repaint();
			}
			
			public void mouseDragged(MouseEvent arg0) {
				MainPanel.this.mouseX = arg0.getX();
				MainPanel.this.mouseY = arg0.getY();
				MainPanel.this.repaint();
				
				System.out.println((System.nanoTime()-before)/1000);
				before = System.nanoTime();				
				Graphics g = MainPanel.this.image.getGraphics();
				g.setColor(Color.black);
				g.fillOval(arg0.getX()-MainPanel.PEN_SIZE/2,arg0.getY()-MainPanel.PEN_SIZE/2,MainPanel.PEN_SIZE,MainPanel.PEN_SIZE);
				
			}
		};
		
		this.addMouseMotionListener(mml);
	}
	
	// Methods
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(this.image, 0, 0, null);
		
		g.setColor(Color.black);
		g.fillOval(this.mouseX-MainPanel.PEN_SIZE/2,this.mouseY-MainPanel.PEN_SIZE/2,MainPanel.PEN_SIZE,MainPanel.PEN_SIZE);
	}
}
