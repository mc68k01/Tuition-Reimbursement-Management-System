package app;

import repositories.EmployeeRepo;
import repositories.EmployeeRepoHBImpl;

public class EmployeeRepoHBTest {

    public static void main(String[] args){
        EmployeeRepo er = new EmployeeRepoHBImpl();
        System.out.println(er.getAllEmployees());
    }

}
