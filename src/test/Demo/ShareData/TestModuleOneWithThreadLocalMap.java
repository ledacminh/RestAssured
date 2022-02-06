package ShareData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestModuleOneWithThreadLocalMap {
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
        ThreadLocalDataStoreAsMap.setValue(Constant.BOOKING_ID, bookingid);
        System.out.println("ThreadId ----- > " + Thread.currentThread().getId() + "Create booking Id --> " + ThreadLocalDataStoreAsMap.getValue(Constant.BOOKING_ID));
    }
    @Test(priority = 2)
    public void retrieBoooking(){
        System.out.println("Hello" + ThreadLocalDataStoreAsMap.getValue(Constant.BOOKING_ID));
        int bookingid = (int)ThreadLocalDataStoreAsMap.getValue(Constant.BOOKING_ID);
        Response response = RestAssured
                .given()
                .log()
                .all()
                .get("https://restful-booker.herokuapp.com/booking/"+ bookingid)
                .then().log().all().extract().response();
    }

}
