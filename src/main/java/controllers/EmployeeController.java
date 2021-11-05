package controllers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.javalin.core.security.BasicAuthCredentials;
import models.Employee;
import io.javalin.http.Handler;
import org.eclipse.jetty.http.HttpStatus;
import services.EmployeeService;

import java.util.List;

public class EmployeeController {

    
    EmployeeService es;
    Gson gson = new Gson();

    public EmployeeController(EmployeeService es) {this.es =es;}

    public Handler getAllEmployees = (context) -> {

        List<Employee> employeeList = es.getAllEmployees();

        if(employeeList != null) {
            context.result(gson.toJson(employeeList));
        } else {
            context.result("[]");
        }
    };

    public Handler getEmployeeAndPwdOld = (context) -> {
        String usernameIn = context.pathParam("usr");
        String passwordIn = context.pathParam("pwd");
        String empUser = "";
        List<Employee> employeeList = es.getAllEmployees();
        System.out.println(usernameIn);
        System.out.println(passwordIn);
        for (Employee emp : employeeList){
            System.out.println(emp.getEmpUsrName());
            System.out.println(emp.getEmpPassword());
            if (usernameIn.equals(emp.getEmpUsrName()) && passwordIn.equals(emp.getEmpPassword()))
            {
                // login success
                System.out.println("login success!!");
                System.out.println(emp.getEmpUsrName());
                empUser = emp.getEmpUsrName();
                context.json(gson.toJson(emp));

            } else {
                // login failure
                context.result("[]");
            }

        }
    };

    public Handler getEmployeeAndPwd = (context) -> {
//        String usernameIn = context.pathParam("usr");
//        String passwordIn = context.pathParam("pwd");
        List<Employee> employeeList = es.getAllEmployees();

        if (!context.basicAuthCredentialsExist()) {
            context.status(HttpStatus.NOT_FOUND_404);
            return;
        }
        BasicAuthCredentials creds = context.basicAuthCredentials();
        String username = creds.getUsername();
        String password = creds.getPassword();

        for (Employee emp : employeeList) {
            if (employeeList != null && username.equals(emp.getEmpUsrName()) && password.equals(emp.getEmpPassword())) {
                System.out.println("LOGGED IN");
                //Employee emp2 = emp;
                String[] credents = new String[2];
                credents[0] = username;
                credents[1] = password;
                context.status(200);
            } else {
                // login failure
                context.result("[]");
            }
        }
    };


        public Handler getEmployeeById = (context) -> {
            String input = context.pathParam("id");
            int id;
            try {
                id = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                id = -1;
            }
            Employee dept = es.getEmployee(id);
            if (dept != null) {
                context.result(gson.toJson(dept));
            } else {
                context.status(400);
            }
        };

    public Handler getEmployeeByUser = (context) -> {
        String input = context.pathParam("user");
        String user=null;
        try {
            user = input;
        } catch (NullPointerException  e) {
            e.printStackTrace();
        }
        Employee empl = es.getEmployeeByUser(user);
        if (empl != null) {
            context.result(gson.toJson(empl));
        } else {
            context.status(400);
        }
    };


        public Handler addEmployee = (context) -> {
            Employee emp = gson.fromJson(context.body(), Employee.class);
            emp = es.addEmployee(emp);
            context.result((emp != null) ? gson.toJson(emp) : "{}");

        };

        public Handler updateEmployee = (context) -> {
            int id = Integer.parseInt(context.pathParam("id"));
            Employee emp = gson.fromJson(context.body(), Employee.class);

            //Should probably validate
            emp.setEmpId(id);

            emp = es.updateEmployee(emp);
            context.result((emp != null) ? gson.toJson(emp) : "{}");
        };

        public Handler deleteEmployee = (ctx) -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Employee deptHead = es.deleteEmployee(id);
            ctx.result((deptHead != null) ? gson.toJson(deptHead) : "{}");
        };


}
