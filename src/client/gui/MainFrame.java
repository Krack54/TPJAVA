package client.gui;

import javax.swing.JFrame;

import server.DispatcherInterface;

/**
 * Fenêtre principale du client
 * @author Robrock
 *
 */
public class MainFrame extends JFrame {

	// Fields
	/**
	 * Panel principal de la fenêtre
	 */
	private MainPanel mainPanel;
	
	// Constructors
	/**
	 * Constructeur principal de la fenêtre
	 * @param d Interface d'envoi
	 */
	public MainFrame(DispatcherInterface d){
		super();
		
		this.mainPanel = new MainPanel(d);
		this.mainPanel.requestFocus();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(this.mainPanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	// Methods
	/**
	 * Getter du panel
	 * @return Panel principal de la fenêtre
	 */
	public MainPanel getMainPanel(){
		return this.mainPanel;
	}
}
