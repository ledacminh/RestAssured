package Jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import java.util.List;
import java.util.Map;
@JsonIncludeProperties(value = {"name","age"})
public class Employee {
    private String name;
    private int age;
    private boolean married;
    private String address;
    private String mobileN0;

    public List<String> getSkillsSet() {
        return skillsSet;
    }

    public void setSkillsSet(List<String> skillsSet) {
        this.skillsSet = skillsSet;
    }

    public Map<String, String> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(Map<String, String> familyMembers) {
        this.familyMembers = familyMembers;
    }

    private List<String> skillsSet;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String > familyMembers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileN0() {
        return mobileN0;
    }

    public void setMobileN0(String mobileN0) {
        this.mobileN0 = mobileN0;
    }
}
