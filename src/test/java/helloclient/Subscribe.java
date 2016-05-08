package helloclient;

import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;

import java.lang.reflect.Type;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

/**
 * Created by LucidMinds on 07.05.16.
 * package com.od.helloclient;
 */
public class Subscribe {

    private static Logger logger = Logger.getLogger(Subscribe.class.getName());

    public void subscribeGreetings() throws ExecutionException, InterruptedException {
        HelloClient.stompSession.subscribe("/topic/anon/1", new StompFrameHandler() {

            public Type getPayloadType(StompHeaders stompHeaders) {
                return byte[].class;
            }

            public void handleFrame(StompHeaders stompHeaders, Object o) {
                logger.info("Received message " + new String((byte[]) o));
            }
        });
    }
}
