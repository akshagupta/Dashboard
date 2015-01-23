package org.eclipse.wtp.tutorial;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MachineHealth {
	private String hostname;
	private String totalMemory;
	private String maxMemory;
	private String avgUsedMemory;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getTotalMemory() {
		return totalMemory;
	}
	public void setTotalMemory(String totalMemory) {
		this.totalMemory = totalMemory;
	}
	public String getMaxMemory() {
		return maxMemory;
	}
	public void setMaxMemory(String maxMemory) {
		this.maxMemory = maxMemory;
	}
	public String getAvgUsedMemory() {
		return avgUsedMemory;
	}
	public void setAvgUsedMemory(String avgUsedMemory) {
		this.avgUsedMemory = avgUsedMemory;
	}
	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	
}
