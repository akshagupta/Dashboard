package org.eclipse.wtp.tutorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllMachines {
	
		private List<MachineHealth> machineList = new ArrayList<MachineHealth>();
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();
		
		public List<MachineHealth> getMachineList() {
			return machineList;
		}
		public void setMachineList(List<MachineHealth> machineList) {
			this.machineList = machineList;
		}
		public Map<String, Object> getAdditionalProperties() {
			return additionalProperties;
		}
		public void setAdditionalProperties(Map<String, Object> additionalProperties) {
			this.additionalProperties = additionalProperties;
		}

		
}
