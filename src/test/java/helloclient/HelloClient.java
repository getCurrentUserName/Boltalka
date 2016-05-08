package helloclient;

import org.junit.Test;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.util.concurrent.ListenableFuture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class HelloClient {

    private static Logger logger = Logger.getLogger(HelloClient.class.getName());
    public static StompSession stompSession;

    public static void main(String[] args) throws Exception {
        Connect connect = new Connect();
        Subscribe subscribe = new Subscribe();

        ListenableFuture<StompSession> future = connect.connect();
        stompSession = future.get();

        logger.info("Subscribing" + stompSession);
        subscribe.subscribeGreetings();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean a = true;
        while (a) {
            String text = in.readLine();
            if (text.equals("exit")) {
                a = false;
            }
            stompSession.send("/app/anon/1", text.getBytes());
        }
    }
    
}
