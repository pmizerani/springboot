package com.mizerani.demo.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mizerani.demo.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {

     /** Atributo serialVersionUID */
     private static final long serialVersionUID = 1L;
     
     @JsonFormat(pattern="dd/MM/yyyy")
     private Date dataVencimento;
     
     @JsonFormat(pattern="dd/MM/yyyy")
     private Date dataPagamento;
 
     public PagamentoComBoleto() {
     }

     public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {

          super(id, estado, pedido);
          this.dataVencimento = dataVencimento;
          this.dataPagamento = dataPagamento;
          
     }

     
     /**
      * dataVencimento
      *
      * @return the dataVencimento
      */
     public Date getDataVencimento() {
     
          return dataVencimento;
     }

     
     /**
      * dataVencimento
      *
      * @param dataVencimento the dataVencimento to set
      */
     public void setDataVencimento(Date dataVencimento) {
     
          this.dataVencimento = dataVencimento;
     }

     
     /**
      * dataPagamento
      *
      * @return the dataPagamento
      */
     public Date getDataPagamento() {
     
          return dataPagamento;
     }

     
     /**
      * dataPagamento
      *
      * @param dataPagamento the dataPagamento to set
      */
     public void setDataPagamento(Date dataPagamento) {
     
          this.dataPagamento = dataPagamento;
     }
     
     
     
}
