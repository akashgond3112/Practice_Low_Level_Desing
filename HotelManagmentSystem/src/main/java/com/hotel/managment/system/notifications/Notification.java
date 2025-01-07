package com.hotel.managment.system.notifications;

import com.hotel.managment.system.models.User;
import com.hotel.managment.system.enums.NotificationChannel;

public class Notification {
    NotificationChannel channel;
    NotificationTemplate notificationTemplate;
    User user;
}
