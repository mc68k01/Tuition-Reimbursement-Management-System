package repositories;

import models.Department;

import java.util.List;

public interface DepartmentRepo {
    public Department getDepartment(int id);
    public List<Department> getAllDepartments();
    public Department addDepartment(Department dept);
    public Department updateDepartment(Department dept);
}
