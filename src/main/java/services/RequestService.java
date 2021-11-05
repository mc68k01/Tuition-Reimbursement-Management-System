package services;
import models.Request;
import java.util.List;

public interface RequestService {
    public Request getRequest(int id);
    public List<Request> getAllRequests();
    public List<Request> getRequestsByEmp(int id);
    public List<Request> getRequestsByStatus(int id);
    public List<Request> getRequestsBySuperId(int id);
    public Request addRequest(Request request);
    public Request updateRequest(Request update);
    public Request deleteRequest(int id);

}
