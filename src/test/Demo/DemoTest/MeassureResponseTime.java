package DemoTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;

import java.util.concurrent.TimeUnit;

public class MeassureResponseTime {
    public static void main(String[] args) {
        //Setup Request
       Response response = RestAssured
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
                //Hit request
                .post();
        long responseTimeInMS = response.time();
        System.out.println("responseTimeInMS "+responseTimeInMS);
        long responseTimeInSecond = response.timeIn(TimeUnit.SECONDS);
        System.out.println("responseTimeInSecond "+responseTimeInSecond);
        long responseGettime = response.getTime();
        System.out.println("responseGettime "+responseGettime);
        long responseGettimeIn = response.getTimeIn(TimeUnit.SECONDS);
        System.out.println("responseGettimeIn "+responseGettimeIn);
        response.then().time(Matchers.lessThan(3000L));
        response.then().time(Matchers.both(Matchers.greaterThan(1000L)).and(Matchers.lessThan(5000L)));


    }
}
