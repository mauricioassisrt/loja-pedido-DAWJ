package br.com.nautilus.services;

import org.springframework.stereotype.Service;

import br.com.nautilus.base.BaseService;
import br.com.nautilus.models.Pessoa;
import br.com.nautilus.models.Produto;
import br.com.nautilus.repository.PessoaRepository;
import br.com.nautilus.repository.ProdutoRepository;
@Service
public class PessoaService extends BaseService<Pessoa, PessoaRepository>  {

}
