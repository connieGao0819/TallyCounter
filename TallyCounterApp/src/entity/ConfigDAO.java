package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBUtil;

public class ConfigDAO {
	
	public int getTotal() {
		int total = 0;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			String sql = "select count(*) from config";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) total = rs.getInt(1);
			System.out.println("Total:" + total);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	
	public void add(Config config) {
		String sql = "insert into config values(null, ?, ?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, config.key);
			ps.setString(2, config.value);
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				config.id = id;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
