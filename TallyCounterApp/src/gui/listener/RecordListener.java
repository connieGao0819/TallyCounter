package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.SpendPanel;
import service.RecordService;
import util.GUIUtil;

public class RecordListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*RecordPanel rp = RecordPanel.recordPanel;
		if (rp.cbModel.cs.size() == 0) {
			JOptionPane.showMessageDialog(rp, "You haven't set categories yet!");
			MainPanel.mainPanel.workingPanel.show(CategoryPanel.categoryPanel);
			return;
		}
		if (GUIUtil.checkZero(rp.spendField, "spend value "))
			return;
		int spend = Integer.parseInt(rp.spendField.getText().trim());
		Category c = (Category)rp.cbCategory.getSelectedItem();
		String comment = rp.remarkField.getText();
		Date d = rp.datePicker.getDate();
		new RecordService().add(spend, c, comment, d);
		JOptionPane.showMessageDialog(rp, "You have added this record successfully!");
		
		MainPanel.mainPanel.workingPanel.show(SpendPanel.spendPanel);*/
		RecordPanel p  =RecordPanel.recordPanel;
        if(0==p.cbModel.cs.size()){
            JOptionPane.showMessageDialog(p, "You haven't set categories yet!");
            MainPanel.mainPanel.workingPanel.show(CategoryPanel.categoryPanel);
            return;
        }
         
        if(!GUIUtil.checkZero(p.spendField,"cost "))
            return;
        int spend = Integer.parseInt(p.spendField.getText());
        Category c = p.getSelectedCategory();
        String comment = p.remarkField.getText();
        Date d = p.datePicker.getDate();
        new RecordService().add(spend, c, comment, d);
        JOptionPane.showMessageDialog(p, "You have add a record successfully!");
         
        MainPanel.mainPanel.workingPanel.show(SpendPanel.spendPanel);
		
	}

}
