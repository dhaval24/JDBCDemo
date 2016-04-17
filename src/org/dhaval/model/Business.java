package org.dhaval.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;

/**
 * Created by Dhaval on 4/16/2016.
 */
@Component
@Entity
public class Business extends Occupation {

    public int getRevenuePerAnnum() {
        return revenuePerAnnum;
    }

    public void setRevenuePerAnnum(int revenuePerAnnum) {
        this.revenuePerAnnum = revenuePerAnnum;
    }

    private int revenuePerAnnum;
}
