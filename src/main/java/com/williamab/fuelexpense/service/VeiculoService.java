package com.williamab.fuelexpense.service;

import java.util.List;

import com.williamab.fuelexpense.model.VeiculoEntity;

/**
 * Servi�o de manuten��o dos dados de {@link VeiculoEntity}.
 * 
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
public interface VeiculoService {

	/**
	 * Salva um ve�culo, podendo ser uma inclus�o ou altera��o de dados.
	 * 
	 * @param veiculo a entidade a ser salva
	 * @return a entidade salva
	 */
	VeiculoEntity save(VeiculoEntity veiculo);

	/**
	 * Busca todos os ve�culos cadastrados.
	 * 
	 * @return uma lista de ve�culos
	 */
	List<VeiculoEntity> findAll();

	/**
	 * Deleta um ve�culo a partir do id.
	 * 
	 * @param id o id do ve�culo a ser deletado
	 */
	void deleteById(Long id);

}
