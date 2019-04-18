package com.test.classes;

import java.util.List;

import javax.json.JsonArray;

import org.bson.Document;


public class PersonDAOImpl implements PersonDAO {
	
	MongoManager mongoManager = new MongoManager();

	
	public JsonArray getRecords(String searchText,int limit,String sortType){  
		JsonArray result = null;
        try {
        	
        	Document queryDocument = new Document();
            
            if( searchText != null && !searchText.isEmpty()) {
           	 Document regex = new Document();
                regex.put("$regex", searchText);
                regex.put("$options", "i");
                
         		queryDocument.put("name",  regex );
           }
                        
            Document sortDocument = new Document();
            if( sortType == "" ) {
            	sortDocument.put("_id", 1);
            }else {
            	sortDocument.put(sortType, -1);
            }

            result = mongoManager.findDocument("users",queryDocument,sortDocument,limit);
            

        } catch (Exception e) {
            
        }
        return result;
	}

	
}