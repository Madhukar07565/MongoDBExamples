/**
 * 
 */
package com.mongodb;

import java.util.Random;

/**
 * @author madhukar
 *
 */
public class MongoSortSkipLimit {


    public static void main(String[] args) {
        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

        DB database = client.getDB("test");
        DBCollection collection = database.getCollection("findTest");
        collection.drop();

        for (int i = 0; i < 5; i++) {
            collection.insert(new BasicDBObject().append("x", new Random().nextInt(2)).append("y",
                    new Random().nextInt(100)));
        }

        DBObject query = new BasicDBObject().append("x", 0)
                .append("y", new BasicDBObject("$gt", 50).append("$lt", 100));

        DBObject builder = QueryBuilder.start("x").is(0).and("y").greaterThan(40).lessThan(90).get();

        System.out.println("Find one >>> ");
        DBObject object = collection.findOne(query);
        System.out.println(object);

        System.out.println("find All>>> ");
        DBCursor cursor = collection.find(builder);
        try {
            while (cursor.hasNext()) {
                DBObject dbObject = (DBObject) cursor.next();
                System.out.println(dbObject);
            }
        } finally {
            cursor.close();
        }
        
        System.out.println("find All with projection>>> ");
        DBCursor cursor1 = collection.find(builder,new BasicDBObject("x",false)).sort(new BasicDBObject("y",1)).skip(1).limit(2);
        try {
            while (cursor1.hasNext()) {
                DBObject dbObject = (DBObject) cursor1.next();
                System.out.println(dbObject);
            }
        } finally {
            cursor.close();
        }
        
        System.out.println("Count");
        long count = collection.count(query);
        System.out.println(count);

    }


}
