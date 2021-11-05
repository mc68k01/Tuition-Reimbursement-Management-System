package app;

import repositories.ReimbursementStatusRepo;
import repositories.ReimbursementStatusRepoHBImpl;
import services.ReimbursementStatusService;

public class ReimbursementStatusRepoHBTest {

    public static void main(String[] args) {
        ReimbursementStatusRepo rsr = new ReimbursementStatusRepoHBImpl();
        System.out.println(rsr.getAllReimbursementStatuses());


    }
}
