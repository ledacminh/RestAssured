package DemoTest;

import io.restassured.RestAssured;

public class UpdateBookingPATCH {
    public static void main(String[] args) {
        RestAssured
                .given()
                     .log()
                     .all()
                     .baseUri("https://restful-booker.herokuapp.com/")
                     .basePath("booking/1")
                     .header("Content-Type","application/json")
                     .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                     .body("{\n" +
                        "    \"firstname\" : \"Minh\",\n" +
                        "    \"lastname\" : \"Le Dac\"\n" +
                        "}")
                .when()
                     .patch()
                .then()
                     .log().all()
                     .assertThat()
                     .statusCode(200);

    }
}
