package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.model.CategoryTableModel;
import util.ColorUtil;
import util.GUIUtil;

public class CategoryPanel extends JPanel{
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
	}
	
	public static void main(String[] args) {
        GUIUtil.showPanel(CategoryPanel.categoryPanel);
    }
}