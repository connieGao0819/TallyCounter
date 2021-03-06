package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entity.Category;
import gui.listener.CategoryListener;
import gui.model.CategoryTableModel;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

public class CategoryPanel extends WorkingPanel{
	static{
        GUIUtil.useLNF();
    }
	
	public static CategoryPanel categoryPanel = new CategoryPanel();
	
	public JButton bAdd = new JButton("Add");
	public JButton bEdit = new JButton("Edit");
	public JButton bDelete = new JButton("Delete");
	String[] columnNames = new String[] {"category name", "consumption times"};
	
	public CategoryTableModel ctm = new CategoryTableModel();
	public JTable t = new JTable(ctm);
	
	private CategoryPanel() {
		GUIUtil.setColor(ColorUtil.blueColor, bAdd,bEdit,bDelete);
		JScrollPane sp = new JScrollPane(t);
		JPanel editPanel = new JPanel();
		editPanel.add(bAdd);
		editPanel.add(bEdit);
		editPanel.add(bDelete);
		
		this.setLayout(new BorderLayout());
		this.add(editPanel, BorderLayout.SOUTH);
		this.add(sp, BorderLayout.CENTER);
		
		addListener();
	}
	
	public Category getSelectedCategory() {
		int index = t.getSelectedRow();
		return ctm.cs.get(index);
	}
	
	@Override
	public void updateData() {
		ctm.cs = new CategoryService().list();
		t.updateUI();
		t.getSelectionModel().setSelectionInterval(0, 0);
		
		if (ctm.cs.size() == 0) {
			bEdit.setEnabled(false);
			bDelete.setEnabled(false);
		} else {
			bEdit.setEnabled(true);
			bDelete.setEnabled(true);
		}
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		CategoryListener listener = new CategoryListener();
		bAdd.addActionListener(listener);
		bEdit.addActionListener(listener);
		bDelete.addActionListener(listener);
	}


    public static void main(String[] args) {
        GUIUtil.showPanel(CategoryPanel.categoryPanel);
    }
}
