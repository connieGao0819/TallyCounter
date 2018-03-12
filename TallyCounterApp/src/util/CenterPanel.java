package util;
/**
 * @author Connie
 */
/*
 show(JComponent c)
使用show方法显示组件,show方法中的思路是： 先把这个容器中的组件都移出，然后把新的组件加进来，并且调用updateUI进行界面渲染。
updateUI会导致swing去调用repaint()方法。
repaint()
在repaint方法中，就会使用绝对定位的方式把组件放在中间位置。
如果stretch是true，就会根据整个容器的大小，设置组件的大小，达到拉伸的效果
如果stretch是false, 就使用组件的preferredSize，即非拉伸效果。
 */
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class CenterPanel extends JPanel{
	private double rate;
	private JComponent c;
	private boolean stretch;
	
	public CenterPanel(double rate, boolean stretch) {
		this.setLayout(null);
		this.rate = rate;
		this.stretch = stretch;
	}
	
	public CenterPanel(double rate) {
		this(rate, true);
	}
	
	public void repaint() {
		if (c != null) {
			Dimension containerSize = this.getSize();
			Dimension componentSize = c.getPreferredSize();
			
			if (stretch) 
				c.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
			else
				c.setSize(componentSize);
			c.setLocation(containerSize.width / 2 - c.getSize().width / 2, containerSize.height / 2 - c.getSize().height / 2);
		}
		super.repaint();
	}
	
	public void show(JComponent c) {
		this.c = c;
		Component[] cs = this.getComponents();
		for (Component com : cs) remove(com);
		this.add(c);
		this.updateUI();//updateUI会导致swing去调用repaint()方法
	}
}
