package com.hotel.managment.system.services;

import com.hotel.managment.system.notifications.Notification;

public class NotificationServiceImpl implements NotificationService {

    @Override
    public boolean triggerNotification(Notification notification) {
        return true;
    }
}
