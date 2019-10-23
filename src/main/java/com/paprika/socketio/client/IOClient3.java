package com.paprika.socketio.client;

import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.net.Socket;

/**
 * @author adam
 * @date 2019/10/23
 */
@Slf4j
public class IOClient3 {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write(("Hi eve!").getBytes());
                        socket.getOutputStream().flush();
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();
    }
}
