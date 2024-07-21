package tech.buildrun.magalums.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_notifications")
public class Notification {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long NotificationId;

    private LocalDateTime dateTime;

    private String destination;

    private String message;

    @ManyToOne
    @JoinColumn (name = "channelId")
    private Channel channel;

    @ManyToOne
    @JoinColumn (name = "statusId")
    private Status status;

    public Notification() {
    }

    public Notification(LocalDateTime dateTime, String destination, String message, Channel channel, Status status) {
        this.dateTime = dateTime;
        this.destination = destination;
        this.message = message;
        this.channel = channel;
        this.status = status;
    }

    public long getNotificationId() {
        return NotificationId;
    }

    public void setNotificationId(long notificationId) {
        NotificationId = notificationId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}