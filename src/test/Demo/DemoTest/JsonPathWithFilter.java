package DemoTest;

import io.restassured.path.json.JsonPath;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class JsonPathWithFilter {
    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\Demo\\DemoTest\\exampleJson.json";
        File jsonArrayFile = new File(filePath);
        JsonPath jsonPath = new JsonPath(jsonArrayFile);
        System.out.println(jsonPath.getString("[0].firstname"));
        List<String> listFisrtName = jsonPath.getList("firstname");
        System.out.println(listFisrtName);
        List<String> list1 = jsonPath.getList("findAll{it.totalprice == 112}.firstname");
        System.out.println("FindAll " + list1);


    }

}
