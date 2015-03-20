package com.mongodb;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkRoutes {
    public static void main(String[] args) {
        
       Spark.get(new Route("/") {
        
        @Override
        public Object handle(Request request, Response response) {
            return "Hello From /";
        }
    });

       Spark.get(new Route("/test") {
        
        @Override
        public Object handle(Request request, Response response) {
            return "Hello From /test";
        }
    });
       
       Spark.get(new Route("/echo/:test") {
        
        @Override
        public Object handle(Request request, Response response) {
            return request.params(":test");
        }
    });
    }

}
