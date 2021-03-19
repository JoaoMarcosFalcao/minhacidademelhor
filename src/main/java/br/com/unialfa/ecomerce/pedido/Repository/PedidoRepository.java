package br.com.unialfa.ecomerce.pedido.Repository;

import br.com.unialfa.ecomerce.pedido.domain.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository <Pedido, Long> {
}
