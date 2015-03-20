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

public class HelloWorldSparkfreemarkerStyle {
    public static void main(String[] args) {
        
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldSparkfreemarkerStyle.class, "/");
        final StringWriter writer = new StringWriter();        
        Spark.get(new Route("/") {
            
            @Override
            public Object handle(Request arg0, Response arg1) {
               try {
                Template template = configuration.getTemplate("hello.ftl");
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("name", "Madhukar Reddy");
                template.process(map, writer);
            } catch (Exception e) {
                e.printStackTrace();
            }
               return writer;
            }
        });

    }
}
