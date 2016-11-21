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

	public String leDadosArquivo(String arquivo) {
		String[] result = null;
		try {
			if (abreArquivo(arquivo)) {
				String linha = leitor.readLine();
				if (linha.equalsIgnoreCase("[Parametros]")) {
					linha = leitor.readLine();
					while (linha != null) {
						result = linha.split("=");
						linha = leitor.readLine();
					
					}
				}
			} 
		} catch (Exception e) {
		}
		return result[1];
	}

}
