package client.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.rmi.RemoteException;

import javax.swing.JPanel;

import server.DispatcherInterface;

/**
 * Panel principal du programme client
 * @author Robrock
 *
 */
public class MainPanel extends JPanel {

	// Fields
	/**
	 * Position horizontale du curseur
	 */
	private int mouseX;
	
	/**
	 * Position verticale du curseur
	 */
	private int mouseY;
	
	/**
	 * Diamètre du point dessiné en pixels
	 */
	private static int PEN_SIZE = 10;
	
	/**
	 * Image où le dessin est effectué
	 */
	private BufferedImage image;
	
	/**
	 * Largeur fixe du panel
	 */
	public final static int PANEL_WIDTH = 800;
	
	/**
	 * Hauteur fixe du panel
	 */
	public final static int PANEL_HEIGHT = 600;
	
	/**
	 * Interface d'envoi des évennements
	 */
	private DispatcherInterface dispatcher;
	
	// Constructors
	/**
	 * Consucteur principal du panel
	 * @param d Interface d'envoi des évennements
	 */
	public MainPanel(DispatcherInterface d){
		this.mouseX = 200;
		this.mouseY = 200;
		
		this.image = new BufferedImage(MainPanel.PANEL_WIDTH,MainPanel.PANEL_HEIGHT,BufferedImage.TYPE_INT_ARGB);
		
		this.setPreferredSize(new Dimension(MainPanel.PANEL_WIDTH,MainPanel.PANEL_HEIGHT));

		this.dispatcher = d;
		
		MouseListener ml = new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			public void mousePressed(MouseEvent arg0) {
				try {
					MainPanel.this.dispatcher.dispatchPoint(arg0.getX(),arg0.getY());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
			
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			public void mouseClicked(MouseEvent arg0) {
				
			}
		};
		
		MouseMotionListener mml =new MouseMotionListener() {
			public void mouseMoved(MouseEvent arg0) {
				// Curseur
				MainPanel.this.mouseX = arg0.getX();
				MainPanel.this.mouseY = arg0.getY();
				MainPanel.this.repaint();
			}
			
			public void mouseDragged(MouseEvent arg0) {
				// Curseur
				MainPanel.this.mouseX = arg0.getX();
				MainPanel.this.mouseY = arg0.getY();
				MainPanel.this.repaint();
				
				// Dessin
				try {
					MainPanel.this.dispatcher.dispatchPoint(arg0.getX(),arg0.getY());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				
			}
		};
		
		this.addMouseMotionListener(mml);
		this.addMouseListener(ml);
	}
	
	// Methods
	/**
	 * Dessine un point sur l'image contenue dans le panel
	 * @param x Position horizontale du point
	 * @param y Position verticale du point
	 */
	public void dessinePoint(int x,int y){
		Graphics g = this.image.getGraphics();
		g.setColor(Color.black);
		g.fillOval(x-MainPanel.PEN_SIZE/2,y-MainPanel.PEN_SIZE/2,MainPanel.PEN_SIZE,MainPanel.PEN_SIZE);
		
		this.repaint();
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(this.image, 0, 0, null);
		
		g.setColor(Color.black);
		g.fillOval(this.mouseX-MainPanel.PEN_SIZE/2,this.mouseY-MainPanel.PEN_SIZE/2,MainPanel.PEN_SIZE,MainPanel.PEN_SIZE);
	}
}
