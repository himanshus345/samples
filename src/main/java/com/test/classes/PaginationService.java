package com.test.classes;

import java.util.ArrayList;
import java.util.List;

import javax.json.JsonArray;

public class PaginationService {

	public List<Person> getUsers(String searchText, int limit, String sortType) {

		PersonDAO users = new PersonDAOImpl();
		JsonArray listOfUsers =  users.getRecords(searchText, limit, sortType);
		List<Person> list = new ArrayList<>();
		
		if( listOfUsers != null && !listOfUsers.isEmpty() ){
			for(int i=0; i<listOfUsers.size(); i++) {
				
				Person person = new Person();
				person.setName(listOfUsers.getJsonObject(i).getString("name"));
				list.add(person);
			}
			
		}
		
		return list;
            
		
	}

}
