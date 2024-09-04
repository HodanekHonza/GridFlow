package com.GridFlow.GridFlow.receiver.api;

import com.GridFlow.GridFlow.receiver.route.ReceiverRoute;
import com.GridFlow.GridFlow.receiver.api.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReceiverController {

    @Autowired
    private final ReceiverRoute route;

    public ReceiverController(ReceiverRoute route) {
        this.route = route;
    }

    @PostMapping("/process")
    public void processMessage(@RequestBody Message message) {
        route.execute(message);
    }
}
