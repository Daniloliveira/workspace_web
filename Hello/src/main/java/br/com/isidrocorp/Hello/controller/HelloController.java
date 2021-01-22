package br.com.isidrocorp.Hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.Hello.model.Produto;

/* toda classe que criarmos dentro do pacote controller deverá atender URLs vindas do browser
 * para tornar isso possível, DEVEMOS anotar a classe com @RestController
 * 
 * @RestController - torna nossa classe uma classe que atende solicitações WEB
 */

@RestController
public class HelloController {
	
	
	/* através do uso da anotação @GetMapping, permitimos ao browser acessar a URL
	 * 
	 * http://localhost:8088/hello e isso irá retornar uma mensagem de boas vindas
	 */
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World! O Isidro fala pa caramba!!!";
	}
	
	@GetMapping("/pagina")
	public String mostrarPagina() {
		return "<html> "
				+ "<body> "
				+ "  <h1> Teste de Pagina </h1>"
				+ "  <hr>"
				+ "  <p> Este eh um exemplo de pagina HTML que no fundo nao vai servir pra nada </p>"
				+ "</body>"
				+ "</html>";
	}
	
	
	@GetMapping("/produto")
	public Produto exibirProduto() {
		Produto p = new Produto(1,"Computador Top de linha", 4000.00, 5);
		return p;
	}

}