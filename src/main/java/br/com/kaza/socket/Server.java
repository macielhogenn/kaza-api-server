package br.com.kaza.socket;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import br.com.kaza.config.Arquivo;
import br.com.kaza.fcm.FCMServer;

/**
 * @author arino.godinho 
 * 2016
 */
public class Server {

	private ServerSocket server;
	private Arquivo oArquivo = null; 

	public Server() {
		try {
			oArquivo = new Arquivo();
			server = new ServerSocket(oArquivo.getPortaServidor());
			System.out.println("Porta 9081 aberta!");

			while (true) {
				Socket cliente = server.accept();
				ObjectInputStream inFromClient = new ObjectInputStream(cliente.getInputStream());
				//System.out.println(inFromClient.readBoolean());
				FCMServer.push();
			}
		} catch (Exception e) {

		}
	}
	
}
