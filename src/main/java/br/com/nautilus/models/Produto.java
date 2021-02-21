package br.com.nautilus.models;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class Produto extends BaseEntity {

	private Long id;
	@NotBlank
	private String nome;
	@NotNull
	private BigDecimal valorCompra;
	@NotNull
	private BigDecimal quantidade;
	private String codBarras;
	@ManyToOne
	@JoinColumn(name = "id_unidade")
	private Unidade unidade;
}
