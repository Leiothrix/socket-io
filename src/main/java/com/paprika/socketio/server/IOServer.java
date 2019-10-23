package com.paprika.socketio.server;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author adam
 * @date 2019/10/23
 */
@Slf4j
public class IOServer {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8000);

        // (1) 接收新连接线程
        new Thread(() -> {
                                while (true) {
                                    try {
                                        // (1) 阻塞方法获取新的连接
                                        Socket socket = serverSocket.accept();

                                        // (2) 每一个新的连接都创建一个线程，负责读取数据
                                        new Thread(() -> {
                                            try {
                                                byte[] data = new byte[1024];
                                                InputStream inputStream = socket.getInputStream();
                                                while (true) {
                                                    int len;
                                                    // (3) 按字节流方式读取数据
                                                    while ((len = inputStream.read(data)) != -1) {
                                                        log.info(new String(data, 0, len));
                                                    }
                            }
                        } catch (IOException e) {
                            log.info(e.getMessage());
                        }
                    }).start();

                } catch (IOException e) {
                    log.info(e.getMessage());
                }
            }
        }).start();
    }
}
