package br.com.nautilus.models;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

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
public class Permisao extends BaseEntity {

	private Long id;
	@JoinColumn(name = "usuario_id")
	@ManyToOne
	private Usuario usuario;
	@JoinColumn(name = "papel_id")
	@ManyToOne
	private Papel papel;
	

}
