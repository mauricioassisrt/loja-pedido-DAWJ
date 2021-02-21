package br.com.nautilus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.nautilus.base.BaseController;
import br.com.nautilus.models.Papel;
import br.com.nautilus.models.Permisao;
import br.com.nautilus.models.Usuario;
import br.com.nautilus.repository.PapelRepository;
import br.com.nautilus.repository.PermisaoRepository;
import br.com.nautilus.repository.UsuarioRepository;
import br.com.nautilus.services.UsuarioService;

@RestController
public class HomeController extends BaseController<Usuario, UsuarioRepository, UsuarioService> {
	@Autowired
	private PermisaoRepository repositorio;
	@Autowired
	private PapelRepository repPapel;

	@GetMapping(value = "/")
	public ModelAndView getPaginaHome() {

		return new ModelAndView("home");

	}

	@GetMapping(value = "/redefinir-senha")
	public ModelAndView getMethod2Name() {
		return new ModelAndView("redefinir-senha");
	}

	@GetMapping(value = "/login")
	public ModelAndView getPaginaLogin() {

		Permisao permisao = new Permisao();
		Papel papel = new Papel();
		Usuario user = new Usuario();
		int cot = getService().findAll().size();
		System.out.print(cot);

		if (cot != 0) {
			return new ModelAndView("login");
		} else {
			papel.setNome("ADM");
			repPapel.saveAndFlush(papel);

			user.setNome("administrador");
			user.setLogin("admin@admin.com");
			user.setSenha(new BCryptPasswordEncoder().encode("123"));
			user.setEmail("admin@admin.com");
			getService().save(user);

			permisao.setPapel(papel);
			permisao.setUsuario(user);

			repositorio.saveAndFlush(permisao);

			return new ModelAndView("login");
		}

	}

	@Override
	public ModelAndView getPaginaLista(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView getPaginaCadastro(Usuario entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView salvar(Usuario entity, BindingResult bindingResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView remover(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
