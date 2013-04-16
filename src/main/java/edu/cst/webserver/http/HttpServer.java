package edu.cst.webserver.http;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class HttpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(9191);

            while (true) {
                Socket socket = serverSocket.accept();
                socket.setSoTimeout(10000);
                process(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void process(Socket socket) {
        try {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            int contentLength = 10;
            String line;
            List<String> httpMessage = new ArrayList<String>();

            while ((line = bufferedReader.readLine()) != null) {
                httpMessage.add(line);

                if (line.length() == 0) {
                    ByteArrayOutputStream entityBody = new ByteArrayOutputStream();

                    try {
                        byte[] remaining = new byte[contentLength];
                        int read = inputStream.read(remaining);
                        if (read > -1) {
                            entityBody.write(remaining);
                        }
                    } catch (IOException e) {
                        break;
                    }

                    for (String messageLine : httpMessage) {
                        System.out.println(messageLine);
                    }

                    socket.close();
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}