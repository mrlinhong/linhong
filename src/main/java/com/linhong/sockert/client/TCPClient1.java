package com.linhong.sockert.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient1 {

    public static void main(String[] args) {
        String message = "hello";
        Socket socket = null;
        try {
            // 1. create a socket bound to port 8890 and connected to server
            socket = new Socket(InetAddress.getLocalHost(), 8890);
            System.out.println("Connected to server...");
            // 2. send message to server
            OutputStream out = socket.getOutputStream();
            out.write(message.getBytes());
            // 3. close socket output
            socket.shutdownOutput();
            // 4. read message from server
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            System.out.println("Server said:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5. close socket
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
