package services;

import models.ReimbursementStatus;
import repositories.ReimbursementStatusRepo;

import java.util.List;

public class ReimbursementStatusServiceImpl implements ReimbursementStatusService{
    
    ReimbursementStatusRepo rsr;

    public ReimbursementStatusServiceImpl(ReimbursementStatusRepo rsr) {
        this.rsr = rsr;
    }

    @Override
    public List<ReimbursementStatus> getAllReimbursementStatuses() {
        return rsr.getAllReimbursementStatuses();
    }

    @Override
    public ReimbursementStatus getReimbursementStatusById(int id) {
        return rsr.getReimbursementStatusById(id);
    }

    @Override
    public ReimbursementStatus addReimbursementStatus(ReimbursementStatus newStatus) {
        return rsr.addReimbursementStatus(newStatus);
    }

    @Override
    public ReimbursementStatus updateReimbursementStatus(ReimbursementStatus update) {
        return rsr.updateReimbursementStatus(update);
    }

    @Override
    public ReimbursementStatus deleteReimbursementStatus(int id) {
        return rsr.deleteReimbursementStatus(id);
    }
}
