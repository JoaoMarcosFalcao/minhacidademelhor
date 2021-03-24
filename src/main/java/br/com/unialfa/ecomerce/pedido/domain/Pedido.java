package br.com.unialfa.ecomerce.pedido.domain;
import br.com.unialfa.ecomerce.cliente.domain.Cliente;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate dataCriacaoPedido;
    private LocalDate dataUltimaAtualizacao;
    private LocalDate dataConclusao;

    @Column(nullable = false)
    private BigDecimal subtotal;
    private BigDecimal total;
    private BigDecimal valorFrete;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "id.pedido")
    private List<ItensPedido> itensPedido;

      public Pedido() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataCriacaoPedido() {
        return dataCriacaoPedido;
    }

    public void setDataCriacaoPedido(LocalDate dataCriacaoPedido) {
        this.dataCriacaoPedido = dataCriacaoPedido;
    }

    public LocalDate getDataUltimaAtualizacao(LocalDate now) {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public List<ItensPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItensPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }
}

