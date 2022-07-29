package com.oscarhanke.notification.controller;

import com.oscarhanke.clients.notification.NotificationRequest;
import com.oscarhanke.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/notification")
public record NotificationController(NotificationService notificationService) {

    @PostMapping
    void sendNotification(@RequestBody NotificationRequest notificationRequest){
        log.info("New notification... {}", notificationRequest);
        notificationService.send(notificationRequest);
    }

}
