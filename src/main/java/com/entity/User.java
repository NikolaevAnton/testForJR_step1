package com.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user")
public class User {

    private long id;
    private String name;
    private int age;
    private boolean status;
    private long date;

    public User() {
    }

    public User(String name, int age, boolean status) {
        this.name = name;
        this.age = age;
        this.status = status;
        this.date = new Date().getTime();
    }

    @Column(unique=true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Id
    @GeneratedValue
    protected long getId() {
        return id;
    }

    protected void setId(long id) {
        this.id = id;
    }
}
