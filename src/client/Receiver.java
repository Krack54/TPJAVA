package client;

/**
 * Objet principal client
 * @author Robin Kebaili, Tristan Lefebvre
 *
 */
public class Receiver implements ReceiveInterface {

	public void afficheMessage(String s) {
		System.out.println("Message recu : "+s);
	}

}
