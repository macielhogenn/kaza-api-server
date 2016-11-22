package br.com.kaza.view;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.kaza.socket.Cliente;
import br.com.socket.TipoComando;
import br.com.socket.Message;

/**
 * @author arino.godinho
 * 2016
 */
@RestController
public class UserView {
	private Cliente cliente = new Cliente();
	private Message message;

	@RequestMapping("/")
	public String index() {
		return "<h2>Chamadas Andorid</h2>"
				+ "<li>acionar?lampada=int	 			</li>"
				+ "<li>abrir?portao_eletronico=int	 	</li>"
				+ "<li>intensidade?luminosidade=int 	</li>"
				+ "<li>ativar?alarme=int 				</li>";
	}
	
	
	@RequestMapping("/acionar")
	public void acionarLampada(@RequestParam(name = "lampada", required = true) int acionar){
		message = new Message(acionar, TipoComando.LAMPADA);
		cliente.enviar(message);
	}
	
	@RequestMapping("/abrir")
	public void abrirPortao(@RequestParam(name = "portao_eletronico", required = true) int abrir){
		message = new Message(abrir, TipoComando.PORTAO);
		cliente.enviar(message);
	}
	
	@RequestMapping("/intensidade")
	public void intensidadeLuminosidade(@RequestParam(name = "luminosidade", required = true) int valor){
		message = new Message(valor, TipoComando.LUMINOSIDADE);
		cliente.enviar(message);
	}
	
	@RequestMapping("/ativar")
	public void ativarAlarme(@RequestParam(name = "alarme", required = true) int ativar){
		message = new Message(ativar, TipoComando.ALARME);
		cliente.enviar(message);
	}
}
