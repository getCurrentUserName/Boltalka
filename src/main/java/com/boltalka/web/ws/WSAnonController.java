package com.boltalka.web.ws;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;

import static org.apache.commons.lang3.StringEscapeUtils.escapeHtml4;

/**
 * Created by LucidMinds on 09.05.16.
 * package com.boltalka.web.ws;
 */
@Controller
public class WSAnonController {

    private Logger logger = Logger.getLogger(WSAnonController.class.getName());

    @MessageMapping("/anon/{roomName}")
    @SendTo("/topic/anon/{roomName}")
    public String simple(@DestinationVariable(value = "roomName") String roomName,
                         String message) {
        logger.info("roomName " + roomName);
        logger.info("message " + message);
        return escapeHtml4(message);
    }
}
