package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import entity.Record;
import entity.RecordDAO;
import util.DateUtil;

public class ReportService {
	RecordDAO recordDAO = new RecordDAO();
	
	public int getDaySpend(Date date) {
		int daySpend = 0;
		for (Record r : recordDAO.list(date)) 
			daySpend += r.getSpend();
		return daySpend;
	}
	
	public List<Record> listThisMonthRecords() {
		List<Record> list = new ArrayList<>();
		Date monthBegin = DateUtil.monthBegin();
		int NumOfDaysOfThisMonth = DateUtil.NumOfDaysOfThisMonth();
		System.out.println(NumOfDaysOfThisMonth);
		Calendar c = Calendar.getInstance();
		for (int i = 0; i < NumOfDaysOfThisMonth; i++) {
			Record r = new Record();
			c.setTime(monthBegin);
			c.add(Calendar.DATE, i);
			Date currentDate = c.getTime();
			int daySpend = getDaySpend(currentDate);
			r.spend = daySpend;
			list.add(r);			
		}
		return list;
	}
}
