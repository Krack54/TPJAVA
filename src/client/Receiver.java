package client;

import server.DispatcherInterface;
import client.gui.MainFrame;

/**
 * Objet principal client
 * @author Robin Kebaili, Tristan Lefebvre
 *
 */
public class Receiver implements ReceiveInterface {

	private MainFrame mainFrame;
	
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
