package POJO;
import io.restassured.RestAssured;
import java.util.Arrays;
import java.util.List;

public class ConvertMockyResponse {
    public static void main(String[] args) {
        Address[] allAddress =  RestAssured.get("https://run.mocky.io/v3/1eb5ef22-7124-4899-93a3-41d6061ce5f7")
                .jsonPath()
                        .getObject("address", Address[].class);
        List<Address> list = Arrays.asList(allAddress);
        System.out.println(list.get(0).getHouseNo());
        System.out.println(list.get(1).getHouseNo());

    }
}
