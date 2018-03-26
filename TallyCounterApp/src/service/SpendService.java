package service;

import java.util.List;

import entity.Record;
import entity.RecordDAO;
import gui.page.SpendPage;
import util.DateUtil;

public class SpendService {
	
	public SpendPage getSpendPage() {
		RecordDAO dao = new RecordDAO();
		List<Record> thisMonthRecords = dao.listThisMonth();
		List<Record> todayRecord = dao.listToday();
		int NumOfDaysOfThisMonth = DateUtil.NumOfDaysOfThisMonth();
		
		int monthSpend = 0;
		int todaySpend = 0;
		int avgSpendPerDay = 0;
		int monthAvailable = 0;
		int avgAvailablePerDay = 0;
		int leftDay = 0;
		int usagePercentage = 0;
		
		int monthBudget = new ConfigService().getIntBudget();
		
		for (Record record : thisMonthRecords) {
			monthSpend += record.getSpend();
		}
		
		for (Record record : todayRecord) 
			todaySpend += record.getSpend();
		
		avgSpendPerDay = monthSpend / NumOfDaysOfThisMonth;
		
		monthAvailable = monthBudget - monthSpend;
		
		leftDay = DateUtil.LeftDaysOfThisMonth();
		
		avgAvailablePerDay = monthAvailable / leftDay;
		
		usagePercentage = monthSpend * 100 / monthBudget;
		
		return new SpendPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable, 
				avgAvailablePerDay, leftDay, usagePercentage);
	}
}
