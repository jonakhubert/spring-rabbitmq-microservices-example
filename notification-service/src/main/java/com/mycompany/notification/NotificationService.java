package com.mycompany.notification;

import org.springframework.data.domain.Page;

import java.util.List;

public interface NotificationService {
    List<Notification> getAllNotifications();
    Notification getNotification(int id);
    void saveNotification(Notification notification);
    void deleteNotification(int id);
    Page<Notification> getNotificationsPage(int pageSize, int pageNumber, String sortField, String sortDirection);
}
