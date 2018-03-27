package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import gui.panel.BackupPanel;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import service.ConfigService;
import util.MySQLUtil;

public class BackupListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		BackupPanel p = BackupPanel.backupPanel;
		String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
		if (mysqlPath.length() == 0) {
			JOptionPane.showMessageDialog(p, "Please set MySQL path first!");
			MainPanel.mainPanel.workingPanel.show(ConfigPanel.configPanel);
			return;
		}
		JFileChooser fc = new JFileChooser();
		fc.setSelectedFile(new File("bill.sql"));
		fc.setFileFilter(new FileFilter() {
            
            @Override
            public String getDescription() {
                return ".sql";
            }
             
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".sql");
            }
        });
		
		int returnVal = fc.showSaveDialog(p);
		File file = fc.getSelectedFile();
		System.out.println(file);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println(file);
            if(!file.getName().toLowerCase().endsWith(".sql"))
                file = new File(file.getParent(),file.getName()+".sql");
            System.out.println(file);
             
           try {
               MySQLUtil.backup(mysqlPath, file.getAbsolutePath());
               JOptionPane.showMessageDialog(p, "Backup Successfully,backup location:\r\n"+file.getAbsolutePath());
           } catch (Exception e1) {
               e1.printStackTrace();
               JOptionPane.showMessageDialog(p, "Failed!\r\n,Error:\r\n"+e1.getMessage());  
           }
		}
	}

}
