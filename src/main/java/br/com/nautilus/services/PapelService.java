package br.com.nautilus.services;

import org.springframework.stereotype.Service;

import br.com.nautilus.base.BaseService;
import br.com.nautilus.models.Categoria;
import br.com.nautilus.models.Papel;
import br.com.nautilus.models.Permisao;
import br.com.nautilus.repository.CategoriaRepository;
import br.com.nautilus.repository.PapelRepository;

@Service
public class PapelService extends BaseService<Papel, PapelRepository>  {

}
