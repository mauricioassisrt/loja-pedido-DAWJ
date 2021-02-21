package br.com.nautilus.models;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

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
public class Papel extends BaseEntity {

	private Long id;
	@NotBlank
	private String nome;
	

}
