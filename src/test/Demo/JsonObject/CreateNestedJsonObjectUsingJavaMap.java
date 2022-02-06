package JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.LinkedHashMap;
import java.util.Map;

public class CreateNestedJsonObjectUsingJavaMap {
    public static void main(String[] args) {
        Map<String, Object> jsonObjectPayload = new LinkedHashMap<>();
        jsonObjectPayload.put("id","1");
        jsonObjectPayload.put("first_name","Jonh");
        jsonObjectPayload.put("last_name","Kendy");
        jsonObjectPayload.put("age","18");
        Map<String, Object> address = new LinkedHashMap<>();
        address.put("No", "123");
        address.put("city", "Bac Ninh");
        address.put("distric","Tien Du");
        jsonObjectPayload.put("address",address);
        RestAssured
                .given()
                .log().all()
                .body(jsonObjectPayload)
                .contentType(ContentType.JSON)
                .get();
    }
}
