package com.test.classes;

import com.mongodb.*;
import com.mongodb.client.*;
import org.bson.Document;
import java.io.StringReader;
import java.util.*;
import javax.json.*;

public class MongoManager {

	private MongoClient getMongoClient() {
		MongoClient mongoClient = null;
		try {
			MongoCredential testAuth = MongoCredential.createCredential("username", "db", "password".toCharArray());
			List<MongoCredential> auths = new ArrayList<MongoCredential>();
			auths.add(testAuth);
			
			//Credential skipped
			mongoClient = new MongoClient(Arrays.asList(new ServerAddress("localhost" + ":" + 27017)));

		} catch (Exception ex) {

		}
		return mongoClient;
	}

	/* This function will return sorted form 
	 * of all the users 
	 * based on user's name
	  */
	public JsonArray findDocument(String collectionName, Document queryDocument, Document sortCriteria,int limit) {

		MongoClient mongoClient = null;
		Document document = new Document();
		JsonArrayBuilder documentsBuilder = Json.createArrayBuilder();
		
		try {
			
			mongoClient = getMongoClient();

			MongoDatabase database = mongoClient.getDatabase("localCollection");
			MongoCollection<Document> collection = database.getCollection(collectionName);
			MongoCursor<Document> cursor = collection.find(queryDocument).sort(sortCriteria).limit(limit).iterator();
			
			if (cursor != null && cursor.hasNext()) {
				document = cursor.next();
				documentsBuilder.add( convertStringToJson( document.toJson() ) );
			}
			

		} catch (Exception ex) {

		} finally {
			try {
				if (mongoClient != null)
					mongoClient.close();
			} catch (Exception ex) {

			}
		}

		return documentsBuilder.build();
	}

	//This method convert String to Json (javax.json)
	public static JsonObject convertStringToJson( String jsonString ) {
        JsonObject jsobObj = null;
        try (StringReader sReader = new StringReader( jsonString );
                JsonReader reader = Json.createReader(sReader)) {
        	jsobObj = reader.readObject();
            reader.close();
        }
        return jsobObj;
    }
}
