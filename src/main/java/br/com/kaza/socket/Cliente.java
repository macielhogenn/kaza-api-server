package br.com.kaza.socket;

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
	private String ipServer = "";
	private Arquivo oArquivo = null; 

	public Cliente() {
		oArquivo = new Arquivo();
		this.ipServer = oArquivo.getServidor();
	}

	public void enviar(Message msg) {
		try {
			cliente = new Socket(this.ipServer, oArquivo.getPortaCliente());
			outToServer = new ObjectOutputStream(cliente.getOutputStream());
			outToServer.writeObject(msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
