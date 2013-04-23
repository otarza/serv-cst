package edu.cst.webserver.http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpServer {
    static HttpResponse response;
    HttpServer(){
        response = new HttpResponseWrapper();
    }
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

        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int contentLength = 10;
        String line;
        List<String> httpMessage = new ArrayList<String>();

        //add request Line
        try {
            if((line = bufferedReader.readLine()) != null){
                httpMessage.add(line);
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

        HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
        HttpRequestLine requestLine = null;
        try {
            requestLine = parser.parse(httpMessage.get(0));
        } catch (HttpRequestException e) {
            response.setStatus(HttpStatus.Code.BAD_REQUEST);
            e.printStackTrace();
        }
        //remove request Line from list
        httpMessage.remove(0);

        //read all headers
        try {
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

                   /* //for(int i = 1;i<)
                    Map<String,String> headers = null;
                    try {
                        headers = HttpHeaderFieldParser.parse_list(httpMessage);
                    } catch (HttpRequestException e) {
                        e.printStackTrace();
                    }*/





                    //                    String body;



//                    HttpRequest request = new HttpRequestWrapper(requestLine,headers,"");
                    for (String messageLine : httpMessage) {
                        System.out.println(messageLine);
                    }
                    socket.close();
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}