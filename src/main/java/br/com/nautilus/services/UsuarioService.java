package br.com.nautilus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nautilus.base.BaseService;
import br.com.nautilus.models.Papel;
import br.com.nautilus.models.Permisao;
import br.com.nautilus.models.Unidade;
import br.com.nautilus.models.Usuario;
import br.com.nautilus.repository.UsuarioRepository;

@Service
public class UsuarioService extends BaseService<Usuario, UsuarioRepository>  {
	@Autowired
	private PapelService papelService;

	public List<Papel> buscarPapel(){
		return papelService.findAll();
	}
}
