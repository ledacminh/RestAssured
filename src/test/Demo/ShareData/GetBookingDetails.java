package ShareData;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetBookingDetails {
    @Test
    public void getBookingDetails(ITestContext context){
        Response response = RestAssured
                .given()
                .log()
                .all()
                .get("https://restful-booker.herokuapp.com/booking/"+ context.getAttribute("bookingid"))
                .then().log().all().extract().response();

    }
}
