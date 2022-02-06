package Jackson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;

public class EmployeeWithAllData {
    public static void main(String[] args) throws JsonProcessingException {
        Employee employee1 = new Employee();
        employee1.setName("Admin1");
        employee1.setAge(0);
        employee1.setMarried(true);
        employee1.setMobileN0("0966152432");
        employee1.setAddress("addd");
        employee1.setSkillsSet(new ArrayList<String>());
        employee1.setFamilyMembers(new HashMap<String, String>());
        ObjectMapper objectMapper = new ObjectMapper();
        String empJosnFomat = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee1);
        System.out.println(empJosnFomat);
    }


}
