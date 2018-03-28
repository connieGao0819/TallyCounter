package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import service.CategoryService;

public class CategoryListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CategoryPanel p = CategoryPanel.categoryPanel;
		JButton b = (JButton) e.getSource();
		if (b == p.bAdd) {
			String name = JOptionPane.showInputDialog(null);
			if (name.length() == 0) {
				JOptionPane.showMessageDialog(p, "Category name cannot be null!");
				return;
			}
			new CategoryService().add(name);
		}
		if(b == p.bEdit) {
			Category c = p.getSelectedCategory();
			int id = c.id;
			String name = JOptionPane.showInputDialog("Category name", c.name);
			if (name.length() == 0) {
				JOptionPane.showMessageDialog(p, "Category name cannot be null!");
				return;
			}
			
			new CategoryService().update(c.id, name);
		}
		if (b == p.bDelete) {
			Category c = p.getSelectedCategory();
			if (c.recordNumber != 0) {
				JOptionPane.showMessageDialog(p, "You cannot delete categoties with records!");;
				return;
			}
			if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "Are you sure to delete this category?")) {
				return;
			}
			
		    new CategoryService().delete(c.id);
		}
		p.updateData();
	}

}
