package br.com.kaza.socket;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author arino.godinho 
 * 2016
 */
public class Server {

	private ServerSocket server;

	public Server() {
		try {
			server = new ServerSocket(9081);
			System.out.println("Porta 9081 aberta!");

			while (true) {
				Socket cliente = server.accept();
				ObjectInputStream inFromClient = new ObjectInputStream(cliente.getInputStream());
				System.out.println(inFromClient.readBoolean());
			}
		} catch (Exception e) {

		}
	}
	
}
