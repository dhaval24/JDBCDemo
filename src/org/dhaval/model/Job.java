package org.dhaval.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;

/**
 * Created by Dhaval on 4/16/2016.
 */
@Component
@Entity
public class Job extends Occupation {

    private int salaryPerAnnum;

    public int getSalaryPerAnnum() {
        return salaryPerAnnum;

    }

    public void setSalaryPerAnnum(int salaryPerAnnum) {
        this.salaryPerAnnum = salaryPerAnnum;
    }
}
