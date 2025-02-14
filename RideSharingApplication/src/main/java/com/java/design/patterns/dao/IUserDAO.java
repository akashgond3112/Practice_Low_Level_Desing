package com.java.design.patterns.dao;


import com.java.design.patterns.model.User;

public interface IUserDAO {
    User addUser(String name, String gender, Integer age);
    User getUser(String name);
}
