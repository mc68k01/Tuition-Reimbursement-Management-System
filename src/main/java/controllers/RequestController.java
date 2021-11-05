package controllers;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.javalin.http.Handler;
import models.Employee;
import models.Request;
import services.RequestService;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class RequestController {
    RequestService rs;
    Gson gson = new Gson();

    public RequestController(RequestService rs) {this.rs = rs;}

    public Handler getAllRequests = (context) -> {
        List<Request> requestList  = rs.getAllRequests();

        if (requestList != null) {
            context.result(gson.toJson(requestList));
        } else {
            context.result("[]");
        }
    };


    public Handler getRequestById = (context) -> {
        String input = context.pathParam("id");
        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            id = -1;
        }
        Request request = rs.getRequest(id);
        if(request != null) {
            context.result(gson.toJson(request));
        } else {
            context.status(400);
        }
    };


    public Handler getRequestByEmp = (context) -> {
        String input = context.pathParam("emp");
        int empId = 0;
        try {
            empId = Integer.parseInt(input);;
        } catch (NullPointerException  e) {
            e.printStackTrace();
        }
        List<Request> request = rs.getRequestsByEmp(empId);
        if (request != null) {
            context.result(gson.toJson(request));
        } else {
            context.status(400);
        }
    };


    public Handler getRequestByStatus = (context) -> {
        String input = context.pathParam("status");
        int status = 0;
        try {
            status = Integer.parseInt(input);;
        } catch (NullPointerException  e) {
            e.printStackTrace();
        }
        List<Request> request = rs.getRequestsByStatus(status);
        if (request != null) {
            context.result(gson.toJson(request));
        } else {
            context.status(400);
        }
    };


    public Handler getRequestsBySuperId = (context) -> {
        String input = context.pathParam("super");
        int superID = 0;
        try {
            superID = Integer.parseInt(input);;
        } catch (NullPointerException  e) {
            e.printStackTrace();
        }
        List<Request> request = rs.getRequestsBySuperId(superID);
        if (request != null) {
            context.result(gson.toJson(request));
        } else {
            context.status(400);
        }
    };

    public Handler addRequest = (context) -> {
        Request request = gson.fromJson(context.body(), Request.class);
        System.out.println(request);
        request = rs.addRequest(request);
        context.result((request != null) ? gson.toJson(request) : "{}");
    };

    public Handler updateRequest = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        Request request = gson.fromJson(context.body(), Request.class);

        //Should probably validate
        request.setFormId(id);

        request = rs.updateRequest(request);
        context.result((request!= null) ? gson.toJson(request) : "{}");
    };

    public Handler updateRequestXHR = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        Type collectionType = new TypeToken<List<Request>>(){}.getType();
        java.util.List<Request> request = gson.fromJson(context.body(), collectionType);
//        Request request = gson.fromJson(context.body(), Request.class);
        //Should probably validate
//        request.setFormId(id);
//
        Request req = rs.updateRequest(request.get(id));
        context.result((request!= null) ? gson.toJson(request) : "{}");
    };


    public Handler deleteRequest = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Request request = rs.deleteRequest(id);
        ctx.result((request != null) ? gson.toJson(request) : "{}");
    };
}
