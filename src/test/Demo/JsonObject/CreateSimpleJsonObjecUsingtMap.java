package JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

public class CreateSimpleJsonObjecUsingtMap {
    public static void main(String[] args) {
        Map<Object,Object> jsonObjectPayload = new HashMap<>();
        Map<Object,Object> address = new HashMap<>();
        address.put("City","Ha Noi");
        address.put("distric","Tien Du");
        jsonObjectPayload.put("id","1");
        jsonObjectPayload.put("firs_tname","Jonh");
        jsonObjectPayload.put("last_name","Kendy");
        jsonObjectPayload.put("age","18");
        jsonObjectPayload.put("address",address);
        RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(jsonObjectPayload)
                .get();
    }


}
