package com.bankonet.Service;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.bankonetCli.Employe;



public class EmployeService {

	public static Client client=ClientBuilder.newClient();
	public static WebTarget target = client.target("http://localhost:8080/bankonet-REST/api");
	
	public static Response getEmploye(){
		
		
		Invocation.Builder builder = target.path("employes").request();
		
		Response response = builder.get();
		
		return response;
		
	}
	
}
