package com.example;

import java.io.*;
import java.net.*;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Server {

    int port;
    ServerSocket serverSocket;
    Socket socket;
    PrintWriter out;

    public static void main(String[] args) {

        Server server = new Server(6789);
        server.connect();

        while (true)
            server.communicate();
    }

    public Server(int port) {

        this.port = port;
    }

    public void connect() {

        try {
            serverSocket = new ServerSocket(port);

        } catch (IOException e) {
        }
    }

    public void communicate() {
        try {

            socket = serverSocket.accept();

            out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Client connesso sulla porta: " + port);

            XmlMapper mapper = new XmlMapper();

            Persona p = new Persona("Lorenzo", "Lasagni", 18);

            String xml = mapper.writeValueAsString(p);
            System.out.println(xml);
            out.println(xml);

            System.out.println("Connessione chiusa!");
            socket.close();
            out.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERRORE");
            System.exit(1);
        }
    }
}
