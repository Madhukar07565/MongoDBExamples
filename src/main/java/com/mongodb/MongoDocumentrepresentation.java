/**
 * 
 */
package com.mongodb;

import java.util.Arrays;

/**
 * @author madhukar
 *
 */
public class MongoDocumentrepresentation {
    
    public static void main(String[] args) {
        BasicDBObject document = new BasicDBObject();
        document.put("name", "Madhu");
        document.put("age", 25);
        document.put("hobbies", Arrays.asList("reading","cricket"));
        document.put("address", new BasicDBObject("street","20th main").append("Pincode","560067"));
    }

}
