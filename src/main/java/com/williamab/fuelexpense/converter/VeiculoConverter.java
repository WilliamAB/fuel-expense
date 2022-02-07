package com.williamab.fuelexpense.converter;

import com.williamab.fuelexpense.dto.VeiculoDTO;
import com.williamab.fuelexpense.model.VeiculoEntity;

/**
 * Conversor entidade/DTO para veículo.
 * 
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
public class VeiculoConverter {

	private static VeiculoConverter INSTANCE;

	public static VeiculoConverter getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VeiculoConverter();
		}
		return INSTANCE;
	}

	private VeiculoConverter() {
	}

	/**
	 * Converte uma entidade de veículo em DTO de veículo.
	 * 
	 * @param entity um {@link VeiculoEntity}
	 * @return um {@link VeiculoDTO}
	 */
	public VeiculoDTO convertEntityToDTO(VeiculoEntity entity) {
		VeiculoDTO dto = new VeiculoDTO();

		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setModelo(entity.getModelo());
		dto.setMarca(entity.getMarca());
		dto.setDataFabricacao(entity.getDataFabricacao());
		dto.setConsumoMedioCidade(entity.getConsumoMedioCidade());
		dto.setConsumoMedioRodovia(entity.getConsumoMedioRodovia());

		return dto;
	}

	/**
	 * Converte um DTO de veículo em uma entidade de veículo.
	 * 
	 * @param dto um {@link VeiculoDTO}
	 * @return um {@link VeiculoEntity}
	 */
	public VeiculoEntity convertDTOToEntity(VeiculoDTO dto) {
		VeiculoEntity entity = new VeiculoEntity();

		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setModelo(dto.getModelo());
		entity.setMarca(dto.getMarca());
		entity.setDataFabricacao(dto.getDataFabricacao());
		entity.setConsumoMedioCidade(dto.getConsumoMedioCidade());
		entity.setConsumoMedioRodovia(dto.getConsumoMedioRodovia());

		return entity;
	}

}
