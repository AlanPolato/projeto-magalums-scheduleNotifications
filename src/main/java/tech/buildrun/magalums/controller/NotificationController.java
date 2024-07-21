package tech.buildrun.magalums.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.buildrun.magalums.controller.dto.ScheduleNotificationDto;
import tech.buildrun.magalums.entity.Notification;
import tech.buildrun.magalums.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/notifications")

public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity <?> scheduleNotification(@RequestBody ScheduleNotificationDto dto) {
        notificationService.scheduleNotification(dto);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity <Notification> getNotification(@PathVariable("notificationId") long notificationId) {
        var notification = notificationService.getNotificationById(notificationId);

        if (notification.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(notification.get());
    }

    @PutMapping("/{notificationId}")
    public ResponseEntity <Notification> cancelNotification(@PathVariable("notificationId") long notificationId) {
        notificationService.cancelNotification(notificationId);

        return ResponseEntity.noContent().build();
    }

}
