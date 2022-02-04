package DemoTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteBooking {
    public static void main(String[] args) {
       String response =  RestAssured
                .given()
                     .log()
                     .all()
                     .baseUri("https://restful-booker.herokuapp.com/")
                     .basePath("booking")
                     .body("{\n" +
                        "    \"firstname\" : \"Jim\",\n" +
                        "    \"lastname\" : \"Brown\",\n" +
                        "    \"totalprice\" : 111,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                     .contentType(ContentType.JSON)
                .when()
                //Hit request
                     .post()
                .then()
                     .log()
                     .all()
                     .extract()
                     .body()
                     .asString();
        System.out.println(response);

    }

}
