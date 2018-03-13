package gui.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

public class SpendPanel extends JPanel{
	static {
		GUIUtil.useLNF();
	}
	
	public static SpendPanel spendPanel = new SpendPanel();
	
	public JLabel lMonthSpend = new JLabel("本月消费");
    public JLabel lTodaySpend = new JLabel("今日消费");
    public JLabel lAvgSpendPerDay = new JLabel("日均消费");
    public JLabel lMonthLeft = new JLabel("本月剩余");
    public JLabel lDayAvgAvailable = new JLabel("日均可用");
    public JLabel lMonthLeftDay = new JLabel("距离月末");
 
    public JLabel vMonthSpend = new JLabel("0");
    public JLabel vTodaySpend = new JLabel("0");
    public JLabel vAvgSpendPerDay = new JLabel("0");
    public JLabel vMonthAvailable = new JLabel("0");
    public JLabel vDayAvgAvailable = new JLabel("0");
    public JLabel vMonthLeftDay = new JLabel("0");
    
    CircleProgressBar bar;
    
	private SpendPanel() {
		this.setLayout(new BorderLayout());
		bar = new CircleProgressBar();
		bar.setBackgroundColor(ColorUtil.blueColor);
		
		GUIUtil.setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
                lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
		GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);
		
		vMonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        vTodaySpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
 
        this.add(center(), BorderLayout.CENTER);
        this.add(south(), BorderLayout.SOUTH);
	}
	
	private JPanel center() {
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(west(), BorderLayout.WEST);
		centerPanel.add(center2(), BorderLayout.CENTER);
		return centerPanel;
	}
	
	private JPanel west() {
		JPanel west = new JPanel();
		west.setLayout(new GridLayout(4, 1));
		west.add(lMonthSpend);
		west.add(vMonthSpend);
        west.add(lTodaySpend);
        west.add(vTodaySpend);
		return west;
	}
	
	private Component center2() {
		return bar;
	}
	
	private JPanel south() {
		JPanel southPanel = new JPanel();
		
		southPanel.setLayout(new GridLayout(2, 4));
		southPanel.add(lAvgSpendPerDay);
		southPanel.add(lMonthLeft);
        southPanel.add(lDayAvgAvailable);
        southPanel.add(lMonthLeftDay);
        southPanel.add(vAvgSpendPerDay);
        southPanel.add(vMonthAvailable);
        southPanel.add(vDayAvgAvailable);
        southPanel.add(vMonthLeftDay);
        
        return southPanel;
	}
	
	 public static void main(String[] args) {
         
	        GUIUtil.showPanel(SpendPanel.spendPanel);
	    }
}
