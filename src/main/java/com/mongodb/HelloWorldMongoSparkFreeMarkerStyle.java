/**
 * 
 */
package com.mongodb;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author madhukar
 *
 */
public class HelloWorldMongoSparkFreeMarkerStyle {

    public static void main(String[] args) {
        
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldSparkfreemarkerStyle.class, "/");
        
        MongoClient client = new MongoClient(new ServerAddress("localhost",27017));
        
        DB db = client.getDB("test");
        final DBCollection collection = db.getCollection("people");
        
        final StringWriter writer = new StringWriter();        
        Spark.get(new Route("/") {
            
            @Override
            public Object handle(Request arg0, Response arg1) {
               try {
                Template template = configuration.getTemplate("hello.ftl");
                DBObject doc = collection.findOne();
                template.process(doc, writer);
            } catch (Exception e) {
                e.printStackTrace();
            }
               return writer;
            }
        });

    }


}
