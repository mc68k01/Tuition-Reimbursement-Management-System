package repositories;

import models.Department;
import models.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class DepartmentRepoHBImpl implements DepartmentRepo{
    @Override
    public Department getDepartment(int id) {
        Session session = HibernateUtil.getSession();
        Department dept = null;
        try {
            dept = session.get(Department.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return dept;
    }

    @Override
    public List<Department> getAllDepartments() {
        Session session = HibernateUtil.getSession();
        List<Department> depts = null;
        try {
            depts = session.createQuery("FROM Department").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return depts;
    }

    @Override
    public Department addDepartment(Department dept) {

        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            dept.setDeptId((int)session.save(dept));
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
            return null;
        } finally {
            session.close();
        }
        return dept;
    }

    @Override
    public Department updateDepartment(Department dept) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(dept);
            tx.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
            return null;
        } finally {
            session.close();
        }
        return dept;
    }
}
