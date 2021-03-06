package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.panel.BackupPanel;
import gui.panel.CategoryPanel;
import gui.panel.ChartPanel;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.RecoverPanel;
import gui.panel.SpendPanel;

public class ToolBarListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MainPanel p = MainPanel.mainPanel;
		JButton b = (JButton) e.getSource();
		if (b == p.bReport) 
			p.workingPanel.show(ChartPanel.chartPanel);
		if (b == p.bCategory)
            p.workingPanel.show(CategoryPanel.categoryPanel);
        if (b == p.bSpend)
            p.workingPanel.show(SpendPanel.spendPanel);
        if (b == p.bRecord)
            p.workingPanel.show(RecordPanel.recordPanel);
        if (b == p.bConfig)
            p.workingPanel.show(ConfigPanel.configPanel);
        if (b == p.bBackup)
            p.workingPanel.show(BackupPanel.backupPanel);
        if (b == p.bRecover)
            p.workingPanel.show(RecoverPanel.recoverPanel);
	}

}
