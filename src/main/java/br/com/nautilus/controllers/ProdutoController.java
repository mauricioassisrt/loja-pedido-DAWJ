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
import br.com.nautilus.models.Produto;
import br.com.nautilus.repository.ProdutoRepository;
import br.com.nautilus.services.ProdutoService;


@RestController
@RequestMapping("/produto")
public class ProdutoController extends BaseController<Produto, ProdutoRepository, ProdutoService> {

	@Override
	@GetMapping
	public ModelAndView getPaginaLista(Pageable pageable) {
		Page<Produto> list = getService().findAll(pageable);
		ModelAndView mv = new ModelAndView("/produto/produto-list");
		mv.addObject("page", list);

		return mv;
	}

	@Override
	@GetMapping("/formulario")
	public ModelAndView getPaginaCadastro(Produto entity, Long id) {
		ModelAndView mv = new ModelAndView("/produto/produto-form");
		if (id != null) {
			mv.addObject("produto", getService().findById(id).get());
		} else {
			mv.addObject("produto", entity);
		}

		mv.addObject("unidades", getService().buscarUnidades());
		
		return mv;
	}

	@Override
	@PostMapping("/formulario")
	public ModelAndView salvar(@Valid Produto entity, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("/produto/produto-form");
			mv.addObject("produto", entity);

			return mv;
		}
		getService().save(entity);

		return new ModelAndView("redirect:/produto");
	}

	@Override
	@GetMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Long id) {
		getService().deleteById(id);

		return new ModelAndView("redirect:/produto");
	}
}
