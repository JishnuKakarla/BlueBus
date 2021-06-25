package com.jishnu.bluebus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jishnu.bluebus.bean.ScheduleBean;
import com.jishnu.bluebus.util.DBUtil;

public class ScheduleDAO {
	public String createSchedule(ScheduleBean scheduleBean) {
		try {
			Connection con = DBUtil.getDBConnection();

			PreparedStatement preparedStatement = con.prepareStatement("insert into schedule_tbl value(?,?,?,?,?)");
			
			preparedStatement.setString(1, scheduleBean.getScheduleId());
			preparedStatement.setString(2, scheduleBean.getSource());
			preparedStatement.setString(3, scheduleBean.getDestination());
			preparedStatement.setString(4, scheduleBean.getStartTime());
			preparedStatement.setString(5, scheduleBean.getArrivalTime());
			
			int i=preparedStatement.executeUpdate();
			
			return i==1?"SUCCESS":"FAIL";

		} catch (Exception e2) {
			e2.printStackTrace();
			return "FAIL";
		}
	}

	public String generateID(String Source, String Destination) {
		return Source.substring(0, 2)+Destination.substring(0,2)+"6402";
	}

	public ArrayList<ScheduleBean> viewSchedule(String Source, String Destination) {
		try {
			Connection con = DBUtil.getDBConnection();

			PreparedStatement preparedStatement = con.prepareStatement("select * from schedule_tbl where SOURCE=? and DESTINATION=?");
			preparedStatement.setString(1, Source);
			preparedStatement.setString(2, Destination);

			ResultSet rs = preparedStatement.executeQuery();

			ArrayList<ScheduleBean> arrayList = new ArrayList<ScheduleBean>();

			while (rs.next()) {
				ScheduleBean scheduleBean = new ScheduleBean();
				scheduleBean.setScheduleId(rs.getString(1));
				scheduleBean.setSource(rs.getString(2));
				scheduleBean.setDestination(rs.getString(3));
				scheduleBean.setStartTime(rs.getString(4));
				scheduleBean.setArrivalTime(rs.getString(5));

				arrayList.add(scheduleBean);
			}
			return arrayList;

		} catch (Exception e2) {
			e2.printStackTrace();
			return null;
		}
	}
}
