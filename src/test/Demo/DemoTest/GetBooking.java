package DemoTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetBooking {
    public static void main(String[] args) {
        //Build Request
        RestAssured
                .given()
                     .log().all()
                     .baseUri("https://restful-booker.herokuapp.com/")
                     .basePath("booking/{id}")
                     .pathParam("id",1)
                .when()
                //Hit the request and get Response
                     .get()
                .then()
                     .log().all()
                //Validate the response
                     .statusCode(200);



    }


}
