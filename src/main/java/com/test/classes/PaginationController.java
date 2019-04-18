package com.test.classes;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/")
public class PaginationController {

	PaginationService pService = new PaginationService();
		
	@Path("/getPerson")
	@Produces(MediaType.APPLICATION_JSON)
    @POST
    public JsonObject getUsers(
    		@QueryParam("searchText") String searchText,
    		@QueryParam("limit") int limit,
    		@QueryParam("orderBy") String orderBy)  {
		
		
		List<String> list=pService.getUsers(searchText,limit,orderBy);  
		
		JsonObject response =Json.createObjectBuilder().add("data", list.toString()).build();
		
		return response;
	}
	
	@Path("/test")
	@GET
	public Response apply(  ) {
		return Response.ok( "OK" ).build();
	}

}	
