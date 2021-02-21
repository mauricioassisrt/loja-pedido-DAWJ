package br.com.nautilus.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.nautilus.base.BaseController;
import br.com.nautilus.models.Pessoa;
import br.com.nautilus.repository.PessoaRepository;
import br.com.nautilus.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController extends BaseController<Pessoa, PessoaRepository, PessoaService> {

	@Override
	@GetMapping
	public ModelAndView getPaginaLista(Pageable pageable) {
		Page<Pessoa> list = getService().findAll(pageable);
		ModelAndView mv = new ModelAndView("/pessoas/lista");
		mv.addObject("page", list);

		return mv;
	}

	@Override
	@GetMapping("/cadastrar")
	public ModelAndView getPaginaCadastro(Pessoa entity, Long id) {
		ModelAndView mv = new ModelAndView("/pessoas/formulario");
		if (id != null) {
			mv.addObject("pessoa", getService().findById(id).get());
		} else {
			mv.addObject("pessoa", entity);
		}

		
		
		return mv;
	}

	@Override
	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid Pessoa entity, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("/pessoas/formulario");
			mv.addObject("pessoa", entity);

			return mv;
		}
		getService().save(entity);

		return new ModelAndView("redirect:/pessoas");
	}

	@Override
	@GetMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Long id) {
		getService().deleteById(id);

		return new ModelAndView("redirect:/pessoas");
	}
}
