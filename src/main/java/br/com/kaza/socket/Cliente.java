package br.com.kaza.socket;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import br.com.kaza.config.Arquivo;
import br.com.socket.Message;

/**
 * @author arino.godinho 
 * 2016
 */
public class Cliente {
	private Socket cliente = null;
	private ObjectOutputStream outToServer = null;
	private ObjectInputStream inFromServer = null;
	private String ipServer = "";
	private Arquivo oArquivo = null;

	public Cliente() {
		oArquivo = new Arquivo();
		this.ipServer = oArquivo.leDadosArquivo("config.ini");
	}

	public void enviar(Message msg) {
		try {
			cliente = new Socket(this.ipServer, 9080);
			outToServer = new ObjectOutputStream(cliente.getOutputStream());
			outToServer.writeObject(msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void ouvir() {
		try {
			inFromServer = new ObjectInputStream(cliente.getInputStream());
			System.out.println(inFromServer.readBoolean());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
