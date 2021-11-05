package controllers;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import logging.MyLogger;
import models.Employee;
import models.GradingStructure;
import services.GradingStructureService;

import java.util.List;

public class GradingStructureController {

    GradingStructureService gss;
    Gson gson = new Gson();

    public GradingStructureController(GradingStructureService gss) {this.gss =gss;}


    public Handler getAllGradingStructures = (context) -> {

        List<GradingStructure> gradingStructures = gss.getAllGradingStructures();
        MyLogger.logger.info(gradingStructures);
        if(gradingStructures != null) {
            context.result(gson.toJson(gradingStructures));
        } else {
            context.result("[]");
        }
    };



    public Handler getGradingStructure = (context) -> {
        String input = context.pathParam("id");
        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            id = -1;
        }
        GradingStructure gradeStruct = gss.getGradingStructure(id);
        if(gradeStruct != null) {
            context.result(gson.toJson(gradeStruct));
        } else {
            context.status(400);
        }
    };

    public Handler addGradingStructure = (context) -> {
        GradingStructure gradeStruct = gson.fromJson(context.body(), GradingStructure.class);
        System.out.println("GradingStruct INBOUND");
        System.out.println(gradeStruct);
        gradeStruct = gss.addGradingStructure(gradeStruct);
        context.result((gradeStruct != null) ? gson.toJson(gradeStruct) : "{}");

    };

    public Handler updateGradingStructure = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        GradingStructure gradeStruct = gson.fromJson(context.body(), GradingStructure.class);

        //Should probably validate
        gradeStruct.setGradingFormatId(id);

        gradeStruct = gss.updateGradingStructure(gradeStruct);
        context.result((gradeStruct!= null) ? gson.toJson(gradeStruct) : "{}");
    };

    public Handler deleteGradingStructure = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        GradingStructure gradeStruct = gss.deleteGradingStructure(id);
        ctx.result((gradeStruct != null) ? gson.toJson(gradeStruct) : "{}");
    };
}
