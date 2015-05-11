/**
 * 
 */
package com.mongodb;

import java.util.Set;

/**
 * @author madhukar
 *
 */
public class HelloWorldMongoDBStyle {
    
    public static void main(String[] args) {
        
        MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017));
        
        DB database = mongoClient.getDB("test");
        
        DBCollection collection = database.getCollection("people");
        
        DBObject document = collection.findOne();
        
        System.out.println(document);
        
        Set<String> keys = document.keySet();
        
        for (String string : keys) {
            System.out.println("key "+string);
        }
    }

}
