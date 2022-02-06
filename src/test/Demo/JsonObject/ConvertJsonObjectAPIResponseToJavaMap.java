package JsonObject;

import io.restassured.RestAssured;

import java.util.Map;

public class ConvertJsonObjectAPIResponseToJavaMap {
    public static void main(String[] args) {
        Map jsonResponseAsMap = RestAssured
                .given().log().all()
                .get("https://run.mocky.io/v3/a0061df7-b451-4085-92c2-acdad34094b1")
                .as(Map.class);
        String firstName = (String)jsonResponseAsMap.get("firstname");
        System.out.println(firstName);
        jsonResponseAsMap.keySet().forEach(k -> System.out.println(k));
    }
}
