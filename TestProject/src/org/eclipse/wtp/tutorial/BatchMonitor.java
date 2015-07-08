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


public class BatchMonitor extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Came here 1");
		String userAgent =  req.getHeader("user-agent");
		String clientBrowser =  "Not known!";
		String jobType = req.getParameter("JobType");
		
		String batchStatus = req.getParameter("BatchStatus");
		String taskStatus = req.getParameter("TaskStatus");
		String jobDuration = req.getParameter("JobDuration");
		String hostname = req.getParameter("HostId");
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
			endpoint="http://slc5b01c-7fbb.stratus.slc.ebay.com:8080/vipsvcs/v1/";
			//http://vipsvcs.ebay.com/vipsvcs/v1/machinesHealth
		}
		
		System.out.println("endpoint "+endpoint);
		ClientResponse response = RestClientUtil.get(endpoint+"batchmonitor?inceptionCreationDate="+dt, "application/json");
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
		
		VipBatchMonitorPojo [] monitors = gson.fromJson(output, VipBatchMonitorPojo[].class);
		List<VipBatchMonitorPojo> monitorsFiltered = new ArrayList<VipBatchMonitorPojo>();
		for(VipBatchMonitorPojo monitor:monitors) {
			if(monitor !=null && (batchStatus == null || Integer.parseInt(batchStatus) == 9999 || Integer.parseInt(batchStatus) == monitor.getBatchStatus()) &&
			  (taskStatus == null || Integer.parseInt(taskStatus) == 9999 || Integer.parseInt(taskStatus) == monitor.getTaskStatus())	&&	
			   (jobType == null || jobType.equals("null") || jobType.equals("All") || monitor.getServiceName().contains(jobType)) &&
			   (ebayUserId == null || ebayUserId.equals("") || monitor.getBatchArgs() !=null && monitor.getBatchArgs().contains(ebayUserId)) &&
			   (jobDurationInt == 0 || getDateDiffInMinutes(monitor.getCreationDate(), now) < jobDurationInt) &&
			   (hostname == null || hostname.equals("") || hostname.equals("9999")|| monitor.getHostName().contains(hostname))
			   ){
				monitorsFiltered.add(monitor);
			}
		}
		VipBatchMonitorPojo [] monitors1= new VipBatchMonitorPojo[monitorsFiltered.size()];
		monitors = monitorsFiltered.toArray(monitors1);
		
		System.out.println(monitors);
		if( userAgent != null)
			clientBrowser = userAgent;
		req.setAttribute("client.browser",clientBrowser );
		req.setAttribute("monitors", monitors);
		req.setAttribute("selectedFeedType", jobType);
		req.setAttribute("selectedJobDuration", jobDuration);
		req.setAttribute("selectedUserId",ebayUserId);
		req.setAttribute("environment",environment);
		req.setAttribute("selectedTaskStatus", taskStatus);
		req.setAttribute("selectedBatchStatus", batchStatus);
		req.getRequestDispatcher("/dashboard.jsp").forward(req,resp);
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