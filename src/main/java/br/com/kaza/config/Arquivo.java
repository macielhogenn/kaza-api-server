package br.com.kaza.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author arino.godinho 
 * 2016
 */
public class Arquivo {

	static BufferedReader leitor = null;
	private String servidor;
	private int portaCliente;
	private int portaServidor;

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public int getPortaCliente() {
		return portaCliente;
	}

	public void setPortaCliente(int portaCliente) {
		this.portaCliente = portaCliente;
	}

	public int getPortaServidor() {
		return portaServidor;
	}

	public void setPortaServidor(int portaServidor) {
		this.portaServidor = portaServidor;
	}

	public Arquivo() {
		leDadosArquivo("config.ini");
	}

	public static boolean abreArquivo(String arquivo) {
		try {
			leitor = new BufferedReader(new FileReader(new File(arquivo)));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean fechaArquivo() {
		try {
			leitor.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private void leDadosArquivo(String arquivo) {
		String[] result = null;
		try {
			if (abreArquivo(arquivo)) {
				String linha = leitor.readLine();
				while (linha != null){
					if (linha.equalsIgnoreCase("[Parametros]")) {
						linha = leitor.readLine();
						result = linha.split("=");
						this.servidor = result[1];
						
					}else if (linha.equalsIgnoreCase("[Cliente]")) {
						linha = leitor.readLine();
						result = linha.split("=");
						this.portaCliente = Integer.parseInt(result[1]);
						
					}else if (linha.equalsIgnoreCase("[Server]")) {
						linha = leitor.readLine();
						result = linha.split("=");
						this.portaServidor = Integer.parseInt(result[1]);
					}
					linha = leitor.readLine();
				}
			} 
		} catch (Exception e) {
		}
	}

}
