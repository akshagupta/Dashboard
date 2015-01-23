package org.eclipse.wtp.tutorial;

import java.util.UUID;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource.Builder;

public class RestClientUtil {
	
	private static Client restClient;
	private RestClientUtil() {}
	
	
	private static Builder getWebResource(String endpoint, String resourceType) {
		if (restClient==null) {
			restClient=Client.create();
		}
		String currentCorrId = UUID.randomUUID().toString();
		return restClient.resource(endpoint).header("X_CORRELATION_ID", currentCorrId).type(resourceType);
	}
	
	public static ClientResponse post(String endpoint, String resourceType, String request) {
		Builder builder = getWebResource(endpoint, resourceType);
		return builder.post(ClientResponse.class, request);
	}
	
	public static ClientResponse get(String endpoint, String resourceType) {
		Builder builder = getWebResource(endpoint, resourceType);
		return builder.get(ClientResponse.class);
	}
}
