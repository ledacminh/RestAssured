package ShareData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ShareDataFromOneAIToAnotherAPIAmongMethodWithMap {
    @Test(priority = 1)
    public void createBooking(){
        //Setup Request
        int bookingid = RestAssured
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
        DataStoreAsMap.setValue("bookingid", bookingid);
    }
    @Test(priority = 2)
    public void retrieBoooking(){
        int bookingid = (int)DataStoreAsMap.getValue("bookingid");
        Response response = RestAssured
                .given()
                .log()
                .all()
                .get("https://restful-booker.herokuapp.com/booking/"+ bookingid)
                .then().log().all().extract().response();
    }

}
