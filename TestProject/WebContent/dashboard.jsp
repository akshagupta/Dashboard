<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="org.eclipse.wtp.tutorial.VipBatchMonitorPojo"%>
<html>
<head><title>Dashboard</title></head>
<style text="css">
table.center {
    width:90%; 
    margin-left:5%; 
    margin-right:10%;
  }
</style>
<script language="javascript">

 

</script>
<body>

<div>
<form method="get" name="bdxMonitorForm" action="/TestProject/batchmonitor/BatchMonitor"  onsubmit="return submitVerify();">
<input type=hidden name="BlockThreshold" value="1800">
<input type=hidden name="q" value="true">
<fieldset><legend ALIGN=TOP><b>Please Select</b></legend>
<table WIDTH=70%>
<tr>
	<td align=left></td>
</tr>
<tr>
<td align=left><B>Job Type:</B></td>
<td align=left><B>Batch Status:</B></td>
<td align=left><B>Task Status:</B></td>
<td align=left>

<INPUT TYPE=RADIO NAME="dateType" value="0" onClick="toggle(this)" checked ><b>In Last</b></td><td>
<!-- 
<INPUT TYPE=RADIO NAME="dateType" value="1" onClick=toggle(this) ><b>In Range</b>
 -->
</td>
</tr>
<TR><TD align=left >
<SELECT name=JobType> 
 
 	<%
 	String selectedfeedType = (String)request.getAttribute("selectedFeedType");
	String[] feedTypes = {"All","InventoryDataFeedTask", "EventDataFeedTask","ProductInventoryDataFeedTask","LMSCreate","AddItemLMSUpload","ReviseItemLMSUpload","EndItemLMSUpload","AddItemLMSDownload", "ReviseItemLMSDownload", "EndItemLMSDownload", "EndOfFeed", "FeedPopulator", "WorkflowManager", "JobManager", "BatchExecutor"};
 	String selected = "";
				for (String key : feedTypes) {
					selected = "";
					if (selectedfeedType !=null && !selectedfeedType.equals("") && key.equals(selectedfeedType)) {
						selected = "selected";
					}
					out.println("<option value=\""+key+"\""+selected+">"+key+"</option>");
			}
	%>
 
          
</SELECT></TD>
   <td align="left" >
   <select name="BatchStatus"> 
   
   
 	<%
 	String selectedBatchStatus = (String)request.getAttribute("selectedBatchStatus");
		if("1".equals(selectedBatchStatus)) {
	%>
			 <OPTION value="1" selected>NOT_STARTED</OPTION>
		     
		     <OPTION value="5" >IN_PROCESS</OPTION>
		     
		     <OPTION value="7" >COMPLETE</OPTION>
		     
		     <OPTION value="3" >FAILED</OPTION>
		    
		     <OPTION value="9999">--All--</OPTION>
	<% 	} else if("5".equals(selectedBatchStatus)){ %>
			 <OPTION value="1" >NOT_STARTED</OPTION>
		     
		     <OPTION value="5" selected >IN_PROCESS</OPTION>
		     
		     <OPTION value="7" >COMPLETE</OPTION>
		     
		     <OPTION value="3" >FAILED</OPTION>
		    
		     <OPTION value="9999">--All--</OPTION>
			
		<% } else if("3".equals(selectedBatchStatus)) { %>
			 <OPTION value="1" >NOT_STARTED</OPTION>
		     
		     <OPTION value="5" >IN_PROCESS</OPTION>
		     
		     <OPTION value="7" >COMPLETE</OPTION>
		     
		     <OPTION value="3" selected>FAILED</OPTION>
		    
		     <OPTION value="9999">--All--</OPTION>
			
		<% } else if("7".equals(selectedBatchStatus)) { %>
			 <OPTION value="1" >NOT_STARTED</OPTION>
		     
		     <OPTION value="5" >IN_PROCESS</OPTION>
		     
		     <OPTION value="7" selected >COMPLETE</OPTION>
		     
		     <OPTION value="3" >FAILED</OPTION>
		    
		     <OPTION value="9999">--All--</OPTION>
			
		<% } else { %>
			 <OPTION value="1" >NOT_STARTED</OPTION>
		     
		     <OPTION value="5" >IN_PROCESS</OPTION>
		     
		     <OPTION value="7" >COMPLETE</OPTION>
		     
		     <OPTION value="3" >FAILED</OPTION>
		    
		     <OPTION value="9999" selected>--All--</OPTION>
			
		<% }
		
	%>
    
          
</SELECT></TD> 
</TD>
   <td align="left" >
   <select name="TaskStatus"> 
   
   <%
 	String selectedTaskStatus = (String)request.getAttribute("selectedTaskStatus");
    System.out.println("selectedTaskStatus "+selectedTaskStatus);
	  if ("1".equals(selectedTaskStatus)) {  %>
	    <OPTION value="1" selected >NOT_STARTED</OPTION>
   		<OPTION value="2" >IN_PROCESS</OPTION>
   		<OPTION value="3" >COMPLETE</OPTION>
   		<OPTION value="9999">--All--</OPTION>   
		  
	 <% } else if("2".equals(selectedTaskStatus)) {  %>
	   <OPTION value="1" >NOT_STARTED</OPTION>
   		<OPTION value="2" selected >IN_PROCESS</OPTION>
   		<OPTION value="3" >COMPLETE</OPTION>
   		<OPTION value="9999">--All--</OPTION>   
		  
	 <% } else if("3".equals(selectedTaskStatus)) {  %>
	   <OPTION value="1" >NOT_STARTED</OPTION>
   		<OPTION value="2" >IN_PROCESS</OPTION>
   		<OPTION value="3" selected >COMPLETE</OPTION>
   		<OPTION value="9999">--All--</OPTION>   
		  
	  <% } else {  %>
	    <OPTION value="1" >NOT_STARTED</OPTION>
   		<OPTION value="2" >IN_PROCESS</OPTION>
   		<OPTION value="3" >COMPLETE</OPTION>
   		<OPTION value="9999" selected>--All--</OPTION>   
		  
	  <% }
		
      %>
          
</SELECT></TD> 
<TD align=left  >
<div id="SinceLast">
<SELECT name=JobDuration> 

<%
 	String selectedJobDuration = (String)request.getAttribute("selectedJobDuration");
	int[] jobDurations = {1,5,10,15,30,60,300,600,1440,2880,4320,5760,7200,8640,10080};
 	selected = "";
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
   <td align=left><B>Host Name:</B></td>
   <td align=left><B>Regex</B></td>
   <td align=left><B>Catalog Provider</B></td>
   <td align=left><B>Seller</B></td>
   <td align=left><B>Environment</B></td>
   
   <tr>
   <td align="left" >
   <select name="HostId"> 
   
     <OPTION value="chd1b01c-4246">chd1b01c-4246</OPTION>
     <OPTION value="chd1b01c-fae6">chd1b01c-fae6</OPTION>
     <OPTION value="chd1b02c-0e67">chd1b02c-0e67</OPTION>
     <OPTION value="chd1b02c-c070">chd1b02c-c070</OPTION>
     <OPTION value="chd1b02c-36bc">chd1b02c-36bc</OPTION>
     <OPTION value="chd1b02c-db51">chd1b02c-db51</OPTION>
   
     
     
     <OPTION value="9999" selected>--All--</OPTION>
          
</SELECT></TD> 
 
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
   <select name="catalogprovider"> 
   <%
   String selectedCatalogProvider = (String)request.getAttribute("selectedCatalogProvider");
   if ("whi".equals(selectedCatalogProvider)) {  %>
	    <OPTION value="whi" selected>whi</OPTION>
    	<OPTION value="invaluable">invaluable</OPTION>
     	<OPTION value="sothebys">sothebys</OPTION>
	 <% } else if("invaluable".equals(selectedCatalogProvider)) {  %>
	    <OPTION value="whi">whi</OPTION>
    	<OPTION value="invaluable" selected>invaluable</OPTION>
     	<OPTION value="sothebys">sothebys</OPTION>
		  
	 <% } else if("sothebys".equals(selectedCatalogProvider)) {  %>
	    <OPTION value="whi">whi</OPTION>
    	<OPTION value="invaluable" selected>invaluable</OPTION>
     	<OPTION value="sothebys" selected>sothebys</OPTION>
		  
	  <% } else {  %>
	     <OPTION value="whi">whi</OPTION>
         <OPTION value="invaluable">invaluable</OPTION>
         <OPTION value="sothebys">sothebys</OPTION>
	  <% }
   %>
  
          
</SELECT></TD>
<td align="left" >
     <%
       String selectedSellerId =  (String)request.getAttribute("selectedSellerId");
      if(selectedSellerId !=null && !selectedSellerId.equals("null") && !selectedSellerId.equals("") ) {
     %>

<input type="text" name="sellerid" value="<%=selectedSellerId%>"/>
   <%
      } else {
     %>
      <INPUT  type="text" name="sellerid" value="autozone">
      <%
      }
       %>
</td>
       <td align="left" >
   <select name="environment"> 
   <%
     String environment = (String)request.getAttribute("environment");
  	 String [] environments = {"Production", "QA"};
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
		<th>Host</th>
		<th>Service Name</th>
		<th>Batch Status</th>
		<th>Task Status</th>
		<th>Created Date</th>
		<th>Last Modified Date</th>
		<th>Time Taken</th>
		<th>Batch Args</th>
		<th>Log File</th>
	</tr>
	<%
	VipBatchMonitorPojo[] monitors = (VipBatchMonitorPojo [])request.getAttribute("monitors");
	for(int i =0;i<monitors.length;i++) {
		if(monitors[i] == null) continue;
		System.out.println(monitors[i]);
	%>
	<tr align="center">
		<td><%= monitors[i].getHostName()  %></td>
		<td><%= monitors[i].getServiceName()  %></td>
		<td width="30"><% if(monitors[i].getBatchStatus() == 7 || monitors[i].getBatchStatus() == 12) { %>
		<div style="text-align: center;">
		 <img alt="" src="http://d-sjc-00531331:9090/TestProject/green.png"  height="5%" width="25%"/>
		</div>
		<%
		 } else  if(monitors[i].getBatchStatus() == 5 || monitors[i].getBatchStatus() == 11) { %>
		 <div style="text-align: center;">
		 	<img alt="" src="http://d-sjc-00531331:9090/TestProject/yellow.png" height="8%" width="25%"/>
		 </div>
		<%
		 } else {
		%>
		
		 <div style="text-align: center;">
		 <%=monitors[i].getBatchStatus() %>
		 	<img alt="" src="http://d-sjc-00531331:9090/TestProject/red.png" height="8%" width="25%"/>
		 </div>
		<%
		  }
		%>
		</td>
		<td width="30"><% if(monitors[i].getTaskStatus() == 3) { %>
		<div style="text-align: center;">
		 <img alt="" src="http://d-sjc-00531331:9090/TestProject/green.png"  height="5%" width="25%"/>
		</div>
		<%
		 } else { %>
		 <div style="text-align: center;">
		 	<img alt="" src="http://d-sjc-00531331:9090/TestProject/yellow.png" height="8%" width="25%"/>
		 </div>
		<%
		}	
		%>
		</td>
		<td>
			<%=monitors[i].getCreationDate() %>
		</td>
		<td>
			<%=monitors[i].getLastModifiedDate()%>
		</td>
		<td>
		  <%
		  if(monitors[i].getCreationDate() !=null && monitors[i].getLastModifiedDate() !=null) {
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		     Date created =  formatter.parse(monitors[i].getCreationDate());
		  	 Date modified =  formatter.parse(monitors[i].getLastModifiedDate());
		  	long diff = modified.getTime() - created.getTime();
		  	long diffSeconds = (diff / 1000) ;
		  	if(diffSeconds > 59) {
		  		diffSeconds = diffSeconds/60;
		  %>
		  	<%=diffSeconds %> mins.
		  <% 		
		  	}
		  	else {
		  %>
		  <%=diffSeconds %> secs.
		  <%
		   }
		  }
		  %>
		</td>
		<td width="30">
		 <%=monitors[i].getBatchArgs() %>
		</td>
		<td width="30">
		 <a target="_new" href="<%=monitors[i].getLogFileURL() %>"><%=monitors[i].getLogFile() %></a>
		</td>
	</tr>
	<%
	 }
	 %>
</table>
</div>
</body>
</html>