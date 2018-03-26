package gui.page;

public class SpendPage {
	
	public String monthSpend;
	public String todaySpend;
	public String avgSpendPerDay;
	public String monthAvailable;
	public String avgAvailablePerDay;
	public String leftDay;
	public int usagePercentage;
	public boolean isOverSpend;
	
	public SpendPage(int monthSpend, int todaySpend, int avgSpendPerDay, int monthAvailable, 
			int avgAvailablePerDay, int leftDay, int usagePercentage) {
		this.monthSpend = "$" + monthSpend;
		this.todaySpend = "$" + todaySpend;
		this.avgSpendPerDay = "$" + avgSpendPerDay;
		if (monthAvailable < 0) 
			this.isOverSpend = true;
		if (!isOverSpend) {
			this.monthAvailable = "$" + monthAvailable;
			this.avgAvailablePerDay = "$" + avgAvailablePerDay;
		} else {
			this.monthAvailable = "Overspend " + (0 - monthAvailable);
			this.avgAvailablePerDay = "$0";
		}
		this.leftDay = leftDay + " days";
		this.usagePercentage = usagePercentage;
	}
}
