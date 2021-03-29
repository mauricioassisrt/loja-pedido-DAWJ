package br.com.nautilus.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.nautilus.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
@Entity
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class ItensPedido extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer quantidade;
	@ManyToOne
	private Pedido objetoPedido;
	@ManyToOne
	private  Produto objetoProduto;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Pedido getObjetoPedido() {
		return objetoPedido;
	}
	public void setObjetoPedido(Pedido objetoPedido) {
		this.objetoPedido = objetoPedido;
	}
	public Produto getObjetoProduto() {
		return objetoProduto;
	}
	public void setObjetoProduto(Produto objetoProduto) {
		this.objetoProduto = objetoProduto;
	}
	
	
	
	
}
