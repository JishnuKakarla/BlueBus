package com.jishnu.bluebus.service;

import java.util.ArrayList;

import com.jishnu.bluebus.bean.ScheduleBean;
import com.jishnu.bluebus.dao.ScheduleDAO;

public class Administrator {
	public String addSchedule(ScheduleBean scheduleBean)
	{	
		if(scheduleBean.getSource().equals(scheduleBean.getDestination()))
		{
			System.out.println("source and destination are same");
			return "FAIL";
		}
		else
		{
			ScheduleDAO scheduleDAO = new ScheduleDAO();
			String scheduleId =scheduleDAO.generateID(scheduleBean.getSource(), scheduleBean.getDestination());
			scheduleBean.setScheduleId(scheduleId);
			
			 return scheduleDAO.createSchedule(scheduleBean);
			
		}
	}
	public ArrayList<ScheduleBean> viewSchedule(String Source,String Destination)
	{
		ScheduleDAO scheduleDAO =  new ScheduleDAO();
		
		return scheduleDAO.viewSchedule(Source, Destination);
	}
}
