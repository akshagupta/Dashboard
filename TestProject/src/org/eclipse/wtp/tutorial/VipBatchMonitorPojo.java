package org.eclipse.wtp.tutorial;

import javax.xml.bind.annotation.XmlRootElement;

import org.json.JSONException;
import org.json.JSONObject;

@XmlRootElement
public class VipBatchMonitorPojo {

	private long vipBatchMonitorId, partsCatalogProviderId, warningThreshold,
			errorThreshold, usedMemory, totalMemory, maxUsedMemory, maxMemory,
			avgUsedMemory, completedWorkUnits, flags01;
	private int feedType,batchInstanceNumber, batchStatus, taskStatus;
	
	private long lastHeartBeat,lastPing, lastEmailSent;
	private String serviceName="", hostName="", lastErrorMessage="", batchArgs= "",additionalInfo= "";
	
	public int getTaskStatus() {
		return taskStatus;
	}
	public String getBatchArgs() {
		return batchArgs;
	}
	public void setBatchArgs(String batchArgs) {
		this.batchArgs = batchArgs;
	}
	
	public String getLogFileURL() {
		JSONObject jsonObject;
		try {
			if(additionalInfo !=null) {
				jsonObject = new JSONObject(additionalInfo);
				//http://ph-caradmgr002.phx.ebay.com/vip/logs/endoffeedtask/
				// /home/cronusapp/.appdata/filer_mountpoint//logs/eventdatafeedtask/0/eventdatafeedtask_101014-182445.log	
				String logFile= jsonObject.getString("log_filename");
				logFile = logFile.substring(logFile.indexOf("logs"));
				logFile = "http://ph-caradmgr002.phx.ebay.com/vip/"+logFile;
			return logFile;
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "";
	}
	
	public String getLogFile() {
		JSONObject jsonObject;
		try {
			if(additionalInfo !=null) {
				jsonObject = new JSONObject(additionalInfo);
				String logFile= jsonObject.getString("log_filename");
				logFile = logFile.substring(logFile.lastIndexOf("/")+1);
				return logFile;
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "";
	}
	
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public void setTaskStatus(int taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	public long getVipBatchMonitorId() {
		return vipBatchMonitorId;
	}
	public void setVipBatchMonitorId(long vipBatchMonitorId) {
		this.vipBatchMonitorId = vipBatchMonitorId;
	}
	public long getPartsCatalogProviderId() {
		return partsCatalogProviderId;
	}
	public void setPartsCatalogProviderId(long partsCatalogProviderId) {
		this.partsCatalogProviderId = partsCatalogProviderId;
	}
	public long getWarningThreshold() {
		return warningThreshold;
	}
	public void setWarningThreshold(long warningThreshold) {
		this.warningThreshold = warningThreshold;
	}
	public long getErrorThreshold() {
		return errorThreshold;
	}
	public void setErrorThreshold(long errorThreshold) {
		this.errorThreshold = errorThreshold;
	}
	public long getUsedMemory() {
		return usedMemory;
	}
	public void setUsedMemory(long usedMemory) {
		this.usedMemory = usedMemory;
	}
	public long getTotalMemory() {
		return totalMemory;
	}
	public void setTotalMemory(long totalMemory) {
		this.totalMemory = totalMemory;
	}
	public long getMaxUsedMemory() {
		return maxUsedMemory;
	}
	public void setMaxUsedMemory(long maxUsedMemory) {
		this.maxUsedMemory = maxUsedMemory;
	}
	public long getMaxMemory() {
		return maxMemory;
	}
	public void setMaxMemory(long maxMemory) {
		this.maxMemory = maxMemory;
	}
	public long getAvgUsedMemory() {
		return avgUsedMemory;
	}
	public void setAvgUsedMemory(long avgUsedMemory) {
		this.avgUsedMemory = avgUsedMemory;
	}
	public long getCompletedWorkUnits() {
		return completedWorkUnits;
	}
	public void setCompletedWorkUnits(long completedWorkUnits) {
		this.completedWorkUnits = completedWorkUnits;
	}
	public long getFlags01() {
		return flags01;
	}
	public void setFlags01(long flags01) {
		this.flags01 = flags01;
	}
	public int getFeedType() {
		return feedType;
	}
	public void setFeedType(int feedType) {
		this.feedType = feedType;
	}
	public int getBatchInstanceNumber() {
		return batchInstanceNumber;
	}
	public void setBatchInstanceNumber(int batchInstanceNumber) {
		this.batchInstanceNumber = batchInstanceNumber;
	}
	public int getBatchStatus() {
		return batchStatus;
	}
	public void setBatchStatus(int batchStatus) {
		this.batchStatus = batchStatus;
	}
	public long getLastHeartBeat() {
		return lastHeartBeat;
	}
	public void setLastHeartBeat(long lastHeartBeat) {
		this.lastHeartBeat = lastHeartBeat;
	}
	public long getLastPing() {
		return lastPing;
	}
	public void setLastPing(long lastPing) {
		this.lastPing = lastPing;
	}
	public long getLastEmailSent() {
		return lastEmailSent;
	}
	public void setLastEmailSent(long lastEmailSent) {
		this.lastEmailSent = lastEmailSent;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getLastErrorMessage() {
		return lastErrorMessage;
	}
	public void setLastErrorMessage(String lastErrorMessage) {
		this.lastErrorMessage = lastErrorMessage;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	private String creationDate, lastModifiedDate;
	
}
