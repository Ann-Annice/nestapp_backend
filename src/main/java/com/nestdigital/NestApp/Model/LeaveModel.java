package com.nestdigital.NestApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leaverecord")
public class LeaveModel {
    @Id
    @GeneratedValue

    private int id;
    private String emp_code;
    private String reason;
    private String required_date;
    private String leave_duration;
    private String leave_status;

    public LeaveModel(int id, String emp_code, String reason, String required_date, String leave_duration, String leave_status) {

        this.id = id;
        this.emp_code = emp_code;
        this.reason = reason;
        this.required_date = required_date;
        this.leave_duration = leave_duration;
        this.leave_status = leave_status;
    }

    public LeaveModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmp_code() {
        return emp_code;
    }

    public void setEmp_code(String emp_code) {
        this.emp_code = emp_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRequired_date() {
        return required_date;
    }

    public void setRequired_date(String required_date) {
        this.required_date = required_date;
    }

    public String getLeave_duration() {
        return leave_duration;
    }

    public void setLeave_duration(String leave_duration) {
        this.leave_duration = leave_duration;
    }

    public String getLeave_status() {
        return leave_status;
    }

    public void setLeave_status(String leave_status) {
        this.leave_status = leave_status;
    }
}
