package repositories;
import models.Employee;
import models.Request;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.util.List;

public class RequestRepoHBImpl implements RequestRepo{
    @Override
    public Request getRequest(int id) {
        Session session = HibernateUtil.getSession();
        Request request = null;
        try {
            request = session.get(Request.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return request;
    }

    @Override
    public List<Request> getAllRequest() {
        Session session = HibernateUtil.getSession();
        List<Request> requests = null;
        try {
            requests = session.createQuery("FROM Request").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return requests;
    }

    @Override
    public List<Request> getRequestsByEmp(int id) {
        Session session = HibernateUtil.getSession();
        List<Request> requests = null;
        try {
            Criteria cr = session.createCriteria(Request.class);
            cr.add(Restrictions.eq("requesterId", id));
            requests = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return requests;
    }

    @Override
    public List<Request> getRequestsByStatus(int id) {
        Session session = HibernateUtil.getSession();
        List<Request> requests = null;
        try {
            Criteria cr = session.createCriteria(Request.class);
            cr.add(Restrictions.eq("requestStatus", id));
            requests = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return requests;
    }

    @Override
    public List<Request> getRequestsBySuperId(int id) {
        Session session = HibernateUtil.getSession();
        List<Request> requests = null;
        try {
            Criteria cr = session.createCriteria(Request.class);
            cr.add(Restrictions.eq("requesterSuper", id));
            requests = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return requests;
    }

    @Override
    public Request addRequest(Request newRequest) {

        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        System.out.println("New REQUEST inBOUND!!!");
        System.out.println(newRequest);
        try {
            tx = session.beginTransaction();
            newRequest.setFormId((int)session.save(newRequest));
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
            return null;
        } finally {
            session.close();
        }

        return newRequest;
    }

    @Override
    public Request updateRequest(Request modifications) {

        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(modifications);
            tx.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
            return null;
        } finally {
            session.close();
        }

        return modifications;
    }

        @Override
        public Request deleteRequest ( int id){

            Session session = HibernateUtil.getSession();
            Transaction tx = null;
            Request req = null;

            try {
                tx = session.beginTransaction();
                req = session.get(Request.class, id);
                session.delete(req);
                tx.commit();
            } catch (HibernateException e) {
                e.printStackTrace();
                if (tx != null) tx.rollback();
                req = null;
            } finally {
                session.close();
            }
            return req;
    }
}
