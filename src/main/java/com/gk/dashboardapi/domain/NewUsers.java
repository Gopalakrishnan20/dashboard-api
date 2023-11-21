package com.gk.dashboardapi.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "new_users")
public class NewUsers {

    @Id
    private String id;

    @Column(name = "picture")
    private String picture;

    @Column(name = "name")
    private String name;

    @Column(name = "isActive")
    private Boolean isActive;

    @Column(name = "country")
    private String country;

    @Column(name = "progress")
    private Integer progress;

    public NewUsers(String id, String picture, String name, Boolean isActive, String country, Integer progress) {
        this.id = id;
        this.picture = picture;
        this.name = name;
        this.isActive = isActive;
        this.country = country;
        this.progress = progress;
    }

    public NewUsers() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "NewUsers{" +
                "id='" + id + '\'' +
                ", picture='" + picture + '\'' +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", country='" + country + '\'' +
                ", progress=" + progress +
                '}';
    }
}
