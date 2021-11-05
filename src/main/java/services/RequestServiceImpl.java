package services;

import models.Request;
import repositories.RequestRepo;

import java.util.List;

public class RequestServiceImpl implements RequestService{

    RequestRepo rr;
    
    public RequestServiceImpl(RequestRepo rr) {this.rr=rr;}

    @Override
    public Request getRequest(int id) {
        return rr.getRequest(id);
    }

    @Override
    public List<Request> getAllRequests() {
        return rr.getAllRequest();
    }
    @Override
    public List<Request> getRequestsByEmp(int id){
        return rr.getRequestsByEmp(id);
    }

    @Override
    public List<Request> getRequestsByStatus(int id) {
        return rr.getRequestsByStatus(id);
    }

    @Override
    public List<Request> getRequestsBySuperId(int id){
        return rr.getRequestsBySuperId(id);
    }

    @Override
    public Request addRequest(Request request) {
        return rr.addRequest(request);
    }

    @Override
    public Request updateRequest(Request update) {
        return rr.updateRequest(update);
    }

    @Override
    public Request deleteRequest(int id) {
        return rr.deleteRequest(id);
    }
}
