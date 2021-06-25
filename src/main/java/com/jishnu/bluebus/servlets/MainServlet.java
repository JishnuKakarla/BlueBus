package com.jishnu.bluebus.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jishnu.bluebus.bean.ScheduleBean;
import com.jishnu.bluebus.service.Administrator;

@WebServlet("/database")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operation = req.getParameter("operation");
		if (operation.equals("newSchedule")) {
			String status = addSchedule(req);
			if (status.equals("SUCCESS")) {
				resp.sendRedirect("success.jsp");
			} else if (status.equals("FAIL")) {
				resp.sendRedirect("errorInserting.html");
			}
		} else if (operation.equals("viewSchedule")) {
			ArrayList<ScheduleBean> arrayList = viewSchedule(req);
			System.out.println(arrayList);
			req.setAttribute("data", arrayList);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("displayschedule.jsp");
			requestDispatcher.forward(req, resp);
		}

	}

	public String addSchedule(HttpServletRequest request) {

		ScheduleBean scheduleBean = new ScheduleBean();
		scheduleBean.setSource(request.getParameter("source"));
		scheduleBean.setDestination(request.getParameter("destination"));
		scheduleBean.setStartTime(request.getParameter("startTime"));
		scheduleBean.setArrivalTime(request.getParameter("arrivalTime"));

		Administrator administrator = new Administrator();
		/*
		 * String status = administrator.addSchedule(scheduleBean); return status;
		 */
		return administrator.addSchedule(scheduleBean);
	}

	public ArrayList<ScheduleBean> viewSchedule(HttpServletRequest request) {
		Administrator administrator = new Administrator();
		return administrator.viewSchedule(request.getParameter("source"), request.getParameter("destination"));
	}
}
