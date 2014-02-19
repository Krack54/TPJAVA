package client.gui;

import javax.swing.JFrame;

import server.DispatcherInterface;

public class MainFrame extends JFrame {

	// Fields
	private MainPanel mainPanel;
	
	// Constructors
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
	public MainPanel getMainPanel(){
		return this.mainPanel;
	}
}
