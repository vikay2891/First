package dev.rest.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Java Client for POST Request using Jersey API
 * @author gauraw
 *
 */
public class RestClientUsingJerseyForPOSTRequest {

		public static void main(String[] args) {
			// invoking P15 Service
			String url = "http://localhost:6060/Rest_J2NV_App1/accept-json-input/order";
	        String jsonInput = "{\"custmer\":\"Gauraw\",\"address\":\"Bangalore\","+
	                "\"bill-amount\":\"$2000\"}";
	        Client restClient = Client.create();
	        WebResource webResource = restClient.resource(url);
	        ClientResponse resp = webResource.type("application/json")
	                                    .post(ClientResponse.class, jsonInput);
	        if(resp.getStatus() != 200){
	            System.err.println("Unable to connect to the server");
	        }
	        String output = resp.getEntity(String.class);
	        System.out.println("response: "+output);
		}
}
