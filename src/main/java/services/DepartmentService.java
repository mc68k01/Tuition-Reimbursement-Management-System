package services;
import models.Department;
import java.util.List;

public interface DepartmentService {
    public Department getDepartment(int id);
    public List<Department> getAllDepartments();
    public Department addDepartment(Department dept);
    public Department updateDepartment(Department dept);
}
