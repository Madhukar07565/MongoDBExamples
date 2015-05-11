/**
 * 
 */
package com.mongodb;

import java.util.Random;

/**
 * @author madhukar
 *
 */
public class MongoFind {

    public static void main(String[] args) {
        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

        DB database = client.getDB("test");
        DBCollection collection = database.getCollection("findTest");
        collection.drop();

        for (int i = 0; i < 5; i++) {
            collection.insert(new BasicDBObject().append("x", new Random().nextInt(10)));
        }
        System.out.println("Find one >>> ");
        DBObject object = collection.findOne();
        System.out.println(object);

        System.out.println("find All>>> ");
        DBCursor cursor = collection.find();
        try {
            while (cursor.hasNext()) {
                DBObject dbObject = (DBObject) cursor.next();
                System.out.println(dbObject);
            }
        } finally {
            cursor.close();
        }
        System.out.println("Count");
        long count = collection.count();
        System.out.println(count);

    }
}
