package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.listener.ConfigListener;
import service.ConfigService;
import util.ColorUtil;
import util.GUIUtil;

public class ConfigPanel extends WorkingPanel{
	static{
        GUIUtil.useLNF();
    }
	public static ConfigPanel configPanel = new ConfigPanel();
	
	JLabel lBudget = new JLabel("This month's budget");
	public JTextField budgetField = new JTextField("0");
	JLabel mySQLPath = new JLabel("MySQL installation path");
	public JTextField sqlField = new JTextField();
	JButton BUpdate = new JButton("Update");
	
	private ConfigPanel() {
		GUIUtil.setColor(ColorUtil.grayColor, lBudget,mySQLPath);
        //GUIUtil.setColor(ColorUtil.blueColor, BUpdate);
        
		JPanel northP = new JPanel();
		JPanel centerP = new JPanel();
		int gap = 40;
		northP.setLayout(new GridLayout(4, 1, gap, gap));
		northP.add(lBudget);
		northP.add(budgetField);
		northP.add(mySQLPath);
		northP.add(sqlField);
		centerP.add(BUpdate);
		
		this.setLayout(new BorderLayout());
		this.add(northP, BorderLayout.NORTH);
		this.add(centerP, BorderLayout.CENTER);
		
		addListener();
	}
	
	public static void main(String[] args) {
        GUIUtil.showPanel(ConfigPanel.configPanel);
    }

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		String budget = new ConfigService().get(ConfigService.budget);
		String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
		budgetField.setText(budget);
		sqlField.setText(mysqlPath);
		budgetField.grabFocus();
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		ConfigListener cl = new ConfigListener();
		BUpdate.addActionListener(cl);
	}
}
