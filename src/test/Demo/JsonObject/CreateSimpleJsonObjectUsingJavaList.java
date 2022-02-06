package JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.*;

public class CreateSimpleJsonObjectUsingJavaList {
    public static void main(String[] args) {
        Map<String,Object> employee1 = new LinkedHashMap<>();
        employee1.put("id","1");
        employee1.put("last_name","John");
        employee1.put("first_name","Kendy");
        employee1.put("age","18");
        Map<String,Object> employee2 = new LinkedHashMap<>();
        employee2.put("id","2");
        employee2.put("last_name","Tom");
        employee2.put("first_name","Kendy");
        employee2.put("age","18");
        List<Map<String,Object>> allEmployee = new ArrayList<>();
        allEmployee.add(employee2);
        allEmployee.add(employee1);
        RestAssured
                .given()
                .log()
                .all()
                .body(allEmployee)
                .contentType(ContentType.JSON)
                .get();
    }
}
