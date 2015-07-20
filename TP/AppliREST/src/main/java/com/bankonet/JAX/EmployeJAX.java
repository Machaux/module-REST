package com.bankonet.JAX;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.bankonet.EJB.EmployeEJB;
import com.bankonet.persistance.Employe;



@Path("/employes")
public class EmployeJAX {

	@EJB EmployeEJB employeEJB;
	
		/**
		 * un GET sur l'URL .../employes renvoie la totalité des employés au format JSON.
		 * @return liste des employés
		 */
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response get(){

			List<Employe> liste = employeEJB.getEmployes();
			
			ResponseBuilder builder = Response.ok(liste);
			builder.status(200);
			builder.header("Access-Control-Allow-Origin", "*");
			
			return builder.build(); 
		}
		
		/**
		 * un GET paramétré avec l'id d'un employé renvoie cet employé en particulier.
		 * @return employé avec l'ID demandé.
		 */
		@GET
		@Path("/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response get(@PathParam("id") Integer id){
			
			ResponseBuilder builder = Response.noContent();
			
			Employe employe = employeEJB.getEmployesByID(id);
			
			if (employe!=null)
			{
				builder = Response.ok(employe);
			}
			else
			{
				builder.status(404);
			}
		
			return builder.build(); 
		}
		
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		public Response post(@FormParam("id") int id, @FormParam("nom") String nom){

			ResponseBuilder builder = Response.noContent();
				
			if (id==0 || nom.equals(null)) //tester le null avec ==
			{
				builder.status(400);
			}
			else
			{
				employeEJB.createEmploye(id, nom);
				builder = Response.ok();
			}
		
			return builder.build(); 
		}
		
		
		@PUT
		@Produces(MediaType.APPLICATION_JSON)
		public Response put(@FormParam("id") int id, @FormParam("nom") String nom){

			ResponseBuilder builder = Response.noContent();
			
			try
			{
				employeEJB.updateEmploye(id, nom);
				builder.status(200);
			}
			catch (Exception exception) // restreindre davantage les exceptions levées
			{
				builder.status(400);
			}
			finally
			{
				return builder.build();
			}
		}
		
		@DELETE
		@Path("/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response delete(@PathParam("id") Integer id){

			ResponseBuilder builder = Response.noContent();
			
			try
			{
				employeEJB.deleteEmploye(id);
				builder.status(200);
			}
			catch (Exception exception)
			{
				builder.status(400);
			}
			finally
			{
			return builder.build();
			}
		}
		
}
	

