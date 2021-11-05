package repositories;
import models.Employee;
import java.util.List;

public interface EmployeeRepo {

    public Employee getEmployee(int id);
    public Employee getEmployeeByUser(String username);
    public List<Employee> getAllEmployees();
    public Employee addEmployee(Employee emp);
    public Employee updateEmployee(Employee emp);
    public Employee deleteEmployee(int id);

}
