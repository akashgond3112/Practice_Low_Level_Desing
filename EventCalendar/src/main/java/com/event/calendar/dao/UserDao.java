package com.event.calendar.dao;

import com.event.calendar.models.Event;
import com.event.calendar.models.Team;
import com.event.calendar.models.TimeSlot;
import com.event.calendar.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private Map<String, User> userMap;

    public UserDao() {
        userMap = new HashMap<>();
    }

    public void addUser(User user) {
        if (userMap.containsKey(user.getName())) {
            throw new RuntimeException("User already exists with same name " + user.getName());
        }
        userMap.put(user.getName(), user);
    }

    public User getUser(String userName) {
        if (!userMap.containsKey(userName)) {
            throw new RuntimeException("User not found with name " + userName);
        }
        return userMap.get(userName);
    }

    public void setTeam(User user, Team team) {
        user.setTeam(team);
    }

    public void addEvent(User user, Event event) {
        user.getEvents().add(event);
    }
}
