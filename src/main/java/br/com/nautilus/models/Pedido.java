package br.com.nautilus.models;
import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.ManyToOne;

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
public class Pedido extends BaseEntity {
	
	
	private Long id;
	
	private Date dataPedido;
	@ManyToOne
	private Pessoa pessoa;
	
	
}
