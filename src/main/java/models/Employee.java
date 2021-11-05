package models;

import org.hibernate.annotations.Type;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emp_id")
    private int empId;

    //--sup_id int,
    @Column(name="emp_name")
    private String empName;

    @Column(name="emp_dept_id")
    private int empDeptId;

    @Column(name="emp_usr_name")
    private String empUsrName;

    @Column(name="emp_password")
    private String empPassword;

    @Column(name="emp_email")
    private String empEmail;

    @Column(name="emp_phone")
    private String empPhone;

    @Column(name="emp_salary")
    private BigDecimal empSalary;

    @Column(name="emp_benefits_package")
    private int empBenefitsPackage;

    @Column(name="emp_401k_enrollment", nullable=false)
    private boolean emp401kEnrollment;

    @Column(name="emp_start_date")
    private long empStartDate;

    @Column(name="emp_super_id")
    private int empSuperId;

    @Column(name="emp_ben_co", nullable=false)
    private boolean empBenCo;


    public Employee() {
    }

    public Employee(int empId, String empName, int empDeptId, String empUsrName, String empPassword,
                    String empEmail, String empPhone, BigDecimal empSalary, int empBenefitsPackage,
                    boolean emp401kEnrollment, long empStartDate, int empSuperId, boolean empBenCo) {
        this.empId = empId;
        this.empName = empName;
        this.empDeptId = empDeptId;
        this.empUsrName = empUsrName;
        this.empPassword = empPassword;
        this.empEmail = empEmail;
        this.empPhone = empPhone;
        this.empSalary = empSalary;
        this.empBenefitsPackage = empBenefitsPackage;
        this.emp401kEnrollment = emp401kEnrollment;
        this.empStartDate = empStartDate;
        this.empSuperId = empSuperId;
        this.empBenCo = empBenCo;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpDeptId() {
        return empDeptId;
    }

    public void setEmpDeptId(int empDeptId) {
        this.empDeptId = empDeptId;
    }

    public String getEmpUsrName() {
        return empUsrName;
    }

    public void setEmpUsrName(String empUsrName) {
        this.empUsrName = empUsrName;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public BigDecimal getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(BigDecimal empSalary) {
        this.empSalary = empSalary;
    }

    public int getEmpBenefitsPackage() {
        return empBenefitsPackage;
    }

    public void setEmpBenefitsPackage(int empBenefitsPackage) {
        this.empBenefitsPackage = empBenefitsPackage;
    }

    public boolean isEmp401kEnrollment() {
        return emp401kEnrollment;
    }

    public void setEmp401kEnrollment(boolean emp401kEnrollment) {
        this.emp401kEnrollment = emp401kEnrollment;
    }

    public long getEmpStartDate() {
        return empStartDate;
    }

    public void setEmpStartDate(int empStartDate) {
        this.empStartDate = empStartDate;
    }

    public int getEmpSuperId() {
        return empSuperId;
    }

    public void setEmpSuperId(int empSuperId) {
        this.empSuperId = empSuperId;
    }

    public boolean isEmpBenCo() {
        return empBenCo;
    }

    public void setEmpBenCo(boolean empBenCo) {
        this.empBenCo = empBenCo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empDeptId=" + empDeptId +
                ", empUsrName='" + empUsrName + '\'' +
                ", empPassword='" + empPassword + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empPhone='" + empPhone + '\'' +
                ", empSalary=" + empSalary +
                ", empBenefitsPackage=" + empBenefitsPackage +
                ", emp401kEnrollment=" + emp401kEnrollment +
                ", empStartDate=" + empStartDate +
                ", empSuperId=" + empSuperId +
                ", empBenCo=" + empBenCo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId && empDeptId == employee.empDeptId && empBenefitsPackage == employee.empBenefitsPackage && emp401kEnrollment == employee.emp401kEnrollment && empStartDate == employee.empStartDate && empSuperId == employee.empSuperId && empBenCo == employee.empBenCo && Objects.equals(empName, employee.empName) && Objects.equals(empUsrName, employee.empUsrName) && Objects.equals(empPassword, employee.empPassword) && Objects.equals(empEmail, employee.empEmail) && Objects.equals(empPhone, employee.empPhone) && Objects.deepEquals(empSalary, employee.empSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, empDeptId, empUsrName, empPassword, empEmail, empPhone, empSalary, empBenefitsPackage, emp401kEnrollment, empStartDate, empSuperId, empBenCo);
    }
}
