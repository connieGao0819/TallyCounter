package gui.frame;

import javax.swing.JFrame;

import gui.panel.MainPanel;

public class MainFrame extends JFrame {
	
	public static MainFrame mainFrame = new MainFrame();
	
	private MainFrame() {
		this.setSize(500, 450);
		this.setTitle("Tally Counter");
		this.setContentPane(MainPanel.mainPanel);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
        mainFrame.setVisible(true);
    }
}
