package controllers;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import models.ReimbursementStatus;
import services.ReimbursementStatusService;
import java.util.List;

public class ReimbursementStatusController {

    ReimbursementStatusService rss;
    Gson gson = new Gson();
    public ReimbursementStatusController(ReimbursementStatusService rss) {
        this.rss = rss;
    }

    public Handler getAllReimbursementStatuses = (context) -> {

        List<ReimbursementStatus> employeeList = rss.getAllReimbursementStatuses();

        if(employeeList != null) {
            context.result(gson.toJson(employeeList));
        } else {
            context.result("[]");
        }
    };

    public Handler getReimbursementStatusById = (context) -> {
        String input = context.pathParam("id");
        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            id = -1;
        }
        ReimbursementStatus dept = rss.getReimbursementStatusById(id);
        if(dept != null) {
            context.result(gson.toJson(dept));
        } else {
            context.status(400);
        }
    };

    public Handler addReimbursementStatus = (context) -> {
        ReimbursementStatus rStatus = gson.fromJson(context.body(), ReimbursementStatus.class);
        rStatus = rss.addReimbursementStatus(rStatus);
        context.result((rStatus != null) ? gson.toJson(rStatus) : "{}");

    };

    public Handler updateReimbursementStatus = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        ReimbursementStatus rStatus = gson.fromJson(context.body(), ReimbursementStatus.class);

        //Should probably validate
        rStatus.setStatusId(id);

        rStatus = rss.updateReimbursementStatus(rStatus);
        context.result((rStatus!= null) ? gson.toJson(rStatus) : "{}");
    };

    public Handler deleteReimbursementStatus = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        ReimbursementStatus rStatus = rss.deleteReimbursementStatus(id);
        ctx.result((rStatus != null) ? gson.toJson(rStatus) : "{}");
    };

}
