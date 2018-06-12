package dev.rest.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import sun.misc.BASE64Encoder;

/**
 * Java Client for GET Request using Jersey API with HTTP basic authentication
 * @author 
 *
 */
public class RestClientUsingJerseyWithHttpAuthentication {

	 public static void main(String a[]){
         
	        String url = "http://localhost:6060/Rest_J2NV_App1/order-http-auth/order/1016";
	        String name = "";
	        String password = "hello";
	        String authString = name + ":" + password;
	        String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
	        System.out.println("Base64 encoded auth string: " + authStringEnc);
	        Client restClient = Client.create();
	        WebResource webResource = restClient.resource(url);
	        ClientResponse resp = webResource.accept("application/json")
	                                         .header("Authorization", "Basic " + authStringEnc)
	                                         .get(ClientResponse.class);
	        if(resp.getStatus() != 200){
	            System.err.println("Unable to connect to the server");
	        }
	        String output = resp.getEntity(String.class);
	        System.out.println("response: "+output);
	    }
}
