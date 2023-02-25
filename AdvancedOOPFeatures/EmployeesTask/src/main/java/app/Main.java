package app;

import java.time.ZoneId;
import java.util.List;
import java.time.Instant;
import java.util.Comparator;
public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = EmployeeUtils.loadStaffFromFile(STAFF_TXT);

        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year
        return staff.stream()
                .filter(employee -> employee.getWorkStart().getYear() == year)
                .max(Comparator.comparingInt(Employee::getSalary))
                //.max((e1, e2) -> e1.getSalary().compareTo(e2.getSalary())) //Вариант решения от скиллбокса
                .get();
    }
}