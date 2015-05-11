/**
 * 
 */
package com.mongodb;

import java.util.Arrays;

/**
 * @author madhukar
 *
 */
public class MongoInsert {
    public static void main(String[] args) {

        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

        DB database = client.getDB("test");

        DBCollection collection = database.getCollection("inserting");

        DBObject doc = new BasicDBObject().append("x", 1);
        DBObject doc2 = new BasicDBObject().append("x", 2);

        System.out.println(doc);

        //collection.insert(doc);//single insertion
        collection.insert(Arrays.asList(doc,doc2));//multiple insertion

        System.out.println(doc);//if we insert the same document multiple times we will get exception colletion.insert(doc);

    }
}
