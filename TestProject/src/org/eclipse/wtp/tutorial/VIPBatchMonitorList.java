package org.eclipse.wtp.tutorial;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;



/**
* List of all machines in VIP pool.
*
*/
@XmlRootElement
public class VIPBatchMonitorList {
	private List<VipBatchMonitorPojo> workflowTasks = new ArrayList<VipBatchMonitorPojo>();
	
	public List<VipBatchMonitorPojo> getWorkflowTasks() {
		return workflowTasks;
	}

	public void setWorkflowTasks(List<VipBatchMonitorPojo> workflowTasks) {
		this.workflowTasks = workflowTasks;
	}

}