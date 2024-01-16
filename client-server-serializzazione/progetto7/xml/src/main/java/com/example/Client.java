package com.example;

import java.io.*;
import java.net.*;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Client {

    int serverPort;
    String serverAddress;

    Socket client;
    BufferedReader in;

    public static void main(String[] args) {

        Client client = new Client("localhost", 6789);
        client.connect();

        client.communicate();
    }

    public Client(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public Socket connect() {

        try {
            client = new Socket(serverAddress, serverPort);

            in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            System.out.println("Connesso al server con IP: " + serverAddress + ":" + serverPort);

        } catch (UnknownHostException e) {
            System.err.println("Host sconosciuto");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERRORE");
            System.exit(1);
        }

        return client;
    }

    public void communicate() {

        String xml;
        try {
            if (!(xml = in.readLine()).isEmpty()) {
                System.out.println(xml);

                XmlMapper mapper = new XmlMapper();

                Persona p = mapper.readValue(xml, Persona.class);
                System.out.println(p.toString());

                System.out.println("Connessione al server chiusa!");
                in.close();
                client.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}