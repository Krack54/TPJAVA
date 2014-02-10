package client.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	// Fields
	private int mouseX,mouseY;
	private static int PEN_SIZE = 10;
	
	// Constructors
	public MainPanel(){
		this.mouseX = 200;
		this.mouseY = 200;
		
		this.setPreferredSize(new Dimension(800,600));
		this.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			public void mousePressed(MouseEvent arg0) {
				
			}
			
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		
		this.addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent arg0) {
				MainPanel.this.mouseX = arg0.getX();
				MainPanel.this.mouseY = arg0.getY();
				MainPanel.this.repaint();
			}
			
			public void mouseDragged(MouseEvent arg0) {
				MainPanel.this.mouseX = arg0.getX();
				MainPanel.this.mouseY = arg0.getY();
				MainPanel.this.repaint();
				
				// TODO dessin
			}
		});
	}
	
	// Methods
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(),this.getHeight());
		
		g.setColor(Color.black);
		g.fillOval(this.mouseX-MainPanel.PEN_SIZE/2,this.mouseY-MainPanel.PEN_SIZE/2,MainPanel.PEN_SIZE,MainPanel.PEN_SIZE);
	}
}
