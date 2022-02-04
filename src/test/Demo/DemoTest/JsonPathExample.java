package DemoTest;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class JsonPathExample {
    @Test
    public void jsonPathOnline(){
        String json = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        JsonPath jsonPath = new JsonPath(json);
        String userName = jsonPath.getString("username");
        System.out.println("UserName is "+ userName);
        System.out.println((Object) jsonPath.get("$"));

    }

}
