package edu.cst.webserver.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(9191);

            while (true) {
                Socket socket = serverSocket.accept();
                socket.setSoTimeout(10000);
                process(socket);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void process(Socket socket) {
        HttpResponse response = null;
        HttpRequest request = null;
        try {
            response = new HttpResponseWrapper(socket.getOutputStream());

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
            List<String> headerList = new ArrayList<String>();
            HttpRequestLine requestLine = null;
            String line;

            try {
                if((line = bufferedReader.readLine()) != null){
                    HttpRequestLineParser parser = HttpRequestLineParser.newInstance();
                    try {
                        requestLine = parser.parse(line);
                    } catch (HttpRequestException e) {
                        response.setStatus(HttpStatus.Code.BAD_REQUEST);
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            //read all headers
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.length() == 0) {
                        Map<String, String> headers = HttpHeaderFieldParser.parseList(headerList);
                        response.setHeaders(headers);
                        request = new HttpRequestWrapper(requestLine, headers, null);
                        HttpRequestDispatcher dispatcher = new HttpRequestDispatcher(request, response);
                        dispatcher.dispatch();
						response.flush();
                        break;
                    } else {
                        headerList.add(line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (HttpRequestException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dump(HttpResponse response) {
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, String> header : response.getHeaders().entrySet()) {
            builder.append(header.getKey());
            builder.append(":");
            builder.append(header.getValue());
            builder.append("\r\n");
        }

        try {
            response.write(builder.toString());
            response.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}