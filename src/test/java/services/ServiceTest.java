package services;

import models.*;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import repositories.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTest {

        DepartmentHeadRepoHBImpl dhr = new DepartmentHeadRepoHBImpl();
        DepartmentHeadService dhs = new DepartmentHeadServiceImpl(dhr);

        DepartmentRepo dr = new DepartmentRepoHBImpl();
        DepartmentService ds = new DepartmentServiceImpl(dr);

        EmployeeRepo er = new EmployeeRepoHBImpl();
        EmployeeService es = new EmployeeServiceImpl(er);

        GradingStructureRepo gsr = new GradingStructureRepoHBImpl();
        GradingStructureService gss = new GradingStructureServiceImpl(gsr);

        RequestRepo rr = new RequestRepoHBImpl();
        RequestService rs = new RequestServiceImpl(rr);

        ReimbursementStatusRepo rsr = new ReimbursementStatusRepoHBImpl();
        ReimbursementStatusService rss = new ReimbursementStatusServiceImpl(rsr);
        @Test
        void getAllDepartmentHeads() {
            List<DepartmentHead> actual = dhs.getAllDepartmentHeads();
            List<DepartmentHead> expected = new ArrayList<>();
            DepartmentHead acct1 = new DepartmentHead(1,1);
            DepartmentHead acct2 = new DepartmentHead(2,2);
            DepartmentHead acct3 = new DepartmentHead(3,3);
            DepartmentHead acct4 = new DepartmentHead(4,4);
            DepartmentHead acct5 = new DepartmentHead(5,5);
            expected.add(acct1);
            expected.add(acct2);
            expected.add(acct3);
            expected.add(acct4);
            expected.add(acct5);
            Assert.assertEquals(actual, expected);
        }

//        @Test
//        void getAllDepartmentHeadsException() {
//            List<DepartmentHead> actual = dhs.getAllDepartmentHeads();
//            List<DepartmentHead> expected = new ArrayList<>();
//            DepartmentHead acct1 = new DepartmentHead(1,1);
//            DepartmentHead acct2 = new DepartmentHead(2,2);
//            DepartmentHead acct3 = new DepartmentHead(3,3);
//            DepartmentHead acct4 = new DepartmentHead(4,4);
//            DepartmentHead acct5 = new DepartmentHead(5,5);
//            expected.add(acct1);
//            expected.add(acct2);
//            expected.add(acct3);
//            expected.add(acct4);
//            expected.add(acct5);
//            Assert.assertEquals(actual, expected);
//        }
        @Test
        void getDeptHead() {
            DepartmentHead actual = dhs.getDeptHead(1);
            DepartmentHead expected = new DepartmentHead(1, 1);
            assertEquals(expected, actual);
        }

        @Test
        void addDepartmentHead(){
            DepartmentHead anew = new DepartmentHead(3,3);
            DepartmentHead actual = dhs.getDeptHead(3);
            assertEquals(anew, actual);
        }

        @Test
        void updateDepartmentHead(){
            DepartmentHead test = new DepartmentHead(3,4);
            DepartmentHead actual = dhs.updateDepartmentHead(test);
            Assert.assertEquals(test, actual);
            DepartmentHead fix = new DepartmentHead(4,3);
            dhs.updateDepartmentHead(fix);
        }
        
        @Test
        void deleteDepartmentHead() {
            DepartmentHead test = new DepartmentHead(5, 5);
            DepartmentHead actual = dhs.deleteDepartmentHead(5);
            Assert.assertEquals(actual, test);
            DepartmentHead fix = new DepartmentHead(5,5);
            dhs.addDepartmentHead(fix);
        }

    @Test
    void getDepartment() {
        Department actual = ds.getDepartment(1);
        Department expected = new Department(1, "Human Resources");
        assertEquals(expected, actual);
    }

    @Test
    void getAllDepartments() {
        List<Department> actual = ds.getAllDepartments();
        List<Department> expected = new ArrayList<>();
        Department dept1 = new Department(1,"Human Resources");
        Department dept2 = new Department(2,"Payroll");
        Department dept3 = new Department(3,"Sales");
        Department dept4 = new Department(4,"Support");
        Department dept5 = new Department(5,"Trading");
        expected.add(dept1);
        expected.add(dept2);
        expected.add(dept3);
        expected.add(dept4);
        expected.add(dept5);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void addDepartment(){
        Department anew = new Department(6,"Park Services");
        Department actual = ds.addDepartment(anew);
        assertEquals(anew, actual);
    }

    @Test
    void updateDepartment() {
        Department test = new Department(4,"War World");
        Department actual = ds.updateDepartment(test);
        Assert.assertEquals(test, actual);
    }

    @Test
    void getEmployee(){
        Employee actual = es.getEmployee(1);
        Employee test = new Employee(1,"William",5,"william", "william", "william@company.net", "410-455-8431", BigDecimal.valueOf(45.00), 1, true, 1634820612507L, 1, false);
        Assert.assertEquals(actual, test);
    }

    @Test
    void getEmployeeByUser() {
        Employee actual = es.getEmployeeByUser("blowe");
        System.out.println(actual);
        Employee expected = new Employee(2,"Bernard Lowe",2,"blowe","blowe","blowe@company.net","410-455-8432",BigDecimal.valueOf(45.00),1,true,1634820612607L,2,false);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getAllEmployees() {
        List<Employee> actual = es.getAllEmployees();
        List<Employee> expected = new ArrayList<>();
        Employee emp1 = new Employee(1,"William",5,"william","william","william@company.net","410-455-8431",BigDecimal.valueOf(45.00),1,true,1634820612507L,1,false);
        Employee emp2 = new Employee(2,"Bernard Lowe",2,"blowe","blowe","blowe@company.net","410-455-8432",BigDecimal.valueOf(45.00),1,true,1634820612607L,2,false);
        Employee emp3 = new Employee(3,"Elsie Hughes",3,"ehughes","ehughes","ehughes@company.net","410-455-8433",BigDecimal.valueOf(45.00),1,true,1634820612707L,2,false);
        Employee emp4 = new Employee(4,"Theresa Cullen",5,"tcullen","tcullen","tcullen@company.net","410-455-8434",BigDecimal.valueOf(45.00),1,true,1634820612807L,3,false);
        Employee emp5 = new Employee(5,"Armistice",4,"armistice","armistice","armistice@company.net","410-455-8435",BigDecimal.valueOf(45.00),1,true,1634820612907L,7,false);
        Employee emp6 = new Employee(6,"Clementine Pennyfeather",5,"cpennyfeather","cpennyfeather","cpennyfeather@company.net","410-455-8436",BigDecimal.valueOf(45.00),1,true,1634820613007L,7,false);
        Employee emp7 = new Employee(7,"Maeve Millay",2,"mmillay","mmillay","mmillay@company.net","410-455-8437",BigDecimal.valueOf(45.00),1,true,1634820613107L,7,false);
        Employee emp8 = new Employee(8,"Dolores Abernathy",1,"dabernathy","dabernathy","dabernathy@company.net","410-455-8438",BigDecimal.valueOf(45.00),1,true,1634820613207L,7,true);
        Employee emp9 = new Employee(9,"Man in Black",3,"mblack","mblack","mblack@company.net","410-455-8439",BigDecimal.valueOf(45.00),1,true,1634820613307L,7,false);
        Employee emp10 = new Employee(10,"Logan",4,"logan","logan","logan@company.net","410-455-8440",BigDecimal.valueOf(45.00),1,true,1634820613307L,7,false);
        Employee emp11 = new Employee(11,"Lawrence",5,"Lawrence","Lawrence","Lawrence@company.net","410-455-8441",BigDecimal.valueOf(45.00),1,true,1634820613407L,7,false);
        expected.add(emp1);
        expected.add(emp2);
        expected.add(emp3);
        expected.add(emp4);
        expected.add(emp5);
        expected.add(emp6);
        expected.add(emp7);
        expected.add(emp8);
        expected.add(emp9);
        expected.add(emp10);
        expected.add(emp11);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void addEmployee() {
        Employee expected = new Employee(12,"Lawrence",5,"Lawrence","Lawrence","Lawrence@company.net","410-455-8441",BigDecimal.valueOf(45.00),1,true,1634820613407L,7,false);
        Employee actual = es.addEmployee(expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void updateEmployee() {
        Employee expected = new Employee(12,"Michael",5,"Lawrence","Lawrence","Lawrence@company.net","410-455-8441",BigDecimal.valueOf(45.00),1,true,1634820613407L,7,false);
        Employee actual = es.updateEmployee(expected);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void deleteEmployee() {
        Employee actual = new Employee(12,"Michael",5,"Lawrence","Lawrence","Lawrence@company.net","410-455-8441",BigDecimal.valueOf(45.00),1,true,1634820613407L,7,false);
        Employee expected = es.deleteEmployee(12);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void getGradingStructure() {
        GradingStructure actual = gss.getGradingStructure(1);
        GradingStructure expected = new GradingStructure(1, "Percentage", true, BigDecimal.valueOf(84.9));
        Assert.assertEquals(actual, expected);
//        org.junit.Assert.assertSame(actual,expected);
    }
    @Test
    void getAllGradingStructures() {
         List<GradingStructure> expected = new ArrayList<>();
         List<GradingStructure> actual = gss.getAllGradingStructures();
         GradingStructure gs1 = new GradingStructure(1,"Percentage",true,BigDecimal.valueOf(84.9));
         GradingStructure gs2 = new GradingStructure(2,"Pass/Fail",false,BigDecimal.valueOf(50.0));
         GradingStructure gs3 = new GradingStructure(3,"FinalExam",true,BigDecimal.valueOf(99.9));
         expected.add(gs1);
         expected.add(gs2);
         expected.add(gs3);
         Assert.assertEquals(expected, actual);
    }

    @Test
    void addGradingStructure() {
        GradingStructure actual = new GradingStructure(4,"Points",true,BigDecimal.valueOf(92.9));
        GradingStructure expected = gss.addGradingStructure(actual);
        assertEquals(actual,expected);
    }

    @Test
    void updateGradingStructure() {
        GradingStructure actual = new GradingStructure(4,"Points",true,BigDecimal.valueOf(96.9));
        GradingStructure expected = gss.updateGradingStructure(actual);
        assertEquals(actual, expected);
    }

    @Test
    void deleteGradingStructure () {
        GradingStructure actual = new GradingStructure(4,"Points",true,BigDecimal.valueOf(96.9));
        GradingStructure expected = gss.deleteGradingStructure(4);
        assertEquals(actual, expected);
    }

    @Test
    void getRequest() {
        Request actual = rs.getRequest(1);
        Request expected = new Request(1,1,"Bernard Lowe","2",2,"to learn about the Maze",BigDecimal.valueOf(599.99),"3 months",false,1,1634820613407L,1,1,"n/a",1635671914701L,"B, WV","What is the Maze?");
        assertEquals(actual, expected);
    }

    @Test
    void getAllRequests(){
        List<Request> actual = rs.getAllRequests();
        List<Request> expected = new ArrayList<>();
        Request req1 = new Request(1,1,"Bernard Lowe","2",2,"to learn about the Maze",BigDecimal.valueOf(599.99),"3 months",false,1,1634820613407L,1,1,"n/a",1635671914701L,"B, WV","What is the Maze?");
        Request req2 = new Request(2,2,"William","2",2,"to learn about the Maze",BigDecimal.valueOf(1599.99),"4 months",false,1,1634820613407L,2,1,"n/a",1635369512687L,"B, WV","What is the Maze?");
        Request req3 = new Request(3,5,"Dolores","2",2,"to learn about the Maze",BigDecimal.valueOf(2599.99),"12 months",false,1,1634820613407L,3,1,"n/a",1635412713019L,"B, WV","What is the Maze?");
        expected.add(req1);
        expected.add(req2);
        expected.add(req3);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void addRequest(){
        Request actual = new Request(1,1,"Bernard Lowe","2",2,"to learn about the Maze",BigDecimal.valueOf(599.99),"3 months",false,1,1634820613407L,1,1,"n/a",1635671914701L,"B, WV","What is the Maze?");
        Request expected = rs.addRequest(actual);
        assertEquals(actual,expected);
    }

    @Test
    void updateRequest(){
        Request actual = new Request(1,1,"Rob Lowe","2",2,"to learn about the Maze",BigDecimal.valueOf(599.99),"3 months",false,1,1634820613407L,1,1,"n/a",1635671914701L,"B, WV","What is the Maze?");
        Request expected = rs.updateRequest(actual);
        assertEquals(actual, expected);
    }

    @Test
    void deleteRequest(){
        Request actual = new Request(1,1,"Bernard Lowe","2",2,"to learn about the Maze",BigDecimal.valueOf(599.99),"3 months",false,1,1634820613407L,1,1,"n/a",1635671914701L,"B, WV","What is the Maze?");
        ReimbursementStatus reimbursementStatus = rss.deleteReimbursementStatus(1);
        Request expected = rs.deleteRequest(1);
        assertEquals(expected, actual);
    }
}
