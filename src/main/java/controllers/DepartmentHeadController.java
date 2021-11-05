package controllers;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import models.Department;
import models.DepartmentHead;
import services.DepartmentHeadService;
import services.DepartmentHeadServiceImpl;
import services.DepartmentService;

import java.util.List;

public class DepartmentHeadController {
    DepartmentHeadService dhs;
    Gson gson = new Gson();

    public DepartmentHeadController(DepartmentHeadService dhs) {this.dhs = dhs;}

    public Handler getAllDepartmentHeads = (context) -> {

        List<DepartmentHead> depts = dhs.getAllDepartmentHeads();

        if(depts != null) {
            context.result(gson.toJson(depts));
        } else {
            context.result("[]");
        }
    };

    public Handler getDeptHeadById = (context) -> {
        String input = context.pathParam("id");
        int id;
        try {
            id = Integer.parseInt(input);
            System.out.println(id);

        } catch (NumberFormatException e) {
            id = -1;
        }
        DepartmentHead dept = dhs.getDeptHead(id);
        if(dept != null) {
            context.result(gson.toJson(dept));
        } else {
            context.status(400);
        }
    };

    public Handler addDeptHead = (context) -> {
        DepartmentHead dept = gson.fromJson(context.body(), DepartmentHead.class);
        dept = dhs.addDepartmentHead(dept);
        context.result((dept != null) ? gson.toJson(dept) : "{}");

    };

    public Handler updateDepartmentHead = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        DepartmentHead deptHead = gson.fromJson(context.body(), DepartmentHead.class);
        //System.out.println(deptHead.getHead_id());
        //Should probably validate
        //deptHead.setHead_id(id);
        dhs.deleteDepartmentHead(id);
        deptHead = dhs.addDepartmentHead(deptHead);
        context.result((deptHead!= null) ? gson.toJson(deptHead) : "{}");
    };

    public Handler deleteDepartmentHead = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        DepartmentHead deptHead = dhs.deleteDepartmentHead(id);
        ctx.result((deptHead != null) ? gson.toJson(deptHead) : "{}");
    };
}
