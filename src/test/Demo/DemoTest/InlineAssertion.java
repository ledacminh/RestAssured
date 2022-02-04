package DemoTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.testng.Assert;

public class InlineAssertion {
    public static void main(String[] args) {
      RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .log()
                .all()
                .body("bookingid", Matchers.hasItems(9,10));


    }
}
