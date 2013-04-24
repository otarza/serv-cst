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
				socket.close();
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
					dump(socket, headerList);
                    break;
                } else {
					headerList.add(line);
				}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	private static void dump(Socket socket, List<String> headers) {
		StringBuilder builder = new StringBuilder();
		builder.append("HTTP/1.1 200 OK");
		builder.append("Content-Type: text/html");
		builder.append("\r\n\r\n");

		for (String messageLine : headers) {
			System.out.println(messageLine);
			builder.append(messageLine);
			builder.append("\r\n");
		}

		try {
			socket.getOutputStream().write(builder.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}