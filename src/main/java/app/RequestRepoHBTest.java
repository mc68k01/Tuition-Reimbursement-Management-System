package app;

import models.Request;
import repositories.RequestRepo;
import repositories.RequestRepoHBImpl;

import java.math.BigDecimal;

public class RequestRepoHBTest {

    public static void main (String[] args) {
        RequestRepo rr = new RequestRepoHBImpl();
        System.out.println(rr.getAllRequest());

        Request req =new Request();

        req = rr.getRequest(1);
//        req.setFormId();
//        req.setRequesterId();
//        req.setRequesterName();
//        req.setRequesterDept();
//        req.setRequesterSuper();

        req.setReasonForRequest("I want to make a change!");
        req.setAmountRequested(BigDecimal.valueOf(1000.00));
        req.setTimeMissedFromWork("75 business days");
        req.setPreApproved(true);
        req.setRequestStatus(8);
        req.setDateEscalated(1634820613407L);
        req.setGradingFormatId(2);
        req.setEventType(1);
        req.setEventAttachments("drive.google.com");
        req.setEventDate(1634820633407L);
        req.setEventLocation("Beckley, WV");
        req.setEventDescription("some whoopin' in the mind");

        req = rr.updateRequest(req);

        System.out.println(req);

        Request req2 = new Request();
//        req.setFormId();
//        req.setRequesterId();
//        req.setRequesterName();
//        req.setRequesterDept();
//        req.setRequesterSuper();

        req2.setFormId(2);
        req2.setRequesterId(3);
        req2.setRequesterDept("QC");
        req2.setReasonForRequest("Stop the Confederales");
        req2.setAmountRequested(BigDecimal.valueOf(1000.00));
        req2.setTimeMissedFromWork("5 business days");
        req2.setPreApproved(true);
        req2.setRequestStatus(8);
        req2.setDateEscalated(1634820613407L);
        req2.setGradingFormatId(3);
        req2.setEventType(1);
        req2.setEventAttachments("drive.google.com");
        req2.setEventDate(1634820633407L);
        req2.setEventLocation("Beckley, WV");
        req2.setEventDescription("Build that nitro");

        req2 = rr.addRequest(req2);

        System.out.println(req2);

//        req.setFormId();
//        req.setRequesterId();
//        req.setRequesterName();
//        req.setRequesterDept();
//        req.setRequesterSuper();
//
//        req.setReasonForRequest();
//        req.setAmountRequested();
//        req.setTimeMissedFromWork();
//        req.setPreApproved();
//        req.setRequestStatus();
//        req.setDateEscalated();
//        req.setGradingFormatId();
//        req.setEventType();
//        req.setEventAttachments();
//        req.setEventDate();
//        req.setEventLocation();
//        req.setEventDescription();
    }
}
