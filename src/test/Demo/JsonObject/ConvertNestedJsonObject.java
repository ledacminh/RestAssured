package JsonObject;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;

import java.lang.reflect.Type;
import java.util.Map;

public class ConvertNestedJsonObject {
    public static void main(String[] args) {
        Map<String,Object> jsonResponseAsMap = RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .get("https://run.mocky.io/v3/d2b349fb-e063-402d-b116-a771ea14ef29")
                .as(new TypeRef<Map<String,Object>>() {
                    @Override
                    public Type getType() {
                        return super.getType();
                    }
                });
        String bookingDate = (String)jsonResponseAsMap.get("bookingdates.checkin");
        System.out.println(jsonResponseAsMap);
    }
}
