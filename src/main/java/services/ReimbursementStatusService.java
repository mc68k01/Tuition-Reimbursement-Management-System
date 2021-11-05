package services;

import models.ReimbursementStatus;

import java.util.List;

public interface ReimbursementStatusService {

    public List<ReimbursementStatus> getAllReimbursementStatuses();
    public ReimbursementStatus getReimbursementStatusById(int id);
    public ReimbursementStatus addReimbursementStatus(ReimbursementStatus newStatus);
    public ReimbursementStatus updateReimbursementStatus(ReimbursementStatus update);
    public ReimbursementStatus deleteReimbursementStatus(int id);

}
