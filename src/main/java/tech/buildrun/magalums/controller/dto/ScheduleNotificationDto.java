package tech.buildrun.magalums.controller.dto;

import java.time.LocalDateTime;
import tech.buildrun.magalums.entity.Channel;
import tech.buildrun.magalums.entity.Notification;
import tech.buildrun.magalums.entity.Status;

public record ScheduleNotificationDto(LocalDateTime dateTime,
                                       String destination,
                                       String message,
                                       Channel.Values channel) {
    public Notification toNotification(){
        return new Notification(
            dateTime,
            destination,
            message,
            channel.toChannel(),
            Status.Values.PENDING.toStatus()
        );
    }
}