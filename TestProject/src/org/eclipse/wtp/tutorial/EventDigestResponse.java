package org.eclipse.wtp.tutorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventDigestResponse {

	private String status;
	private List<String> errors = new ArrayList<String>();
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 *
	 * @return
	 * The status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 *
	 * @param status
	 * The status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 *
	 * @return
	 * The errors
	 */
	public List<String> getErrors() {
		return errors;
	}

	/**
	 *
	 * @param errors
	 * The errors
	 */
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}

