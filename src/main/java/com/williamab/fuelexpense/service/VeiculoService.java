package com.williamab.fuelexpense.service;

import java.util.List;

import com.williamab.fuelexpense.model.VeiculoEntity;

/**
 * Serviço de manutenção dos dados de {@link VeiculoEntity}.
 * 
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
public interface VeiculoService {

	/**
	 * Salva um veículo, podendo ser uma inclusão ou alteração de dados.
	 * 
	 * @param veiculo a entidade a ser salva
	 * @return a entidade salva
	 */
	VeiculoEntity save(VeiculoEntity veiculo);

	/**
	 * Busca todos os veículos cadastrados.
	 * 
	 * @return uma lista de veículos
	 */
	List<VeiculoEntity> findAll();

	/**
	 * Deleta um veículo a partir do id.
	 * 
	 * @param id o id do veículo a ser deletado
	 */
	void deleteById(Long id);

}
