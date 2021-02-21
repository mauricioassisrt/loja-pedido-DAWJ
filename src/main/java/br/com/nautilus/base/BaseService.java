package br.com.nautilus.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BaseService<ENTITY extends BaseEntity, REPOSITORY extends BaseRespository<ENTITY>> {

	@Autowired
	protected REPOSITORY repo;

	public REPOSITORY getReporitoy() {
		return repo;
	}

	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	public Optional<ENTITY> findById(Long id) {
		return repo.findById(id);
	}

	public void update(ENTITY entity) {
		repo.save(entity);
	}
	
	public List<ENTITY> findAll() {
		return repo.findAll();
	}

	public Page<ENTITY> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public ENTITY save(ENTITY entity) {
		return repo.save(entity);
	}

}