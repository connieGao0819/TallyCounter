package gui.panel;

import javax.swing.JButton;

import gui.listener.BackupListener;
import util.ColorUtil;
import util.GUIUtil;

public class BackupPanel extends WorkingPanel {
    static{
        GUIUtil.useLNF();
    }
             
    public static BackupPanel backupPanel = new BackupPanel();
    JButton bBackup =new JButton("Backup");
 
    public BackupPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bBackup);
        this.add(bBackup);
        addListener();
    }
 
    public static void main(String[] args) {
        GUIUtil.showPanel(BackupPanel.backupPanel);
    }

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		BackupListener listener = new BackupListener();
		bBackup.addActionListener(listener);
	}
 
}