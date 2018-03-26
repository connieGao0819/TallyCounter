package gui.panel;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entity.Record;
import service.ReportService;
import util.ChartUtil;
import util.GUIUtil;

public class ChartPanel extends WorkingPanel{
	static {
        GUIUtil.useLNF();
    }
	
	public static ChartPanel chartPanel = new ChartPanel();
	
	public JLabel l = new JLabel();
	
	private ChartPanel() {
		this.setLayout(new BorderLayout());
		Image i = ChartUtil.getImage(400, 300);
		ImageIcon icon = new ImageIcon(i);
		l.setIcon(icon);
		this.add(l);
	}
	
	public static void main(String[] args) {
        GUIUtil.showPanel(ChartPanel.chartPanel);
    }

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		List<Record> rs = new ReportService().listThisMonthRecords();
		Image i = ChartUtil.getImage(rs, 350, 250);
		ImageIcon icon = new ImageIcon(i);
		l.setIcon(icon);
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
	}
}
