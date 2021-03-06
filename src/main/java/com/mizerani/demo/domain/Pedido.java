package com.mizerani.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido implements Serializable {

     /** Atributo serialVersionUID */
     private static final long serialVersionUID = 1L;

     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Integer id;
     
     @JsonFormat(pattern="dd/MM/yyyy HH:mm")
     private Date instante;
     
     @OneToOne(cascade=CascadeType.ALL, mappedBy="pedido")
     private Pagamento pagamento;
     
     @ManyToOne
     @JoinColumn(name="cliente_id")
     private Cliente cliente;
     
     @ManyToOne
     @JoinColumn(name="endereco_de_entrega_id")
     private Endereco enderecoDeEntrega;
     
     @OneToMany(mappedBy="id.pedido")
     private Set<ItemPedido> itens = new HashSet<>();
     
     public Pedido() {
     }

     public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoDeEntrega) {

          super();
          this.id = id;
          this.instante = instante;
          this.cliente = cliente;
          this.enderecoDeEntrega = enderecoDeEntrega;
     }

     
     /**
      * id
      *
      * @return the id
      */
     public Integer getId() {
     
          return id;
     }

     
     /**
      * id
      *
      * @param id the id to set
      */
     public void setId(Integer id) {
     
          this.id = id;
     }

     
     /**
      * instante
      *
      * @return the instante
      */
     public Date getInstante() {
     
          return instante;
     }

     
     /**
      * instante
      *
      * @param instante the instante to set
      */
     public void setInstante(Date instante) {
     
          this.instante = instante;
     }

     
     /**
      * pagamento
      *
      * @return the pagamento
      */
     public Pagamento getPagamento() {
     
          return pagamento;
     }

     
     /**
      * pagamento
      *
      * @param pagamento the pagamento to set
      */
     public void setPagamento(Pagamento pagamento) {
     
          this.pagamento = pagamento;
     }

     
     /**
      * cliente
      *
      * @return the cliente
      */
     public Cliente getCliente() {
     
          return cliente;
     }

     
     /**
      * cliente
      *
      * @param cliente the cliente to set
      */
     public void setCliente(Cliente cliente) {
     
          this.cliente = cliente;
     }

     
     /**
      * enderecoDeEntrega
      *
      * @return the enderecoDeEntrega
      */
     public Endereco getEnderecoDeEntrega() {
     
          return enderecoDeEntrega;
     }

     
     /**
      * enderecoDeEntrega
      *
      * @param enderecoDeEntrega the enderecoDeEntrega to set
      */
     public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
     
          this.enderecoDeEntrega = enderecoDeEntrega;
     }

     public Set<ItemPedido> getItens() {

          return itens;
     }

     public void setItens(Set<ItemPedido> itens) {

          this.itens = itens;
     }
     
     /* (non-Javadoc)
      * @see java.lang.Object#hashCode()
      */
     @Override
     public int hashCode() {

          final int prime = 31;
          int result = 1;
          result = prime * result + ((id == null) ? 0 : id.hashCode());
          return result;
     }

     /* (non-Javadoc)
      * @see java.lang.Object#equals(java.lang.Object)
      */
     @Override
     public boolean equals(Object obj) {

          if (this == obj)
               return true;
          if (obj == null)
               return false;
          if (getClass() != obj.getClass())
               return false;
          Pedido other = (Pedido) obj;
          if (id == null) {
               if (other.id != null)
                    return false;
          } else if (!id.equals(other.id))
               return false;
          return true;
     }    
     
     
}
