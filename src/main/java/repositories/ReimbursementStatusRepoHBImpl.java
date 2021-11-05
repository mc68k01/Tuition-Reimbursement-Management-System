package repositories;

import models.Employee;
import models.ReimbursementStatus;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class ReimbursementStatusRepoHBImpl implements ReimbursementStatusRepo{
    @Override
    public List<ReimbursementStatus> getAllReimbursementStatuses() {
        Session session = HibernateUtil.getSession();
        List<ReimbursementStatus> statuses = null;
        try {
            statuses = session.createQuery("FROM ReimbursementStatus").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return statuses;
    }

    @Override
    public ReimbursementStatus getReimbursementStatusById(int id) {
        Session session = HibernateUtil.getSession();
        ReimbursementStatus status = null;
        try {
            status = session.get(ReimbursementStatus.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return status;
    }

    @Override
    public ReimbursementStatus addReimbursementStatus(ReimbursementStatus newStatus) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            newStatus.setStatusId((int)session.save(newStatus));
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
            return null;
        } finally {
            session.close();
        }

        return newStatus;
    }

    @Override
    public ReimbursementStatus updateReimbursementStatus(ReimbursementStatus update) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(update);
            tx.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
            return null;
        } finally {
            session.close();
        }

        return update;
    }

    @Override
    public ReimbursementStatus deleteReimbursementStatus(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        ReimbursementStatus terminated = null;

        try {
            tx = session.beginTransaction();
            terminated = session.get(ReimbursementStatus.class, id);
            session.delete(terminated);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
            terminated = null;
        } finally {
            session.close();
        }
        return terminated;
    }
}
