package client.gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	// Fields
	private MainPanel mainPanel;
	
	// Constructors
	public MainFrame(){
		super();
		
		this.mainPanel = new MainPanel();
		this.mainPanel.requestFocus();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(this.mainPanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	// Methods
}
