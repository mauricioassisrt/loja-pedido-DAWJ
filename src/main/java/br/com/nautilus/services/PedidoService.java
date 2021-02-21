package br.com.nautilus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nautilus.base.BaseService;
import br.com.nautilus.models.Pedido;
import br.com.nautilus.models.Pessoa;
import br.com.nautilus.repository.PedidoRepository;
@Service
public class PedidoService extends BaseService<Pedido, PedidoRepository> {
	@Autowired
	private PessoaService pessoaService;

	public List<Pessoa> buscarPessoas(){
		return pessoaService.findAll();
	}
}
