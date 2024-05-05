package com.mycompany.notification;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> addNotification(@RequestBody Notification notification) {
        notificationService.saveNotification(notification);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Notification> getNotification(@PathVariable("id") int id) {
        return ResponseEntity.ok(notificationService.getNotification(id));
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable("id") int id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
