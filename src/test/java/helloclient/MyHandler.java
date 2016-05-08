package helloclient;

import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.util.logging.Logger;

/**
 * Created by LucidMinds on 07.05.16.
 * package com.od.helloclient;
 */

public class MyHandler extends StompSessionHandlerAdapter {

    private static Logger logger = Logger.getLogger(MyHandler.class.getName());

    public void afterConnected(StompSession stompSession, StompHeaders stompHeaders) {
        logger.info("Now connected");
    }
}