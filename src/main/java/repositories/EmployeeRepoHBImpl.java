package repositories;

import models.Employee;
import util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;
import java.util.List;

public class EmployeeRepoHBImpl implements EmployeeRepo{
    @Override
    public Employee getEmployee(int id) {
        Session session = HibernateUtil.getSession();
        Employee emp = null;
        try {
            emp = session.get(Employee.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return emp;
    }

    @Override
    public Employee getEmployeeByUser(String username) {
        Session session = HibernateUtil.getSession();
        Employee emp = null;
        try {
            Criteria cr = session.createCriteria(Employee.class);
            cr.add(Restrictions.eq("empUsrName", username));
//            cr.setFirstResult(1);
            List<Employee> results = cr.list();
            emp = results.get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return emp;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session session = HibernateUtil.getSession();
        List<Employee> emps = null;
        try {
            emps = session.createQuery("FROM Employee").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return emps;
    }

    @Override
    public Employee addEmployee(Employee emp){

        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            emp.setEmpId((int)session.save(emp));
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
            return null;
        } finally {
            session.close();
        }

        return emp;
    }

    @Override
    public Employee updateEmployee(Employee emp) {

        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(emp);
            tx.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
            return null;
        } finally {
            session.close();
        }

        return emp;
    }


    @Override
    public Employee deleteEmployee(int id){

        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        Employee terminated = null;

        try {
            tx = session.beginTransaction();
            terminated = session.get(Employee.class, id);
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
