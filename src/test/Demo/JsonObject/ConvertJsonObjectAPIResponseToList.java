package JsonObject;

import io.restassured.RestAssured;

import java.util.List;
import java.util.Map;

public class ConvertJsonObjectAPIResponseToList {
    public static void main(String[] args) {
        List<Object> list = RestAssured
                .get("https://run.mocky.io/v3/d6668ab3-55a0-4eb5-8a4a-cd1d768e8837")
                .as(List.class);
        System.out.println(list.size());
        Map<String,Object> amp1 = (Map<String, Object>) list.get(0);
        System.out.println(amp1.get("firstname"));
    }
}
