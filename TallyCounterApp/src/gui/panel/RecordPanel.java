package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import entity.Category;
import gui.listener.RecordListener;
import gui.model.CategoryComboBoxModel;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

public class RecordPanel extends WorkingPanel{
	
	static{
        GUIUtil.useLNF();
    }
	
	public static RecordPanel recordPanel = new RecordPanel();
	JLabel lSpend = new JLabel("cost");
    JLabel lCategory = new JLabel("category");
    JLabel lComment = new JLabel("remark");
    JLabel lDate = new JLabel("date"); 
    JButton bSubmit = new JButton("submit");
    
    public JXDatePicker datePicker = new JXDatePicker(new Date());
    public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
    public JComboBox<String> cbCategory = new JComboBox<>(cbModel);
    public JTextField remarkField = new JTextField();
    public JTextField spendField = new JTextField();
    
	private RecordPanel() {
		GUIUtil.setColor(ColorUtil.grayColor, lSpend,lCategory,lComment,lDate);
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
        JPanel upPanel = new JPanel();
        JPanel downPanel = new JPanel();
        int gap = 40;
        upPanel.setLayout(new GridLayout(4, 2, gap, gap));
        upPanel.add(lSpend);
        upPanel.add(spendField);
        upPanel.add(lCategory);
        upPanel.add(cbCategory);
        upPanel.add(lComment);
        upPanel.add(remarkField);
        upPanel.add(lDate);
        upPanel.add(datePicker);
        downPanel.add(bSubmit);
        
		this.setLayout(new BorderLayout());
		this.add(upPanel, BorderLayout.NORTH);
		this.add(downPanel, BorderLayout.CENTER);
		
		addListener();
	}
	
	public static void main(String[] args) {
        GUIUtil.showPanel(RecordPanel.recordPanel);
    }
	
	public Category getSelectedCategory(){
        return (Category) cbCategory.getSelectedItem();
    }

	public void resetInput() {
		// TODO Auto-generated method stub
		spendField.setText("0");
		remarkField.setText("");
		if (cbModel.cs.size() != 0) {
			cbCategory.setSelectedIndex(0);
		}
		datePicker.setDate(new Date());
	}
	
	@Override
    public void updateData() {
        cbModel.cs = new CategoryService().list();
        cbCategory.updateUI();
        resetInput();
        spendField.grabFocus();
    }

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		RecordListener listener = new RecordListener();
		bSubmit.addActionListener(listener);
	}
	
}
