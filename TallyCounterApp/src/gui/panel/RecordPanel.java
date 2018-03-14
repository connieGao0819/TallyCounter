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

import gui.model.CategoryComboBoxModel;
import util.ColorUtil;
import util.GUIUtil;

public class RecordPanel extends JPanel{
	
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
	}
	
	public static void main(String[] args) {
        GUIUtil.showPanel(RecordPanel.recordPanel);
    }
	
}
