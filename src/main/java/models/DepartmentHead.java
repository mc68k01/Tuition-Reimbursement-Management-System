package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dept_heads")
public class DepartmentHead {

    @Id
//    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "head_id")
    private int head_id; // int primary key references employees(emp_id)

    @Column (name = "head_dept")
    private int deptHeaded;

    public DepartmentHead() {
    }

    public DepartmentHead(int head_id, int deptHeaded) {
        this.head_id = head_id;
        this.deptHeaded = deptHeaded;
    }

    public int getHead_id() {
        return head_id;
    }

    public void setHead_id(int head_id) {
        this.head_id = head_id;
    }

    public int getDeptHeaded() {
        return deptHeaded;
    }

    public void setDeptHeaded(int deptHeaded) {
        this.deptHeaded = deptHeaded;
    }

    @Override
    public String toString() {
        return "DepartmentHead{" +
                "head_id=" + head_id +
                ", deptHeaded=" + deptHeaded +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentHead that = (DepartmentHead) o;
        return head_id == that.head_id && deptHeaded == that.deptHeaded;
    }

    @Override
    public int hashCode() {
        return Objects.hash(head_id, deptHeaded);
    }
}
