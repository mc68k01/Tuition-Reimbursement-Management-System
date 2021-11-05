package repositories;

import models.GradingStructure;
import models.Request;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class GradingStructureRepoHBImpl implements GradingStructureRepo{


    @Override
    public GradingStructure getGradingStructure(int id) {
        Session session = HibernateUtil.getSession();
        GradingStructure gradingStructure = null;
        try {
            gradingStructure = session.get(GradingStructure.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return gradingStructure;
    }

    @Override
    public List<GradingStructure> getAllGradingStructures() {
        Session session = HibernateUtil.getSession();
        List<GradingStructure> gradingStructures = null;
        try {
            gradingStructures = session.createQuery("FROM GradingStructure").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return gradingStructures;
    }

    @Override
    public GradingStructure addGradingStructure(GradingStructure newGradingStructure) {

        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            newGradingStructure.setGradingFormatId((int)session.save(newGradingStructure));
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
            return null;
        } finally {
            session.close();
        }

        return newGradingStructure;
    }

    @Override
    public GradingStructure updateGradingStructure(GradingStructure modifications) {

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
    public GradingStructure deleteGradingStructure(int id) {

        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        GradingStructure req = null;

        try {
            tx = session.beginTransaction();
            req = session.get(GradingStructure.class, id);
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
