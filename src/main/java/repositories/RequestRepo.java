package repositories;
import models.Request;
import java.util.List;

public interface RequestRepo {

    public Request getRequest(int id);
    public List<Request> getAllRequest();
    public List<Request> getRequestsByEmp(int id);
    public List<Request> getRequestsByStatus(int id);
    public List<Request> getRequestsBySuperId(int id);
    public Request addRequest(Request newRequest);
    public Request updateRequest(Request modifications);
    public Request deleteRequest(int id);

}
