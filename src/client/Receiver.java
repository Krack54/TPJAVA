package client;

import server.DispatcherInterface;
import client.gui.MainFrame;

/**
 * Objet principal client
 * @author Robin Kebaili, Tristan Lefebvre
 *
 */
public class Receiver implements ReceiveInterface {

	/**
	 * Fenetre principale
	 */
	private MainFrame mainFrame;
	
	/**
	 * Constructeur principal de l'objet principal client
	 * @param d Interface d'envoi
	 */
	public Receiver(DispatcherInterface d){
		this.mainFrame = new MainFrame(d);
	}
	
	public void afficheMessage(String s) {
		System.out.println("Message recu : "+s);
	}
	
	public void dessinePoint(int x,int y){
		this.mainFrame.getMainPanel().dessinePoint(x,y);
	}

}
