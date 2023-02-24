package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @PostMapping("/send")
    public void publishEvents (@RequestBody List<EventPayload> payload){
        EventService es = new EventService();
        es.sentEvent(payload);
    }
}
