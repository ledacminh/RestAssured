package POJO;

import io.restassured.RestAssured;

import java.util.ArrayList;
import java.util.List;

public class DummyAPIForStudent {
    public static void main(String[] args) {
        List<Student> list  = new ArrayList<Student>();
        Student s1 = new Student();
        s1.setAccountNo(10);
        s1.setBalance(23.214);
        s1.setEmail("admin1@gmail.com");
        s1.setFirst_name("John");
        s1.setLast_name("Kendy");
        list.add(s1);
        Student s2 = new Student();
        s2.setAccountNo(10);
        s2.setBalance(200.214);
        s2.setEmail("admin2@gmail.com");
        s2.setFirst_name("John");
        s2.setLast_name("Kendy");
        list.add(s2);
        RestAssured
                .given()
                .log().all()
                .body(list)
                .when()
                .get();


    }
}
