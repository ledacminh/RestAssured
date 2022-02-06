package JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.*;

public class CreateComplexJsonPayloadUsingJava {
    public static void main(String[] args) {
        //parent Json array
        List<Map<String,Object>> finalPayload = new ArrayList<Map<String,Object>>();
        Map<String,Object> firstJsonObject = new LinkedHashMap<String,Object>();
        firstJsonObject.put("id","1");
        firstJsonObject.put("first_name","Tom");
        firstJsonObject.put("last_name","Kendy");
        firstJsonObject.put("gender","Male");
        List<String> mobileNo1 = Arrays.asList("0966152432","012349852");
        firstJsonObject.put("mobile", mobileNo1);
        Map<String,Object> skillSet1 = new LinkedHashMap<String,Object>();
        skillSet1.put("name","Testing");
        skillSet1.put("proficiency","Medium");
        firstJsonObject.put("skills", skillSet1);
        finalPayload.add(firstJsonObject);
        //object2
        Map<String,Object> secondJsonObject = new LinkedHashMap<String,Object>();
        secondJsonObject.put("id","2");
        secondJsonObject.put("first_name","Jack");
        secondJsonObject.put("last_name","Kendy");
        secondJsonObject.put("gender","Female");
        List<String> mobileNo2 = Arrays.asList("0966152432","012349852");
        secondJsonObject.put("mobile", mobileNo2);
        Map<String,Object> skillSet2 = new LinkedHashMap<String,Object>();
        skillSet2.put("name","Testing");
        skillSet2.put("proficiency","Medium");
        secondJsonObject.put("skills", skillSet2);
        finalPayload.add(secondJsonObject);
        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(finalPayload)
                .get();
    }
}
