package com.dao;

import com.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.util.List;

public class UserDAO extends DAO {

    public User createUser(String username, int age, boolean status)
            throws Exception {
        try {
            begin();
            User user = new User(username, age, status);
            getSession().save(user);
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not create user " + username, e);
        }
    }

    public User retrieveUser(String username) throws Exception {
        try {
            begin();
            Query q = getSession().createQuery("from User where name = :username");
            q.setString("username", username);
            User user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get user " + username, e);
        }
    }

    public void deleteUser( User user ) throws Exception {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not delete user " + user.getName(), e);
        }
    }

    public List<User> allUsers() throws Exception {
        try {
            begin();
            List<User> users = getSession().createQuery("from User").list();
            return users;
        }catch (HibernateException e){
            rollback();
            throw new Exception("Could not get category list", e);
        }
    }
}
