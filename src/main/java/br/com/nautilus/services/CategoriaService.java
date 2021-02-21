package br.com.nautilus.services;

import org.springframework.stereotype.Service;

import br.com.nautilus.base.BaseService;
import br.com.nautilus.models.Categoria;
import br.com.nautilus.repository.CategoriaRepository;



@Service
public class CategoriaService extends BaseService<Categoria, CategoriaRepository>  {

//	@Autowired
//	private UnidadeService unidadeService;
//
//	public List<Unidade> buscarUnidades(){
//		return unidadeService.findAll();
//	}
	
}
