package ShareData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ShareDataFromOneAIToAnotherAPIAmongMethodDataStore {
    private int bookingid = 0;
    @Test(priority = 1)
    public void createBooking(){
        //Setup Request
        bookingid = RestAssured
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
                .post()
                .then()
                .log()
                .all()
                .extract()
                .jsonPath()
                .getInt("bookingid");
        Response response = RestAssured
                .given()
                .log()
                .all()
                .get("https://restful-booker.herokuapp.com/booking/"+ bookingid)
                .then().log().all().extract().response();
    }
    @Test(priority = 2)
    public void retrieBoooking(){
        Response response = RestAssured
                .given()
                .log()
                .all()
                .get("https://restful-booker.herokuapp.com/booking/"+ bookingid)
                .then().log().all().extract().response();
    }

}
