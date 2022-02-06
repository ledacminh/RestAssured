package ShareData;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetBookingDetaiISuite {
    @Test
    public void getBookingDetails(ITestContext context){
        Response response = RestAssured
                .given()
                .log()
                .all()
                .get("https://restful-booker.herokuapp.com/booking/"+ context.getSuite().getAttribute("bookingid"))
                .then().log().all().extract().response();

    }
}
