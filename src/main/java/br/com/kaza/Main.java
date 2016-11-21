package br.com.kaza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.kaza.socket.Server;

/**
 * @author arino.godinho
 * 2016
 */
@SpringBootApplication
public class Main {
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		Server server = new Server();
	}
	
}
