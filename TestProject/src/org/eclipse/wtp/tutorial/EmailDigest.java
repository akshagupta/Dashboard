package org.eclipse.wtp.tutorial;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;

public class EmailDigest extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/emailDigest.jsp").forward(req,resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Came here 4");
		String env = req.getParameter("env");
		String cp = req.getParameter("catalogprovider");
		String seller = req.getParameter("seller");
		String eventId = req.getParameter("eventId");
		String eventStatus = req.getParameter("eventStatus");
		String displayName = req.getParameter("displayName");
		String webDoorImage = req.getParameter("webDoorImage");
		String mobileImage = req.getParameter("mobileImage");
		
		if (StringUtilsVIP.isEmpty(env) && StringUtilsVIP.isEmpty(cp) && 
				StringUtilsVIP.isEmpty(seller) && StringUtilsVIP.isEmpty(eventId) && 
				StringUtilsVIP.isEmpty(eventStatus) && StringUtilsVIP.isEmpty(displayName) && 
				StringUtilsVIP.isEmpty(webDoorImage) && StringUtilsVIP.isEmpty(mobileImage)) {
			req.getRequestDispatcher("/emailDigest.jsp").forward(req,resp);
			return;
		}
		
		String encodedDisplayName = "";
		if (!StringUtilsVIP.isEmpty(displayName)) {
			encodedDisplayName = URLEncoder.encode(displayName, "UTF-8");
		}
		
		String endpoint = null;
		if ("PROD".equalsIgnoreCase(env)) {
			endpoint="http://slc5b01c-7fbb.stratus.slc.ebay.com:8080/vipsvcs/v1/";
		} else {
			//endpoint="http://kshitij.dev.ebay.com:7100/vipsvcs/v1/";
			endpoint="http://www.vipsvc.stratus.qa.ebay.com/vipsvcs/v1/";
		}
		
		System.out.println("endpoint "+endpoint);
		StringBuilder build = new StringBuilder();
		build.append("provider=").append(cp);
		build.append("&seller=").append(seller);
		build.append("&eventId=").append(eventId);
		build.append("&status=").append(eventStatus);
		build.append("&display_name=").append(encodedDisplayName);
		build.append("&web_door_image=").append(webDoorImage);
		build.append("&mobile_door_image=").append(mobileImage);
		
		ClientResponse response = RestClientUtil.get(endpoint+"updateEventDigest?"+build.toString(), "application/json");
		System.out.println("endPoint=" + endpoint+"updateEventDigest?"+build.toString());
		String output = response.getEntity(String.class);
		System.out.println(output);
		
		Gson g = new Gson();
		EventDigestResponse fromJson = g.fromJson(output, EventDigestResponse.class);
		for (String err: fromJson.getErrors()) {
			System.out.println(err);
		}
		System.out.println(fromJson.getStatus());
		req.setAttribute("status", fromJson.getStatus());
		req.setAttribute("errors", fromJson.getErrors());
		
		System.out.println(env);
		System.out.println(cp);
		System.out.println(seller);
		System.out.println(eventId);
		System.out.println(eventStatus);
		System.out.println(displayName);
		System.out.println(webDoorImage);
		System.out.println(mobileImage);
		System.out.println(encodedDisplayName);
		
		req.getRequestDispatcher("/emailDigest.jsp").forward(req,resp);
	}

}
