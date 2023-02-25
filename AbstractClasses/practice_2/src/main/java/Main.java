import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] Args){
        Company company = new Company("Рога и Копыта");
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 180; i++) {
            Employee newEmployee = new Operator("Operator " + i);
            employees.add(newEmployee);
        }
        for (int i = 0; i < 80; i++) {
            Employee newEmployee = new Manager("Manager " + i);
            employees.add(newEmployee);
        }
        for (int i = 0; i < 10; i++) {
            Employee newEmployee = new TopManager("Top Manager " + i);
            employees.add(newEmployee);
        }

        company.hireAll(employees);

        List<Employee> topSalaryStaff = company.getTopSalaryStaff(15);
        System.out.println("ТОП 15 высоких ЗП");
        for (Employee item:topSalaryStaff) {
            System.out.println(item.getMonthSalary());
        }

        List<Employee> lowestSalaryStaff = company.getLowestSalaryStaff(30);
        System.out.println("ТОП 30 низких ЗП");
        for (Employee item:lowestSalaryStaff) {
            System.out.println(item.getMonthSalary());
        }

        for (int i = company.employees.size()-1; i > 0; i -= 2) {
            company.fire(company.employees.get(i));
        }
        System.out.println("50 % штата уволено");
        topSalaryStaff = company.getTopSalaryStaff(15);
        System.out.println("ТОП 15 высоких ЗП после сокращения штата");
        for (Employee item:topSalaryStaff) {
            System.out.println(item.getMonthSalary());
        }
        lowestSalaryStaff = company.getLowestSalaryStaff(30);
        System.out.println("ТОП 30 низких ЗП после сокращения штата");
        for (Employee item:lowestSalaryStaff) {
            System.out.println(item.getMonthSalary());
        }
        /*System.out.println(company.employees.size());
        company.employees.stream().forEach(System.out::println);*/

    }
}
