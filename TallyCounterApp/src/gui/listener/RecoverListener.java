package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import gui.panel.RecoverPanel;
import service.ConfigService;
import util.MySQLUtil;

public class RecoverListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		RecoverPanel p = RecoverPanel.recoverPanel;
		String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
		if (mysqlPath.length() == 0) {
			JOptionPane.showMessageDialog(p, "Please set the MySQL installation path first!");
			MainPanel.mainPanel.workingPanel.show(ConfigPanel.configPanel);
			return;
		}
		JFileChooser fc = new JFileChooser();
		fc.setSelectedFile(new File("bill.sql"));
		fc.setFileFilter(new FileFilter() {

			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				return f.getName().toLowerCase().endsWith(".sql");
			}

			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return ".sql";
			}
			
		});
		
		int returnVal = fc.showOpenDialog(p);
		File file = fc.getSelectedFile();
		System.out.println(file);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				MySQLUtil.recover(mysqlPath, file.getAbsolutePath());
				JOptionPane.showMessageDialog(p, "The data has been recovered successfully!");
			} catch (Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(p, "Failed!\r\n Error: \r\n" + e.getMessage());
			}
		}
	}

}
