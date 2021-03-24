package br.com.unialfa.ecomerce;

import br.com.unialfa.ecomerce.cliente.domain.Cliente;
import br.com.unialfa.ecomerce.cliente.repository.ClienteRepository;
import br.com.unialfa.ecomerce.pedido.Repository.ItensPedidoRepository;
import br.com.unialfa.ecomerce.pedido.Repository.PedidoRepository;
import br.com.unialfa.ecomerce.pedido.domain.ItensPedido;
import br.com.unialfa.ecomerce.pedido.domain.Pedido;
import br.com.unialfa.ecomerce.produto.domain.Produto;
import br.com.unialfa.ecomerce.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EcomerceApplication {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ItensPedidoRepository itensPedidoRepository;

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

		pedidoRepository.save(pedido);

		List<Produto> produtos = new ArrayList<>();

		Produto produto = new Produto();
		produto.setAtivo(true);
		produto.setNome("produto 1");
		produto.setDescricao("Teste produto 1");
		produto.setPreco(BigDecimal.valueOf(10.00));
		produto.add(produto);

		Produto produto2 = new Produto();
		produto.setAtivo(true);
		produto.setNome("produto 2");
		produto.setDescricao("Teste produto 2");
		produto.setPreco(BigDecimal.valueOf(20.00));
		produto.add(produto2);

		produtoRepository.saveAll(produtos);

		List<ItensPedido> itensPedidos = new ArrayList<>();
		ItensPedido itensPedido = new ItensPedido();
		itensPedido.getId().setPedido(pedido);
		itensPedido.getId().setProduto(produto);
		itensPedidos.add(itensPedido);

		ItensPedido itensPedido2 = new ItensPedido();
		itensPedido2.getId().setPedido(pedido);
		itensPedido2.getId().setProduto(produto);
		itensPedidos.add(itensPedido2);

		itensPedidoRepository.saveAll(itensPedidos);

		return null;
	}


}