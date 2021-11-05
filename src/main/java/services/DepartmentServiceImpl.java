package services;

import models.Department;
import repositories.DepartmentRepo;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService{

    DepartmentRepo dr;

    public DepartmentServiceImpl(DepartmentRepo dr) {
        this.dr = dr;
    }

    @Override
    public Department getDepartment(int id) {
        return dr.getDepartment(id);
    }

    @Override
    public List<Department> getAllDepartments() {
        return dr.getAllDepartments();
    }

    @Override
    public Department addDepartment(Department dept) {
        return dr.addDepartment(dept);
    }

    @Override
    public Department updateDepartment(Department dept) {
        return dr.updateDepartment(dept);
    }
}
