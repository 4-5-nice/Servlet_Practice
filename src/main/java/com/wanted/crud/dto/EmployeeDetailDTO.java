package com.wanted.crud.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeDetailDTO {
    private String EMP_ID;
    private String EMP_NAME;
    private String EMAIL;
    private String PHONE;
    private String DEPT_CODE;
    private String DEPT_TITLE;
    private String JOB_CODE;
    private String JOB_NAME;
    private Integer SALARY;
    private String HIRE_DATE;
    private String ENT_YN;

    public EmployeeDetailDTO() {}

    public EmployeeDetailDTO(String EMP_ID, String EMP_NAME, String EMAIL, String PHONE, String DEPT_CODE, String DEPT_TITLE, String JOB_CODE, String JOB_NAME, Integer SALARY, String HIRE_DATE, String ENT_YN) {
        this.EMP_ID = EMP_ID;
        this.EMP_NAME = EMP_NAME;
        this.EMAIL = EMAIL;
        this.PHONE = PHONE;
        this.DEPT_CODE = DEPT_CODE;
        this.DEPT_TITLE = DEPT_TITLE;
        this.JOB_CODE = JOB_CODE;
        this.JOB_NAME = JOB_NAME;
        this.SALARY = SALARY;
        this.HIRE_DATE = HIRE_DATE;
        this.ENT_YN = ENT_YN;
    }

    public String getEMP_ID() {
        return EMP_ID;
    }

    public void setEMP_ID(String EMP_ID) {
        this.EMP_ID = EMP_ID;
    }

    public String getEMP_NAME() {
        return EMP_NAME;
    }

    public void setEMP_NAME(String EMP_NAME) {
        this.EMP_NAME = EMP_NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getDEPT_CODE() {
        return DEPT_CODE;
    }

    public void setDEPT_CODE(String DEPT_CODE) {
        this.DEPT_CODE = DEPT_CODE;
    }

    public String getDEPT_TITLE() {
        return DEPT_TITLE;
    }

    public void setDEPT_TITLE(String DEPT_TITLE) {
        this.DEPT_TITLE = DEPT_TITLE;
    }

    public String getJOB_CODE() {
        return JOB_CODE;
    }

    public void setJOB_CODE(String JOB_CODE) {
        this.JOB_CODE = JOB_CODE;
    }

    public String getJOB_NAME() {
        return JOB_NAME;
    }

    public void setJOB_NAME(String JOB_NAME) {
        this.JOB_NAME = JOB_NAME;
    }

    public Integer getSALARY() {
        return SALARY;
    }

    public void setSALARY(Integer SALARY) {
        this.SALARY = SALARY;
    }

    public String getHIRE_DATE() {
        return HIRE_DATE;
    }

    public void setHIRE_DATE(String HIRE_DATE) {
        this.HIRE_DATE = HIRE_DATE;
    }

    public String getENT_YN() {
        return ENT_YN;
    }

    public void setENT_YN(String ENT_YN) {
        this.ENT_YN = ENT_YN;
    }

    @Override
    public String toString() {
        return "EmployeeDetailDTO{" +
                "EMP_ID='" + EMP_ID + '\'' +
                ", EMP_NAME='" + EMP_NAME + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                ", PHONE='" + PHONE + '\'' +
                ", DEPT_CODE='" + DEPT_CODE + '\'' +
                ", DEPT_TITLE='" + DEPT_TITLE + '\'' +
                ", JOB_CODE='" + JOB_CODE + '\'' +
                ", JOB_NAME='" + JOB_NAME + '\'' +
                ", SALARY=" + SALARY +
                ", HIRE_DATE=" + HIRE_DATE +
                ", ENT_YN='" + ENT_YN + '\'' +
                '}';
    }
}
