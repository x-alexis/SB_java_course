import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    List<Employee> employees = new ArrayList<>();
    private final String name;
    private double income = 0.00d;
    public Company(String name) {
        this.name = name;
    }
    public void hire(Employee employee){
        employee.setCompany(this);
        employees.add(employee);
        employee.setSalary();
        if(employee instanceof Manager || employee instanceof TopManager){
            for (Employee item: employees) {
                if (item instanceof TopManager){
                    ((TopManager) item).recalculateBonus(this.getIncome());
                }
            }
        }
        System.out.println("Сотрудник " + employee.getName() + " принят, установлена ЗП " + employee.getMonthSalary());
    }

     public void hireAll(List<Employee> employeeList){
        for (Employee item: employeeList) {
            hire(item);
        }
        System.out.println("Групповая обработка закончена");
    }

    public void fire(Employee employee){
        employees.remove(employee);
        if (employee instanceof Manager){
            for (Employee item : employees) {
                if (item instanceof TopManager){
                    ((TopManager) item).recalculateBonus(this.getIncome());
                }
            }
        }
    }
    protected double getIncome() {
        for (Employee item: employees) {
            if (item instanceof Manager){
                income += item.getProfit();
            }
        }
        return income;
    }
    public List<Employee> getTopSalaryStaff(int count)
    {
        if (count > employees.size()){
            count = employees.size() - 1;
        }
        Collections.sort(employees, Collections.reverseOrder());
        return employees.subList(0, count);
    }
    public List<Employee> getLowestSalaryStaff(int count)
    {
        if (count > employees.size()){
            count = employees.size();
        }
        Collections.sort(employees);
        return employees.subList(0, count);
    }
    /* вариант без расширения интерфейса
    public List<Employee> getTopSalaryStaff(int count)
    {
        Collections.sort(employees, new Comparator<Employee>()
        {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o2.getMonthSalary() - o1.getMonthSalary());
            }
        });
        return employees.subList(0, count);
    }*/


}
