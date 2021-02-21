package br.com.nautilus.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/usuario")
public class UsuarioController extends BaseController<Usuario, UsuarioRepository, UsuarioService> {
	@Autowired
	private PermisaoRepository repositorio;
	@Autowired
	private PapelRepository repPapel;

	List<Papel> lista = new ArrayList<>();
	Permisao permisao = new Permisao();
	Papel papel = new Papel();
	Usuario user = new Usuario();

	@Override

	@GetMapping
	public ModelAndView getPaginaLista(Pageable pageable) {
		Page<Usuario> list = getService().findAll(pageable);
		// "nome do caminho da pasta e do arquivo html "
		ModelAndView mv = new ModelAndView("/usuario/usuario-list");
		mv.addObject("page", list);

		return mv;
	}

	@Override
	// nome da rota a exibir no browser
	@GetMapping("/formulario")
	public ModelAndView getPaginaCadastro(Usuario entity, Long id) {
		ModelAndView mv = new ModelAndView("/usuario/usuario-form");
		// se vir um id edita o usuarioo
		if (id != null) {
			mv.addObject("usuario", getService().findById(id).get());
		} else {
			// se nao cria um novo
			mv.addObject("usuario", entity);
		}
		mv.addObject("papels", getService().buscarPapel());
		return mv;
	}

	@Override
	@PostMapping("/formulario")
	public ModelAndView salvar(@Valid Usuario entity, BindingResult bindingResult) {
		Permisao obj = new Permisao();
		Papel objPapel = new Papel();
		if (bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("/usuario/usuario-form");
			mv.addObject("usuario", entity);

			return mv;
		}

		int cot = getService().findAll().size();

		if (cot != 0) {

			entity.setSenha(new BCryptPasswordEncoder().encode(entity.getSenha()));
			getService().save(entity);

			lista.addAll(getService().buscarPapel());
			papel = lista.get(0);

			permisao.setPapel(papel);
			permisao.setUsuario(entity);

			repositorio.saveAndFlush(permisao);

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

			entity.setSenha(new BCryptPasswordEncoder().encode(entity.getSenha()));

			getService().save(entity);
		}

		return new ModelAndView("redirect:/usuario");
	}

	@Override
	@GetMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Long id) {
		getService().deleteById(id);

		return new ModelAndView("redirect:/usuario");
	}
}
