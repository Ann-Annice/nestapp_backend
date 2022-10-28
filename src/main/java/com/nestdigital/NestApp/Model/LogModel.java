package com.nestdigital.NestApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "logs")
public class LogModel {

    @Id
    @GeneratedValue
    private int id;
    private String emp_code;
    private int login_sec_id;
    private int logout_sec_id;
    private String login_time;
    private String logout_time;

    public LogModel(int id, String emp_code, int login_sec_id, int logout_sec_id, String login_time, String logout_time) {
        this.id = id;
        this.emp_code = emp_code;
        this.login_sec_id = login_sec_id;
        this.logout_sec_id = logout_sec_id;
        this.login_time = login_time;
        this.logout_time = logout_time;
    }

    public LogModel() {
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

    public int getLogin_sec_id() {
        return login_sec_id;
    }

    public void setLogin_sec_id(int login_sec_id) {
        this.login_sec_id = login_sec_id;
    }

    public int getLogout_sec_id() {
        return logout_sec_id;
    }

    public void setLogout_sec_id(int logout_sec_id) {
        this.logout_sec_id = logout_sec_id;
    }

    public String getLogin_time() {
        return login_time;
    }

    public void setLogin_time(String login_time) {
        this.login_time = login_time;
    }

    public String getLogout_time() {
        return logout_time;
    }

    public void setLogout_time(String logout_time) {
        this.logout_time = logout_time;
    }
}
