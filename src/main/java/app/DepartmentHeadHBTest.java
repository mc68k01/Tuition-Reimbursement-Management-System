package app;

import repositories.DepartmentHeadRepo;
import repositories.DepartmentHeadRepoHBImpl;


public class DepartmentHeadHBTest {
    public static void main(String[] args){
        DepartmentHeadRepo dhr = new DepartmentHeadRepoHBImpl();
        System.out.println(dhr.getDeptHead(2));
        System.out.println(dhr.getAllDepartmentHeads());
    }
}
