package com.food.kart.foodkart.service;


import com.food.kart.foodkart.dao.UserDao;
import com.food.kart.foodkart.enums.Gender;
import com.food.kart.foodkart.model.User;

import java.util.Objects;

public class FoodKartUserServiceImpl implements FoodKartUserService {

    UserDao userDao;

    public FoodKartUserServiceImpl() {
        this.userDao = UserDao.getInstance();
    }

    @Override
    public void registerUser(String name, String gender, String phoneNumber, String pinCode) {
        User user = new User(name, Objects.equals(gender.toLowerCase(), "male") ? Gender.MALE : Gender.FEMALE, phoneNumber,
            pinCode);
        userDao.addUser(user);
    }

    @Override
    public boolean loginUser(String userId) {
        User user = userDao.getUser(userId);
        if (user != null) {
            userDao.setCurrentLoginUser(user);
            return true;
        }
        return false;
    }
}
