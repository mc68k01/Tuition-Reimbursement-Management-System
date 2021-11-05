package services;

import models.DepartmentHead;
import models.Employee;

import java.util.List;

public interface DepartmentHeadService {
    
    public DepartmentHead getDeptHead(int id);
    public List<DepartmentHead> getAllDepartmentHeads();
    public DepartmentHead addDepartmentHead(DepartmentHead newDeptHead);
    public DepartmentHead updateDepartmentHead(DepartmentHead update);
    public DepartmentHead deleteDepartmentHead(int id);


    }
