package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;

public class MainPanel extends JPanel{
	static {
		GUIUtil.useLNF();
	}
	
	public static MainPanel mainPanel = new MainPanel();
	public JToolBar tb = new JToolBar();
	public JButton bSpend = new JButton();
	public JButton bRecord = new JButton();
	public JButton bCategory = new JButton();
	public JButton bReport = new JButton();
	public JButton bConfig = new JButton();
	public JButton bBackup = new JButton();
	public JButton bRecover = new JButton();
	
	public CenterPanel workingPanel;
	
	private MainPanel() {
		GUIUtil.setImageIcon(bSpend, "home.png", "Consumptions");
		GUIUtil.setImageIcon(bRecord, "record.png", "Note a Bill");
        GUIUtil.setImageIcon(bCategory, "category2.png", "Category");
        GUIUtil.setImageIcon(bReport, "report.png", "Monthly Report");
        GUIUtil.setImageIcon(bConfig, "config.png", "settings");
        GUIUtil.setImageIcon(bBackup, "backup.png", "Backup");
        GUIUtil.setImageIcon(bRecover, "restore.png", "Recover");
        
        tb.add(bSpend);
		tb.add(bRecord);
		tb.add(bCategory);
		tb.add(bReport);
		tb.add(bConfig);
		tb.add(bBackup);
		tb.add(bRecover);
		
		tb.setFloatable(false);
		
		workingPanel = new CenterPanel(0.8);
		
		this.setLayout(new BorderLayout());
		this.add(tb, BorderLayout.NORTH);
		this.add(workingPanel, BorderLayout.CENTER);
		
		addListener();
	}
	
	public void addListener() {
		ToolBarListener listener = new ToolBarListener();
		
		bSpend.addActionListener(listener);
		bRecord.addActionListener(listener);
		bCategory.addActionListener(listener);
		bReport.addActionListener(listener);
		bConfig.addActionListener(listener);
		bBackup.addActionListener(listener);
		bRecover.addActionListener(listener);
	}
	
	public static void main(String[] args) {
        GUIUtil.showPanel(MainPanel.mainPanel, 1);
    }
	
}
