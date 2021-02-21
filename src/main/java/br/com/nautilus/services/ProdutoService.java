package br.com.nautilus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nautilus.base.BaseService;
import br.com.nautilus.models.Produto;
import br.com.nautilus.models.Unidade;
import br.com.nautilus.repository.ProdutoRepository;


@Service
public class ProdutoService extends BaseService<Produto, ProdutoRepository>  {

	@Autowired
	private UnidadeService unidadeService;

	public List<Unidade> buscarUnidades(){
		return unidadeService.findAll();
	}
	
}
