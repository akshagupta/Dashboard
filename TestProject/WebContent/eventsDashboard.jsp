<%@page import="org.eclipse.wtp.tutorial.VipEventPojo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="org.eclipse.wtp.tutorial.VipBatchMonitorPojo"%>
<html>
<head><title>Events Dashboard</title></head>
<style text="css">
table.center {
    width:90%; 
    margin-left:5%; 
    margin-right:10%;
  }
</style>
<script language="javascript">

 function submitEvent(eventStatus) {
	document.getElementsByName('eventAction')[0].value=eventStatus;
	
 }
 

</script>
<body>

<div>
<form method="get" name="bdxMonitorForm" action="/TestProject/batchmonitor/EventMonitor" >
 <input type="hidden" id="eventAction" name="eventAction" value=""/>
<input type=hidden name="BlockThreshold" value="1800">
<input type=hidden name="q" value="true">
<fieldset><legend ALIGN=TOP><b>Please Select</b></legend>
<table WIDTH=70%>
<tr>
	<td align=left></td>
</tr>
<tr>
<td align=left><B>Event Status:</B></td>
<td align=left>

<INPUT TYPE=RADIO NAME="dateType" value="0" onClick="toggle(this)" checked ><b>In Last</b></td><td>
<!-- 
<INPUT TYPE=RADIO NAME="dateType" value="1" onClick=toggle(this) ><b>In Range</b>
 -->
</td>
</tr>
<TR></TD>
   <td align="left" >
   <select name="EventStatus"> 
   
     <OPTION value="inactive" >IN_ACTIVE</OPTION>
     
     <OPTION value="active" >ACTIVE</OPTION>
     
     <OPTION value="completed" >COMPLETE</OPTION>
     
     <OPTION value="deleted" >DELETED</OPTION>
    
          
</SELECT></TD> 
<TD align=left  >
<div id="SinceLast">
<SELECT name=JobDuration> 

<%
 	String selectedJobDuration = (String)request.getAttribute("selectedJobDuration");
	int[] jobDurations = {1,5,10,15,30,60,300,600,1440,2880,4320,5760,7200,8640,10080};
 	String selected = "";
				for (int key : jobDurations) {
					selected = "";
					System.out.println(key + " " +selectedJobDuration);
					if((selectedJobDuration == null || selectedJobDuration.equals(""))  && key == 1440) {
						selected = "selected";
					}
					if (selectedJobDuration !=null && !selectedJobDuration.equals("") && String.valueOf(key).equals(selectedJobDuration)) {
						selected = "selected";
					}
					String display= String.valueOf(key) + " Min";
					if(key >30 && key < 1440) {
						 display = key/60 + " Hours";
					} else if(key >=1440) {
						display = key/1440 + " Days";
					}
					out.println("<option value=\""+key+"\""+selected+">"+display+"</option>");
			}
	%>
    
  </SELECT>        
</div></td>
<!-- 
<td align=left>
<div id="StartDate">
<input type="text" length="19" name="JobDate" id="JobDate" value="2014-09-13 00:00:00">
</div>
<div id="EndDate">
<input type="text" length="19" name="JobEndDate" id="JobEndDate" value="2014-09-13 16:11:15">
</div>
</TD>
 -->
      </tr>
      <tr>
  <td align=left><B>User or Catalog Event Id</B></td>
   <td align=left><B>Environment</B></td>
   
   <tr>
    <TD align=left >
     <%
       String userId =  (String)request.getAttribute("selectedUserId");
      if(userId !=null && !userId.equals("null") && !userId.equals("") ) {
     %>
    <INPUT 
      maxLength=38 size=16 name=UserId value="<%=userId%>">
     <%
      } else {
     %>
      <INPUT 
      maxLength=38 size=16 name=UserId value="">
      <%
      }
       %>
     </TD>
       <td align="left" >
   <select name="environment"> 
   <%
     String environment = (String)request.getAttribute("environment");
  	 String [] environments = {"QA", "Production"};
	selected = "";
				for (String key : environments) {
					selected = "";
					
					if (environment !=null && !environment.equals("") && key.equals(environment)) {
						selected = "selected";
					}
					
					out.println("<option value=\""+key+"\""+selected+">"+key+"</option>");
			}
   %>
   
          
</SELECT></TD> 
      </tr>
<tr>
	<td><input type=submit value="Submit" style="margin-top:30px"></td>  
</tr>
</table>
</fieldset>
</form>
</div>
<div>
<table border="1" class="center">
	<tr align="center">
		<th>Event Name</th>
		<th>Catalog Provider EventId</th>
		<th>Event Status</th>
		<th>Event Start Time</th>
		<th>Event End Time</th>
		<th>EbayUserId</th>
		<th>RPP Event Id</th>
		<th>Created Date</th>
		<th>Last Modified Date</th>
		<th>Action</th>
	</tr>
	<%
	VipEventPojo[] events = (VipEventPojo [])request.getAttribute("events");
	if(events != null) {
	for(int i =0;i<events.length;i++) {
		if(events[i] == null) continue;
		System.out.println(events[i]);
	%>
	<tr align="center">
		<td><%= events[i].getEventTitle()  %></td>
		<td><%= events[i].getCatalogProviderEventGroupId()  %></td>
		<td width="30"><% if("active".equalsIgnoreCase(events[i].getStatus())) { %>
		<div style="text-align: center;">
		 <img alt="" src="http://d-sjc-00531331:9090/TestProject/green.png"  height="5%" width="25%"/>
		</div>
		<%
		 } else { %>
		 <div style="text-align: center;">
		 	<img alt="" src="http://d-sjc-00531331:9090/TestProject/red.png" height="8%" width="25%"/>
		 </div>
		<%
		 }
		%>
		</td>
		<td width="30"><% 
			long time = events[i].getEventStartTime();
			DateFormat format = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
			String startTime = format.format(new Date(time));
		%>
		   <%=startTime %>
		</td>
			<td width="30"><% 
			 time = events[i].getEventEndTime();
			 format = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
			String endTime = format.format(new Date(time));
		%>
		   <%=endTime %>
		</td>
		<td>
			<%=events[i].getEbayUserId()%>
		</td>
		<td>
			<%=events[i].getRppEventId() %>
		</td>
		
		<td>
			<%=events[i].getCreationDate() %>
		</td>
		<td>
			<%=events[i].getLastModifiedDate()%>
		</td>
		<td>
		 <%
		   if("inactive".equalsIgnoreCase(events[i].getStatus())) {
		  %>
		   <input type="button" value="active" onclick="submitEvent('active')" />
		  <%
		   } 
		  %>
		</td>
	</tr>
	<%
	 }
	}
	 %>
</table>

</div>
</body>
</html>