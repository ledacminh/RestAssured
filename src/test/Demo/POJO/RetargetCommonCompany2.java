package POJO;

public class RetargetCommonCompany2 {
    public static void main(String[] args) {
        Employee2 employee1 = new Employee2();
        employee1.setId(10);
        employee1.setDepartmentId(100);
        employee1.setAddress("Bac NInh");
        employee1.setGender("male");
        employee1.setMobileNumber("0966152432");
        Employee2 employee2 = new Employee2();
        employee2.setId(11);
        employee2.setDepartmentId(110);
        employee2.setAddress("Ha NOi");
        employee2.setGender("male");
        employee2.setMobileNumber("0236152432");
        System.out.println(employee1.getId());
        System.out.println(employee2.getId());
    }
}
