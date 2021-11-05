package repositories;

import models.DepartmentHead;
import models.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class DepartmentHeadRepoHBImpl implements DepartmentHeadRepo{
    @Override
    public DepartmentHead getDeptHead(int id) {
        Session session = HibernateUtil.getSession();
        DepartmentHead dhead = null;
        try {
            dhead = session.get(DepartmentHead.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return dhead;    }

    @Override
    public List<DepartmentHead> getAllDepartmentHeads() {
        Session session = HibernateUtil.getSession();
        List<DepartmentHead> dheads = null;
        try {
            dheads = session.createQuery("FROM DepartmentHead").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return dheads;
    }

    @Override
    public DepartmentHead addDepartmentHead(DepartmentHead newDeptHead) {

        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            newDeptHead.setHead_id((int)session.save(newDeptHead));
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
            return null;
        } finally {
            session.close();
        }

        return newDeptHead;
    }

    @Override
    public DepartmentHead updateDepartmentHead(DepartmentHead update) {

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
    public DepartmentHead deleteDepartmentHead(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        DepartmentHead terminated = null;
        try {
            tx = session.beginTransaction();
            terminated = session.get(DepartmentHead.class, id);
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
