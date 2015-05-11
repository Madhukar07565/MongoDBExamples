/**
 * 
 */
package com.mongodb;

import java.util.Arrays;
import java.util.List;

/**
 * @author madhukar
 *
 */
public class MongoUpdateReplace {
    public static void main(String[] args) {
        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

        DB db = client.getDB("test");
        DBCollection collection = db.getCollection("updateReplace");

        collection.drop();
        
        List<String> names = Arrays.asList("M", "K", "s", "V");
        for (String string : names) {
            collection.insert(new BasicDBObject("name",string));
        }

        collection.update(new BasicDBObject("name", "M"),new BasicDBObject("$set",new BasicDBObject("age",24)));
        DBCursor cursor = collection.find();
        try {
            while (cursor.hasNext()) {
                DBObject dbObject = (DBObject) cursor.next();
                System.out.println(dbObject);
            }
        } finally {
            cursor.close();
        }
        
        collection.remove(new BasicDBObject("name","V"));
        System.out.println("After delete");
        DBCursor cursor1 = collection.find();
        try {
            while (cursor1.hasNext()) {
                DBObject dbObject = (DBObject) cursor1.next();
                System.out.println(dbObject);
            }
        } finally {
            cursor.close();
        }
        
    }

}
