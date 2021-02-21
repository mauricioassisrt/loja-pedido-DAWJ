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
import br.com.nautilus.models.Categoria;
import br.com.nautilus.repository.CategoriaRepository;
import br.com.nautilus.services.CategoriaService;

@RestController
@RequestMapping("categoria")
public class CategoriaController extends BaseController<Categoria, CategoriaRepository, CategoriaService> {

	@Override
	@GetMapping
	public ModelAndView getPaginaLista(Pageable pageable) {
		Page<Categoria> list = getService().findAll(pageable);
		ModelAndView mv = new ModelAndView("categoria/categoria-list");
		mv.addObject("page", list);
		System.out.print("INDEX "+list.getSize()+" \n");
		return mv;
	}

	@Override
	@GetMapping("/formulario")
	public ModelAndView getPaginaCadastro(Categoria entity, Long id) {
		ModelAndView mv = new ModelAndView("categoria/categoria-form");
		if (id != null) {
			mv.addObject("categoria", getService().findById(id).get());
			System.out.print("EDIT REGISTRo "+id);
		} else {
			System.out.print(" NOVO REGISTRO ");
			mv.addObject("categoria", entity);
		}
		System.out.print(mv);
		return mv;
	}

	@Override
	@PostMapping("formulario")
	public ModelAndView salvar(@Valid Categoria entity, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("categoria/categoria-form");
			mv.addObject("categoria", entity);
			return mv;
		}
		getService().save(entity);
		System.out.println("SALVAR");
		return new ModelAndView("redirect:");
	}

	@Override
	@GetMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Long id) {
		getService().deleteById(id);
		System.out.print("REMOVER ");
		return new ModelAndView("redirect:/categoria");
	}
}
