package app;

import controllers.*;
import logging.MyLogger;
import models.Employee;
import models.ReimbursementStatus;
import org.jetbrains.annotations.NotNull;
import repositories.*;
import services.*;
import util.HibernateUtil;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

public class App {

    public static void main(String[] args) {

        //Establish our Javalin Object
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);

        //Establish the Route/Endpoints that Javalin will manage.
        establishRoutes(app);
        MyLogger.logger.info("Routes started");

        //Run Javalin
        app.stop();
        app.start(7000);
    }

    private static void establishRoutes(Javalin app) {
        //Tell Javalin which routes/endpoints Javalin will manage
        app.get("/hello", (ctx) -> ctx.result("Hello World!"));
        //Establish a route to the 'landing' page.
        app.get("/", (ctx) -> ctx.result("Welcome to Our Movie App"));

//        addRequestRoutes(app);
        addEmployeeRoutes(app);
        addGradingStructureRoutes(app);
        addDepartmentRoutes(app);
        addDeptHeadRoutes(app);
        addReimbursementStatusRoutes(app);
    }



    private static void addEmployeeRoutes(Javalin app) {
        MyLogger.logger.info("in employee route");

        //Again, never Actually skip the Service.
        EmployeeRepo er = new EmployeeRepoHBImpl();
        EmployeeService es = new EmployeeServiceImpl(er);
        EmployeeController ec = new EmployeeController(es);

        RequestRepo rr = new RequestRepoHBImpl();
        RequestService rs = new RequestServiceImpl(rr);
        RequestController rc = new RequestController(rs);

        app.get("requests", rc.getAllRequests);
        app.get("/requests/:id", rc.getRequestById);
        app.post("/requests/", rc.addRequest);
        app.put("/requests/:id", rc.updateRequest);
        app.patch("/requests/:id", rc.updateRequestXHR);
        app.post("/updaterequestbyget/:id", rc.updateRequest);
        app.delete("/requests/:id", rc.deleteRequest);
        app.get("/requests/emp/:emp", rc.getRequestByEmp);
        app.get("/requests/status/:status", rc.getRequestByStatus);
        app.get("/requests/super/:super", rc.getRequestsBySuperId);

         app.get("/user/:usr/pwd/:pwd", ec.getEmployeeAndPwdOld);
        app.get("/login", ec.getEmployeeAndPwd);

        app.get("/employees", ec.getAllEmployees);
        app.post("/employees", ec.addEmployee);
        app.get("/employees/:id", ec.getEmployeeById);
        app.get("/employeebyuser/:user", ec.getEmployeeByUser);
        app.put("/employees/:id", ec.updateEmployee);
        app.delete("/employees/:id", ec.deleteEmployee);
    }

    private static void addGradingStructureRoutes(Javalin app){
        MyLogger.logger.info("in grade structure route");
        GradingStructureRepo gsr = new GradingStructureRepoHBImpl();
        GradingStructureService gss = new GradingStructureServiceImpl(gsr);
        GradingStructureController gssc = new GradingStructureController(gss);
        app.get("/gradingsstructs/", gssc.getAllGradingStructures);
        app.get("/gradingsstructs/:id", gssc.getGradingStructure);
        app.post("/gradingsstructs", gssc.addGradingStructure);
        app.put("/gradingsstructs/:id", gssc.updateGradingStructure);
        app.delete("/gradingsstructs/:id", gssc.deleteGradingStructure);
    }

    private static void addDepartmentRoutes(Javalin app) {
        MyLogger.logger.info("in department route");
        DepartmentRepo dr = new DepartmentRepoHBImpl();
        DepartmentService ds = new DepartmentServiceImpl(dr);
        DepartmentController dc = new DepartmentController(ds);
        app.get("/depts/", dc.getAllDepartments);
        app.get("/depts/:id", dc.getDeptById);
        app.post("/depts", dc.addDept);
        app.put("/depts/:id", dc.updateDepartment);
//        app.delete("/depts/:id", dc.delete);
    }
    private static void addDeptHeadRoutes(@NotNull Javalin app) {
        MyLogger.logger.info("in dept head route");
        DepartmentHeadRepo dhr = new DepartmentHeadRepoHBImpl();
        DepartmentHeadService dhs = new DepartmentHeadServiceImpl(dhr);
        DepartmentHeadController dhc = new DepartmentHeadController(dhs);
        app.get("/deptheads/", dhc.getAllDepartmentHeads);
        app.get("/deptheads/:id", dhc.getDeptHeadById);
        app.post("/deptheads", dhc.addDeptHead);
        app.put("/deptheads/:id", dhc.updateDepartmentHead);
        app.delete("/deptheads/:id", dhc.deleteDepartmentHead);
    }
    private static void addReimbursementStatusRoutes(Javalin app) {
        MyLogger.logger.info("in reimbursment status route");
        ReimbursementStatusRepo rsr = new ReimbursementStatusRepoHBImpl();
        ReimbursementStatusService rss = new ReimbursementStatusServiceImpl(rsr);
        ReimbursementStatusController rsc = new ReimbursementStatusController(rss);
        app.get("/reimbursementstatuses/", rsc.getAllReimbursementStatuses);
        app.get("/reimbursementstatuses/:id", rsc.getReimbursementStatusById);
        app.post("/reimbursementstatuses", rsc.addReimbursementStatus);
        app.put("/reimbursementstatuses/:id", rsc.updateReimbursementStatus);
        app.delete("/reimbursementstatuses/:id", rsc.deleteReimbursementStatus);

    }

}