package dev.rest.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Java Client for GET Request using Jersey API
 * @author gauraw
 *
 */
public class RestClientUsingJerseyForGETRequest {

	public static void main(String[] args) {
		//invoking P14 Service
		String url = "http://localhost:6060/Rest_J2NV_App1/order-inventory-json/order/1234";
        Client restClient = Client.create();
        WebResource webResource = restClient.resource(url);
        ClientResponse resp = webResource.accept("application/json")
                                                    .get(ClientResponse.class);
        if(resp.getStatus() != 200){
            System.err.println("Unable to connect to the server");
        }
        String output = resp.getEntity(String.class);
        System.out.println("response: "+output);
	}
}
