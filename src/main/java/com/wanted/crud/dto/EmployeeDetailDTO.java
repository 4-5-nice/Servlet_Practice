package com.wanted.crud.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeDetailDTO {
    private String empId;
    private String name;
    private String email;
    private String phone;
    private String dept_code;
    private String dept_title;
    private String job_code;
    private String job_name;
    private Integer salary;
    private String hire_date;
    private String ent_yn;

    public EmployeeDetailDTO() {}

    public EmployeeDetailDTO(String empId, String name, String email, String phone, String dept_code, String dept_title, String job_code, String job_name, Integer salary, String hire_date, String ent_yn) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dept_code = dept_code;
        this.dept_title = dept_title;
        this.job_code = job_code;
        this.job_name = job_name;
        this.salary = salary;
        this.hire_date = hire_date;
        this.ent_yn = ent_yn;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDept_code() {
        return dept_code;
    }

    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
    }

    public String getDept_title() {
        return dept_title;
    }

    public void setDept_title(String dept_title) {
        this.dept_title = dept_title;
    }

    public String getJob_code() {
        return job_code;
    }

    public void setJob_code(String job_code) {
        this.job_code = job_code;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public String getEnt_yn() {
        return ent_yn;
    }

    public void setEnt_yn(String ent_yn) {
        this.ent_yn = ent_yn;
    }

    @Override
    public String toString() {
        return "EmployeeDetailDTO{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dept_code='" + dept_code + '\'' +
                ", dept_title='" + dept_title + '\'' +
                ", job_code='" + job_code + '\'' +
                ", job_name='" + job_name + '\'' +
                ", salary=" + salary +
                ", hire_date='" + hire_date + '\'' +
                ", ent_yn='" + ent_yn + '\'' +
                '}';
    }
}
