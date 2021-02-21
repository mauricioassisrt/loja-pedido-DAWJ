package br.com.nautilus.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public abstract class BaseController<ENTITY extends BaseEntity, REPOSITORY extends BaseRespository<ENTITY>, SERVICE extends BaseService<ENTITY, REPOSITORY>> {

	public static final int PAGE_SIZE = 5;

	@Autowired
	protected SERVICE service;

	public SERVICE getService() {
		return service;
	}

	public abstract ModelAndView getPaginaLista(Pageable pageable);

	public abstract ModelAndView getPaginaCadastro(ENTITY entity, Long id);

	public abstract ModelAndView salvar(ENTITY entity, BindingResult bindingResult);

	public abstract ModelAndView remover(Long id);
}
