package repositories;
import models.DepartmentHead;
import java.util.List;

public interface DepartmentHeadRepo {

        public DepartmentHead getDeptHead(int id);
        public List<DepartmentHead> getAllDepartmentHeads();
        public DepartmentHead addDepartmentHead(DepartmentHead newDeptHead);
        public DepartmentHead updateDepartmentHead(DepartmentHead update);
        public DepartmentHead deleteDepartmentHead(int id);
}
