package br.com.nautilus.models;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
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
public class Usuario extends BaseEntity {

	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String login;
	@NotBlank
	private String senha;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dtNascimento;
	@NotBlank
	@Email
	private String email;
	private String telefone;
	@ManyToOne
	@JoinColumn(name = "permisao_id")
	private Permisao permisao;
	
}
