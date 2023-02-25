import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(staff);

        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);

    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        return staff.stream()
                .filter(employee -> employee.getWorkStart().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear() == year)
                .max(Comparator.comparingInt(Employee::getSalary))
                .get();
    }
}