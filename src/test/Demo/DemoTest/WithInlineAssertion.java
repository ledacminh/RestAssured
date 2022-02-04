package DemoTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class WithInlineAssertion {
    public static void main(String[] args) {
       String jsonResponse =  RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .body("{\n" +
                        "    \"username\" : \"admin\",\n" +
                        "    \"password\" : \"password123\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .post()
                .then()
                .extract()
                .asString();
        JsonPath jsonPath = new JsonPath(jsonResponse);
        Assert.assertNotNull(jsonPath.get("token"));
    }
}
