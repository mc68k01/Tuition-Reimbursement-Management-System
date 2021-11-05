package services;

import models.Employee;
import repositories.EmployeeRepo;

import java.util.List;


public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepo er;

    public EmployeeServiceImpl(EmployeeRepo er) {this.er=er;}

    @Override
    public Employee getEmployee(int id) {
        return er.getEmployee(id);
    }

    @Override
    public Employee getEmployeeByUser(String username) {return er.getEmployeeByUser(username);}

    @Override
    public List<Employee> getAllEmployees() {
        return er.getAllEmployees();
    }

    @Override
    public Employee addEmployee(Employee emp) {
        return er.addEmployee(emp);
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        return er.updateEmployee(emp);
    }

    @Override
    public Employee deleteEmployee(int id) {
        return er.deleteEmployee(id);
    }
}
