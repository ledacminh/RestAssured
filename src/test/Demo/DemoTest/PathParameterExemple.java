package DemoTest;

import io.restassured.RestAssured;

import java.util.HashMap;
import java.util.Map;

public class PathParameterExemple {
    public static void main(String[] args) {
        Map<String, Object> pathParameter = new HashMap<>();
        pathParameter.put("basePath","booking");
        pathParameter.put("bookingId",2);
        RestAssured
                .given()
                     .log()
                     .all()
                     .baseUri("https://restful-booker.herokuapp.com/")
                     .basePath("{basePath}/{bookingId}")
                     .pathParam("basePath","booking")
                     .pathParam("bookingId","1")
                .when()
                     .get()
                .then()
                     .log().all();

    }
}
