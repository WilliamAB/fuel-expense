package com.williamab.fuelexpense.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.williamab.fuelexpense.model.VeiculoEntity;
import com.williamab.fuelexpense.repository.VeiculoRepository;
import com.williamab.fuelexpense.service.VeiculoService;

/**
 * Implementação de {@link VeiculoService}.
 * 
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	private VeiculoRepository repository;

	@Override
	public VeiculoEntity save(VeiculoEntity veiculo) {
		return repository.save(veiculo);
	}

	@Override
	public List<VeiculoEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
