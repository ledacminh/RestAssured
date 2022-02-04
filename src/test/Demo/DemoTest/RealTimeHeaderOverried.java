package DemoTest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class RealTimeHeaderOverried {
    @Test
    public void realTimeHeaderOverried(){
        RequestSpecification req1 = RestAssured.given()
                .header("header1","value1");
        RequestSpecification req2 = RestAssured.given()
                .header("header2","value2");
        RestAssured
                .given()
                .spec(req1)
                .spec(req2)
                .log().all()
                .given()
                .get();
    }
}
