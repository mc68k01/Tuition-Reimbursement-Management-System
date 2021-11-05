package controllers;
import io.javalin.http.Handler;
import com.google.gson.Gson;
import models.Department;
import models.Employee;
import services.DepartmentService;

import java.util.List;

public class DepartmentController {

    DepartmentService ds;
    Gson gson = new Gson();

    public DepartmentController(DepartmentService ds) {this.ds = ds;}

    public Handler getAllDepartments = (context) -> {

        List<Department> depts = ds.getAllDepartments();

        if(depts != null) {
            context.result(gson.toJson(depts));
        } else {
            context.result("[]");
        }
    };


    public Handler getDeptById = (context) -> {
        String input = context.pathParam("id");
        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            id = -1;
        }
        Department dept = ds.getDepartment(id);
        if(dept != null) {
            context.result(gson.toJson(dept));
        } else {
            context.status(400);
        }
    };

    public Handler addDept = (context) -> {
        Department dept = gson.fromJson(context.body(), Department.class);
        dept = ds.addDepartment(dept);
        context.result((dept != null) ? gson.toJson(dept) : "{}");

    };



    public Handler updateDepartment = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        Department dept = gson.fromJson(context.body(), Department.class);

        //Should probably validate
        dept.setDeptId(id);

        dept = ds.updateDepartment(dept);
        context.result((dept!= null) ? gson.toJson(dept) : "{}");
    };

//    public Handler deleteDepartment = (ctx) -> {
//        int id = Integer.parseInt(ctx.pathParam("id"));
//        Department dept = ds.deleteDepartment(id);
//        ctx.result((dept != null) ? gson.toJson(dept) : "{}");
//    };


}
