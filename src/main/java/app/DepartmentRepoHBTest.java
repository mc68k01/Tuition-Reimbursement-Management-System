package app;


import models.Department;
import repositories.DepartmentRepo;
import repositories.DepartmentRepoHBImpl;

public class DepartmentRepoHBTest {
    public static void main(String[] args){
        DepartmentRepo dr = new DepartmentRepoHBImpl();
        Department dept = new Department(6, "QC");
        Department update = new Department(3, "Serac");
        dr.addDepartment(dept);
        dr.updateDepartment(update);
        System.out.println(dr.getAllDepartments());
        Department update1 = new Department(3, "Sales");
        dr.updateDepartment(update1);
        System.out.println(dr.getAllDepartments());
    }

}
