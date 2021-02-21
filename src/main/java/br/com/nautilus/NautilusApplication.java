package br.com.nautilus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.nautilus.models.Papel;
import br.com.nautilus.models.Permisao;
import br.com.nautilus.models.Usuario;
import br.com.nautilus.repository.PermisaoRepository;

@SpringBootApplication
public class NautilusApplication {
	
	public static void main(String[] args) {
			SpringApplication.run(NautilusApplication.class, args);
	

	}

}
