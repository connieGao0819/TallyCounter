package service;

import entity.Config;
import entity.ConfigDAO;

public class ConfigService {
	public static final String budget = "budget";
	public static final String mysqlPath = "mysqlPath";
	public static final String defaultBudget = "500";
	
	static ConfigDAO dao = new ConfigDAO();
	static {
		init();
	}
	
	public static void init() {
		init(budget, defaultBudget);
		init(mysqlPath, "");
	}
	public static void init(String key, String value) {
		Config config = dao.getByKey(key);
		if (config == null) {
			Config c = new Config();
			c.setKey(key);
			c.setValue(value);
			dao.add(c);
		}
	}
	
	public String get(String key) {
		Config config = dao.getByKey(key);
		return config.getValue();
	}
	
	public void update(String key, String value) {
		Config config = dao.getByKey(key);
		config.setValue(value);
		dao.update(config);
	}
	
	public int getIntBudget() {
		return Integer.parseInt(get(budget));
	}
}
