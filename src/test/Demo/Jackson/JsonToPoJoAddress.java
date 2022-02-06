package Jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JsonToPoJoAddress {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Map<String,Object>> allAddress = objectMapper.readValue(new File("C:\\WorkSpace\\LearningRest_Assured\\src\\test\\Demo\\Jackson\\data.json"), new TypeReference<List<Map<String, Object>>>() {});
            System.out.println(allAddress.get(0).get("city"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
