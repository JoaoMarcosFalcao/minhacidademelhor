package br.com.unialfa.ecomerce;

import br.com.unialfa.ecomerce.cliente.domain.Cliente;
import br.com.unialfa.ecomerce.cliente.repository.ClienteRepository;
import br.com.unialfa.ecomerce.pedido.domain.Pedido;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class EcomerceApplication {

	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(EcomerceApplication.class, args);



	}

	@Bean
	//public Object criarClientes(){
	InitializingBean sendDataBase(){
		Cliente cliente = new Cliente();
		cliente.setNome("ClienteTeste");
		cliente.setCpf("000.000.000-00");
		cliente.setDataNascimento(LocalDate.now());
		cliente.setVersao(1);
		cliente.setPrimeiroNome("Teste");
		clienteRepository.save(cliente);


		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setDataCriacaoPedido(LocalDate.now());
		pedido.setDataUltimaAtualizacao(LocalDate.now());
		pedido.setDataConclusao(LocalDate.now());
		pedido.setSubtotal(BigDecimal.ZERO);
		pedido.setTotal(BigDecimal.ZERO);
		pedido.setValorFrete(BigDecimal.ZERO);

		return null;
	}


}