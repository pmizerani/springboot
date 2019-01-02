package com.mizerani.demo.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido implements Serializable {

     /** Atributo serialVersionUID */
     private static final long serialVersionUID = 1L;

     @JsonIgnore
     @EmbeddedId
     private ItemPedidoPK id = new ItemPedidoPK();
     
     private Double desconto;
     private Integer quantidade;
     private Double preco;
     
     public ItemPedido() {
     }

     public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {

          super();
          id.setPedido(pedido);
          id.setProduto(produto);
          this.desconto = desconto;
          this.quantidade = quantidade;
          this.preco = preco;
     }

     @JsonIgnore
     public Pedido getPedido() {
          return id.getPedido();
     }
     
     public Produto getProduto() {
          return id.getProduto();
     }
     
     /**
      * id
      *
      * @return the id
      */
     public ItemPedidoPK getId() {
     
          return id;
     }

     
     /**
      * id
      *
      * @param id the id to set
      */
     public void setId(ItemPedidoPK id) {
     
          this.id = id;
     }

     
     /**
      * desconto
      *
      * @return the desconto
      */
     public Double getDesconto() {
     
          return desconto;
     }

     
     /**
      * desconto
      *
      * @param desconto the desconto to set
      */
     public void setDesconto(Double desconto) {
     
          this.desconto = desconto;
     }

     
     /**
      * quantidade
      *
      * @return the quantidade
      */
     public Integer getQuantidade() {
     
          return quantidade;
     }

     
     /**
      * quantidade
      *
      * @param quantidade the quantidade to set
      */
     public void setQuantidade(Integer quantidade) {
     
          this.quantidade = quantidade;
     }

     
     /**
      * preco
      *
      * @return the preco
      */
     public Double getPreco() {
     
          return preco;
     }

     
     /**
      * preco
      *
      * @param preco the preco to set
      */
     public void setPreco(Double preco) {
     
          this.preco = preco;
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
          ItemPedido other = (ItemPedido) obj;
          if (id == null) {
               if (other.id != null)
                    return false;
          } else if (!id.equals(other.id))
               return false;
          return true;
     }
     
     
     
}
