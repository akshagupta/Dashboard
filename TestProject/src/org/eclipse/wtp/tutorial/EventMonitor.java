package org.eclipse.wtp.tutorial;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;


public class EventMonitor extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Came here 1");
		String userAgent =  req.getHeader("user-agent");
		String clientBrowser =  "Not known!";
		String jobType = req.getParameter("JobType");
		String eventAction=req.getParameter("eventAction");
		String eventStatus = req.getParameter("EventStatus");
		String jobDuration = req.getParameter("JobDuration");
		int jobDurationInt = 0;
		try {
			jobDurationInt = Integer.parseInt(jobDuration);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		String ebayUserId = req.getParameter("UserId");
		
		String environment = (String)req.getParameter("environment");
		
		Date date = getDateDiff(jobDurationInt);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		String dt = format.format(date);
		
		String endpoint = null;
		if("QA".equals(environment)) {
			endpoint="http://vipsvcs.qa.ebay.com/vipsvcs/v1/";
		} else {
			endpoint="http://vipsvcs.ebay.com/vipsvcs/v1/";
			//http://vipsvcs.ebay.com/vipsvcs/v1/machinesHealth
		}
		
		System.out.println("endpoint "+endpoint);
		ClientResponse response = RestClientUtil.get(endpoint+"events/"+eventStatus+"?inceptionCreationDate="+dt, "application/json");
		String output = response.getEntity(String.class);
		String rlogid = response.getHeaders().get("RLogId").get(0);
		System.out.println("Rlogid "+rlogid);
		
		
//http://vipsvcs.ebay.com/vipsvcs/v1/machinesHealth
		Gson gson = new Gson();
		/*
		ClientResponse machineResponse = RestClientUtil.get(endpoint+"machinesHealth", "application/json");
		String outputMachines = machineResponse.getEntity(String.class);
		AllMachines machines = gson.fromJson(outputMachines, AllMachines.class);
		
		System.out.println(machines);
		
		List<MachineHealth> machineList = machines.getMachineList();
		
		for(MachineHealth machine :machineList) {
			machine.getHostname();
		}
		*/
		
		System.out.println(output);
		
		
		Date nowDate = new Date();
		
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String now = format1.format(nowDate);
		
		System.out.println("jobDurationInt "+jobDurationInt);
		
		VipEventPojo [] events = gson.fromJson(output, VipEventPojo[].class);
		List<VipEventPojo> eventsFiltered = new ArrayList<VipEventPojo>();
		for(VipEventPojo event:events) {
			if(jobDurationInt == 0 || getDateDiffInMinutes(event.getCreationDate(), now) < jobDurationInt) {
				eventsFiltered.add(event);
			}
		}
		VipEventPojo [] monitors1= new VipEventPojo[eventsFiltered.size()];
		events = eventsFiltered.toArray(monitors1);
		System.out.println(events);
		if( userAgent != null)
			clientBrowser = userAgent;
		req.setAttribute("client.browser",clientBrowser );
		req.setAttribute("events", events);
		req.setAttribute("selectedFeedType", jobType);
		req.setAttribute("selectedJobDuration", jobDuration);
		req.setAttribute("selectedUserId",ebayUserId);
		req.setAttribute("environment",environment);
		req.getRequestDispatcher("/eventsDashboard.jsp").forward(req,resp);
	}
	
	
	public static Date getDateDiff(int change)  {
			Date nowDate = new Date();
			long ch = change * 60 * 1000;
			long time = nowDate.getTime() - ch;
			return new Date(time);
			
	}
	
	public static long getDateDiff(String startDate, String endDate) throws ParseException {
		if (startDate != null && endDate != null) {
			Calendar fromCal = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			fromCal.setTime(format.parse(startDate));
			Calendar toCal = Calendar.getInstance();
			toCal.setTime(format.parse(endDate));
			return (toCal.getTimeInMillis() - fromCal.getTimeInMillis());
		} else {
			return -1;
		}
	}

	public static long getDateDiffInSeconds(String fromDate, String toDate) throws ParseException {
		long timeDiff = getDateDiff(fromDate, toDate);
		return timeDiff == -1 ? timeDiff : (timeDiff / 1000);
	}

	public static long getDateDiffInMinutes(String fromDate, String toDate)  {
		long timeDiff = -1;
		try {
			timeDiff = getDateDiff(fromDate, toDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(timeDiff/(60*1000));
		return timeDiff == -1 ? timeDiff : (timeDiff /(60 * 1000));
	}
	
}