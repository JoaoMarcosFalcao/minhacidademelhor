package br.com.unialfa.ecomerce.pedido.service;

import br.com.unialfa.ecomerce.cliente.domain.Cliente;
import br.com.unialfa.ecomerce.pedido.Repository.PedidoRepository;
import br.com.unialfa.ecomerce.pedido.domain.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidorepository;

    @GetMapping(path = "/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Pedido> listarPedido(@PathVariable Long idCliente) {
        Cliente cliente = new Cliente();
        cliente.setId(idCliente);
        return pedidorepository.findByCliente(cliente);
    }

    @PostMapping(path = "/add")
    public void cadastrarPedido(@RequestBody Pedido pedido) {

        pedidorepository.save(pedido);
    }

    @PutMapping(path = "/edit")
    public void editarPedido(@RequestBody Pedido pedido) {


        pedidorepository.save(pedido);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletarPedido(@PathVariable(name = "id") long id) {
        pedidorepository.deleteById(id);
    }
}
