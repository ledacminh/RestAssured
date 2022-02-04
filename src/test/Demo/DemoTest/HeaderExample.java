package DemoTest;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import org.testng.annotations.Test;

public class HeaderExample {
    @Test
    public void defaultBehavior(){

        RestAssured
                .given()
                .header("header1","value1")
                .header("header1","value1")
                .log()
                .all()
                .when()
                .get();


    }
    @Test
    public void overriedHeaderValue(){
        RestAssured
                .given()
                .config(RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName("header1")))
                .config(RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName("header2")))
                .header("header1", "value1")
                .header("header1", "value2")
                .header("header2","value5")
                .header("header2","value6")
                .log()
                .all()
                .when()
                .get();

    }
}
