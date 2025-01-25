package com.hotel.managment.system.services;

import com.hotel.managment.system.notifications.Notification;

public interface NotificationService {
    public boolean triggerNotification(Notification notification);

}
