package Utils;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.*;


public class RestUtil {
    //Global Setup Variables
    public static  String path = "";//Request path
    //Before starting the test, we should set the RestAssured Base URI
    public static void setBaseURI (String baseURI){
        RestAssured.baseURI = baseURI;
    }
    //Before starting the test, we should set the RestAssured Base Path
    public static void setBasePath(String basePath){
        RestAssured.basePath = basePath;
    }
    //After the test, we should reset the RestAssured.basePath
    public static void resetBasePath(){
        RestAssured.basePath = null;
    }
    /*
    We should set content type as JSON or XML before starting the test
     */
    public static void setContentType(ContentType contentType){
      RestAssured.given().contentType(contentType);
    }
    /*
    Search query path of first example, format xxx/yyy?param=value
     */
    public static void createSearchQueryPath(String searchTerm, String jsonPathTerm, String param, String paramValue){
        path = searchTerm + "/" + jsonPathTerm + "?" + param + "=" + paramValue;
    }
    //Return response
    public static Response getResponse(){
        return get(path);
    }

    /*
    ***Return Json Path Object
    * First, convert the API's response to String type with "asString()" method
    * Then, send this String formated json response to the JsonPath class and return
     */
    public static JsonPath getJsonPath(Response response){
        String json = response.asString();
        return new JsonPath(json);
    }
}
