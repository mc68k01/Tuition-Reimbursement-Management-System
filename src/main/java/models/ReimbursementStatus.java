package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reimbursement_status")
public class ReimbursementStatus {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "request_id")
    private int statusId;
    @Column (name = "request_status")
    private int requestStatus;
    @Column (name = "request_explanation")
    private String requestExplanation;


    public ReimbursementStatus() {

    }

    public ReimbursementStatus(int statusId, int requestStatus, String requestExplanation) {
        this.statusId = statusId;
        this.requestStatus = requestStatus;
        this.requestExplanation = requestExplanation;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(int requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRequestExplanation() {
        return requestExplanation;
    }

    public void setRequestExplanation(String requestExplanation) {
        this.requestExplanation = requestExplanation;
    }


    @Override
    public String toString() {
        return "RequestStatusCodes{" +
                "statusId=" + statusId +
                ", requestStatus='" + requestStatus + '\'' +
                ", requestExplanation='" + requestExplanation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementStatus that = (ReimbursementStatus) o;
        return statusId == that.statusId && requestStatus == that.requestStatus && Objects.equals(requestExplanation, that.requestExplanation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusId, requestStatus, requestExplanation);
    }
}
