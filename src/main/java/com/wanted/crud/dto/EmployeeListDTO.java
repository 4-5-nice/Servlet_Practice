package com.wanted.crud.dto;

public class EmployeeListDTO {

    //사번
    private String empId;
    //사원명
    private String empName;
    //이메일
    private String email;
    //전화번호
    private String phone;
    //부서명
    private String deptTitle;
    //직급명
    private String jobName;
    //급여
    private long salary;
    //재직상태
    private String entYn;

    public EmployeeListDTO(){}

    public EmployeeListDTO(String empId, String empName, String email, String phone, String deptTitle, String jobName, long salary, String entYn) {
        this.empId = empId;
        this.empName = empName;
        this.email = email;
        this.phone = phone;
        this.deptTitle = deptTitle;
        this.jobName = jobName;
        this.salary = salary;
        this.entYn = entYn;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeptTitle() {
        return deptTitle;
    }

    public void setDeptTitle(String deptTitle) {
        this.deptTitle = deptTitle;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getEntYn() {
        return entYn;
    }

    public void setEntYn(String entYn) {
        this.entYn = entYn;
    }

    @Override
    public String toString() {
        return "EmployeeListDTO{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", deptTitle='" + deptTitle + '\'' +
                ", jobName='" + jobName + '\'' +
                ", salary=" + salary +
                ", entYn='" + entYn + '\'' +
                '}';
    }
}
