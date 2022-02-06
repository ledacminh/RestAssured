package JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class ConvertDynamicJsonResponseToJavaObject {
    public static void main(String[] args) {
       Response response =  RestAssured
                .get("https://run.mocky.io/v3/d6668ab3-55a0-4eb5-8a4a-cd1d768e8837");
       Object responseAsObject =  response.as(Object.class);
       if(responseAsObject instanceof List){
           List responseAsList = (List)responseAsObject;
           System.out.println(responseAsList.size());
       }else if(responseAsObject instanceof Map){
           Map responseAsMap = (Map)responseAsObject;
           System.out.println(((Map)responseAsObject).keySet());
       }

    }
}
