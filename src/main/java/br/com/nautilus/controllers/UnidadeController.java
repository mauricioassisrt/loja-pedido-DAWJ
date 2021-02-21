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
import br.com.nautilus.models.Unidade;
import br.com.nautilus.repository.UnidadeRepository;
import br.com.nautilus.services.UnidadeService;

@RestController
@RequestMapping("unidade")
public class UnidadeController extends BaseController<Unidade, UnidadeRepository, UnidadeService> {

	@Override
	@GetMapping
	public ModelAndView getPaginaLista(Pageable pageable) {
		Page<Unidade> list = getService().findAll(pageable);
		ModelAndView mv = new ModelAndView("/unidade/unidade-list");
		mv.addObject("page", list);

		return mv;
	}

	@Override
	@GetMapping("/formulario")
	public ModelAndView getPaginaCadastro(Unidade entity, Long id) {
		ModelAndView mv = new ModelAndView("/unidade/unidade-form");
		if (id != null) {
			mv.addObject("unidade", getService().findById(id).get());
		} else {
			mv.addObject("unidade", entity);
		}

		return mv;
	}

	@Override
	@PostMapping("/formulario")
	public ModelAndView salvar(@Valid Unidade entity, BindingResult bindingResult) {
		
			if (bindingResult.hasErrors()) {
				ModelAndView mv = new ModelAndView("/unidade/unidade-form");
				mv.addObject("unidade", entity);

				return mv;
			}
			getService().save(entity);

			return new ModelAndView("redirect:/unidade");
		
		
	}

	@Override
	@GetMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Long id) {
		getService().deleteById(id);

		return new ModelAndView("redirect:/unidade");
	}
}
