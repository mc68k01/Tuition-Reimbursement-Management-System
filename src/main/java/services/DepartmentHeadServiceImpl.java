package services;

import models.DepartmentHead;
import repositories.DepartmentHeadRepo;

import java.util.List;

public class DepartmentHeadServiceImpl implements DepartmentHeadService {

    DepartmentHeadRepo dhr;

    public DepartmentHeadServiceImpl(DepartmentHeadRepo dhr) {
        this.dhr = dhr;
    }

    @Override
    public DepartmentHead getDeptHead(int id) {
        return dhr.getDeptHead(id);
    }

    @Override
    public List<DepartmentHead> getAllDepartmentHeads() {
        return dhr.getAllDepartmentHeads();
    }

    @Override
    public DepartmentHead addDepartmentHead(DepartmentHead newDeptHead) {
        return dhr.addDepartmentHead(newDeptHead);
    }

    @Override
    public DepartmentHead updateDepartmentHead(DepartmentHead update) {
        return dhr.updateDepartmentHead(update);
    }

    @Override
    public DepartmentHead deleteDepartmentHead(int id) {
        return dhr.deleteDepartmentHead(id);
    }
}
