package com.forlin.weixin.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by admin on 2016/3/23.
 */
@Entity
@Table(name = "t_wxcms_account")
@Cacheable(value = false)
public class Account {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String account;

    @Column(name = "appId")
    private String appId;

    @Column(name = "appsecret")
    private String appSecret;

    private String url;

    private String token;

    private Integer msgCount;

    private LocalDateTime createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(Integer msgCount) {
        this.msgCount = msgCount;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
