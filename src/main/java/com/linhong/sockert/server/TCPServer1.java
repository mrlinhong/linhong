package com.linhong.sockert.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer1 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            // 1. create server socket bound to port 8890
            serverSocket = new ServerSocket(8890);
            // 2. listen for a request connection, blocks until a connection is made
            socket = serverSocket.accept();
            System.out.println("Handling client: " + socket.getRemoteSocketAddress());
            // 3. get message from client
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            System.out.println("Client said:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            // 4. write message to client
            OutputStream out = socket.getOutputStream();
            out.write("Welcome!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 5. close socket and server socket
                if (socket != null) {
                    socket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
