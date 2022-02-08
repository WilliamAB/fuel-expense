package com.williamab.fuelexpense.service;

import java.util.List;

import com.williamab.fuelexpense.dto.VeiculoExpenseDTO;

/**
 * Serviço de cálculo de gasto de combustível.
 * 
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
public interface FuelExpenseService {

	/**
	 * Retorna uma lista ranqueada dos veículos da empresa levando em consideração o
	 * valor gasto com combustível.
	 * 
	 * @param precoGasolina  o preço da gasolina
	 * @param totalKmCidade  o total de quilômetros que será percorrido dentro da
	 *                       cidade
	 * @param totalKmRodovia o total de quilômetros que será percorrido em rodovias
	 * @return a lista ranqueada
	 */
	List<VeiculoExpenseDTO> getRankedList(Double precoGasolina, Double totalKmCidade, Double totalKmRodovia);

}
