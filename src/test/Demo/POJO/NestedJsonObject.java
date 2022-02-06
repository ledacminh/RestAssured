package POJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.ArrayList;
import java.util.List;

public class NestedJsonObject {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setFirstname("John");
        employee1.setLastname("Kendy");
        employee1.setProfession("Music");

        Address address = new Address();
        address.setHouseNo(100);
        address.setStreetName("404 NOt found");
        address.setCity("Ha Noi");
        address.setState("KA");
        address.setCountry("IN");
        // employee1.setAddress(address);
        Address address1 = new Address();
        address1.setHouseNo(100);
        address1.setStreetName("404 NOt found");
        address1.setCity("Ha Noi");
        address1.setState("KA");
        address1.setCountry("IN");
        //employee1.setAddress(address1);
        List<Address> allAddress = new ArrayList<Address>();
        allAddress.add(address);
        allAddress.add(address1);
        employee1.setAddress(allAddress);
        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(employee1)
                .post();

    }
}
