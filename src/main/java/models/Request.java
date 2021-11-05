package models;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tuition_reimbursement_forms")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_id")
    private int formId;

    @Column(name = "requester_id")
    private int requesterId;

    @Column(name = "requester_name")
    private String requesterName;

    @Column(name = "requester_dept")
    private String requesterDept;

    @Column(name = "requester_super")
    private int requesterSuper;

    @Column(name = "reason_for_request")
    private String reasonForRequest;

    @Column(name = "amount_requested")
    private BigDecimal amountRequested;

    @Column(name = "time_missed_from_work")
    private String timeMissedFromWork;

    @Column(name = "pre_approved", nullable=false)
    private boolean preApproved;

    @Column(name = "request_status")
    private int requestStatus;

    @Column(name = "date_escalated")
    private long dateEscalated;

    @Column(name = "grading_format_id")
    private int gradingFormatId;

    @Column(name = "event_type")
    private int eventType;
    /* event types:
     * 1: University Courses @ 80% reimbursement
     * 2: Seminars @ 60% reimbursement
     * 3: Certification Prep Classes @ 75% reimbursement
     * 4: Certification @ 100% reimbursement
     * 5: Technical Training @ 90% reimbursement
     * 6: Other @ 30% reimbursement
     */
    @Column(name = "event_attachments")
    private String eventAttachments;

    @OrderBy("event_date")
    @Column(name = "event_date")
    private long eventDate;

    @Column(name = "event_location")
    private String eventLocation;

    @Column(name = "event_description")
    private String eventDescription;

    public Request() {
    }

    public Request(int formId, int requesterId, String requesterName, String requesterDept, int requesterSuper,
                   String reasonForRequest, BigDecimal amountRequested, String timeMissedFromWork, boolean preApproved,
                   int requestStatus, long dateEscalated, int gradingFormatId, int eventType, String eventAttachments,
                   long eventDate, String eventLocation, String eventDescription) {
        this.formId = formId;
        this.requesterId = requesterId;
        this.requesterName = requesterName;
        this.requesterDept = requesterDept;
        this.requesterSuper = requesterSuper;
        this.reasonForRequest = reasonForRequest;
        this.amountRequested = amountRequested;
        this.timeMissedFromWork = timeMissedFromWork;
        this.preApproved = preApproved;
        this.requestStatus = requestStatus;
        this.dateEscalated = dateEscalated;
        this.gradingFormatId = gradingFormatId;
        this.eventType = eventType;
        this.eventAttachments = eventAttachments;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public int getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(int requesterId) {
        this.requesterId = requesterId;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public String getRequesterDept() {
        return requesterDept;
    }

    public void setRequesterDept(String requesterDept) {
        this.requesterDept = requesterDept;
    }

    public int getRequesterSuper() {
        return requesterSuper;
    }

    public void setRequesterSuper(int requesterSuper) {
        this.requesterSuper = requesterSuper;
    }

    public String getReasonForRequest() {
        return reasonForRequest;
    }

    public void setReasonForRequest(String reasonForRequest) {
        this.reasonForRequest = reasonForRequest;
    }

    public BigDecimal getAmountRequested() {
        return amountRequested;
    }

    public void setAmountRequested(BigDecimal amountRequested) {
        this.amountRequested = amountRequested;
    }

    public String getTimeMissedFromWork() {
        return timeMissedFromWork;
    }

    public void setTimeMissedFromWork(String timeMissedFromWork) {
        this.timeMissedFromWork = timeMissedFromWork;
    }

    public boolean isPreApproved() {
        return preApproved;
    }

    public void setPreApproved(boolean preApproved) {
        this.preApproved = preApproved;
    }

    public int getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(int requestStatus) {
        this.requestStatus = requestStatus;
    }

    public long getDateEscalated() {
        return dateEscalated;
    }

    public void setDateEscalated(long dateEscalated) {
        this.dateEscalated = dateEscalated;
    }

    public int getGradingFormatId() {
        return gradingFormatId;
    }

    public void setGradingFormatId(int gradingFormatId) {
        this.gradingFormatId = gradingFormatId;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getEventAttachments() {
        return eventAttachments;
    }

    public void setEventAttachments(String eventAttachments) {
        this.eventAttachments = eventAttachments;
    }

    public long getEventDate() {
        return eventDate;
    }

    public void setEventDate(long eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    @Override
    public String toString() {
        return "Requests{" +
                "formId=" + formId +
                ", requesterId=" + requesterId +
                ", requesterName='" + requesterName + '\'' +
                ", requesterDept='" + requesterDept + '\'' +
                ", requesterSuper=" + requesterSuper +
                ", reasonForRequest='" + reasonForRequest + '\'' +
                ", amountRequested=" + amountRequested +
                ", timeMissedFromWork='" + timeMissedFromWork + '\'' +
                ", preApproved=" + preApproved +
                ", requestStatus=" + requestStatus +
                ", dateEscalated=" + dateEscalated +
                ", gradingFormatId=" + gradingFormatId +
                ", eventType=" + eventType +
                ", eventAttachments='" + eventAttachments + '\'' +
                ", eventDate=" + eventDate +
                ", eventLocation='" + eventLocation + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return formId == request.formId && requesterId == request.requesterId && requesterSuper == request.requesterSuper && preApproved == request.preApproved && requestStatus == request.requestStatus && dateEscalated == request.dateEscalated && gradingFormatId == request.gradingFormatId && eventType == request.eventType && eventDate == request.eventDate && Objects.equals(requesterName, request.requesterName) && Objects.equals(requesterDept, request.requesterDept) && Objects.equals(reasonForRequest, request.reasonForRequest) && Objects.equals(amountRequested, request.amountRequested) && Objects.equals(timeMissedFromWork, request.timeMissedFromWork) && Objects.equals(eventAttachments, request.eventAttachments) && Objects.equals(eventLocation, request.eventLocation) && Objects.equals(eventDescription, request.eventDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formId, requesterId, requesterName, requesterDept, requesterSuper, reasonForRequest, amountRequested, timeMissedFromWork, preApproved, requestStatus, dateEscalated, gradingFormatId, eventType, eventAttachments, eventDate, eventLocation, eventDescription);
    }
}
