package tech.buildrun.magalums.service;

import org.springframework.stereotype.Service;
import tech.buildrun.magalums.controller.dto.ScheduleNotificationDto;
import tech.buildrun.magalums.entity.Notification;
import tech.buildrun.magalums.entity.Status;
import tech.buildrun.magalums.repository.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;


@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(ScheduleNotificationDto dto){
        notificationRepository.save(dto.toNotification());
    }

    public Optional<Notification> getNotificationById(long NotificationId) {
        return notificationRepository.findById(NotificationId);
    }

    public void cancelNotification(long NotificationId) {
        var notification = getNotificationById(NotificationId);

        if (notification.isPresent()){
            notification.get().setStatus(Status.Values.CANCELLED.toStatus());
            notificationRepository.save(notification.get());
        }
    }

    public void checkAvailableMessages(LocalDateTime dateTime) {
        var notifications = notificationRepository.findByStatusInAndDateTimeBefore(
                List.of(
                    Status.Values.PENDING.toStatus(),
                    Status.Values.ERROR.toStatus()
                ),
                dateTime
        );

        notifications.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification() {
        return notification -> {
            //TO DO - Enviar a notificação (Não será feito)

            notification.setStatus(Status.Values.SUCCESS.toStatus());
            notificationRepository.save(notification);
        };
    }
}
