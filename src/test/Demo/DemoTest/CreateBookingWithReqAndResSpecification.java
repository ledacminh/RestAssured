package DemoTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

public class CreateBookingWithReqAndResSpecification {
    public static void main(String[] args) {
        RequestSpecification requestSpecification;
        ResponseSpecification responseSpecification = RestAssured.expect();
        requestSpecification = RestAssured.given();
        requestSpecification.log().all();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.body("{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.contentType(ContentType.JSON);
        responseSpecification.statusCode(200);
        responseSpecification.contentType(ContentType.JSON);
        responseSpecification.time(Matchers.lessThan(3000L));
        //Setup Request
        RestAssured
                .given(requestSpecification,responseSpecification)

                //Hit request
                .post()
                .then()
                .log()
                .all()
                //Validate the response
                .spec(responseSpecification);

    }
}
