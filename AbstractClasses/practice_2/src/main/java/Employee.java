public interface Employee extends Comparable<Employee>{
    Double getMonthSalary();
    String getName();
    void setCompany(Company company);
    void setSalary();
    double getProfit();

    @Override
    default int compareTo(Employee employee){
        return getMonthSalary().compareTo(employee.getMonthSalary());
    }
}
