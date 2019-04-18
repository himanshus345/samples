package com.test.classes;

import java.util.List;

import javax.json.JsonArray;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

@ApplicationPath("/")
public class PaginationController {

	PaginationService pService = new PaginationService();
		
	@Path("/getPerson")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getUsers(
    		@QueryParam("searchText") String searchText,
    		@QueryParam("limit") int limit,
    		@QueryParam("orderBy") String orderBy)  {
		
		
		List<Person> list=pService.getUsers(searchText,limit,orderBy);  

		//The response can be returned as list or a JSONObject based on the convinience
		JSONObject response = new JSONObject();
		response.put("response",list);
		return response;
	}
	
	@Path("/test")
	@GET
	public String Test() {
		return "OK";
	}

}	
