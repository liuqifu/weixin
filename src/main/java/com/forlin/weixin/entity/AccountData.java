package com.forlin.weixin.entity;

import javax.persistence.*;

/**
 * Created by admin on 2016/3/23.
 */
@Entity
@Table(name = "t_wxcms_account_data")
@Cacheable(value = false)
public class AccountData {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    private Integer drinkNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getDrinkNum() {
        return drinkNum;
    }

    public void setDrinkNum(Integer drinkNum) {
        this.drinkNum = drinkNum;
    }
}
