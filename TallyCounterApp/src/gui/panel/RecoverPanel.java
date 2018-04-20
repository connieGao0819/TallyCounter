package gui.panel;

import javax.swing.JButton;

import gui.listener.RecoverListener;
import util.ColorUtil;
import util.GUIUtil;

public class RecoverPanel extends WorkingPanel {
	static{
        GUIUtil.useLNF();
    }
    public static RecoverPanel recoverPanel = new RecoverPanel();
 
    JButton bRecover =new JButton("Recover");
 
    public RecoverPanel() {
 
        GUIUtil.setColor(ColorUtil.blueColor, bRecover);
        this.add(bRecover);
        addListener();
         
    }
 
    public static void main(String[] args) {
        GUIUtil.showPanel(RecoverPanel.recoverPanel);
    }

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		RecoverListener listener = new RecoverListener();
		bRecover.addActionListener(listener);
	}
}
