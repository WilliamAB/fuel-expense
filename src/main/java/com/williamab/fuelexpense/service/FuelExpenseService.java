package com.williamab.fuelexpense.service;

import java.util.List;

import com.williamab.fuelexpense.dto.VeiculoExpenseDTO;

/**
 * Servi�o de c�lculo de gasto de combust�vel.
 * 
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
public interface FuelExpenseService {

	/**
	 * Retorna uma lista ranqueada dos ve�culos da empresa levando em considera��o o
	 * valor gasto com combust�vel.
	 * 
	 * @param precoGasolina  o pre�o da gasolina
	 * @param totalKmCidade  o total de quil�metros que ser� percorrido dentro da
	 *                       cidade
	 * @param totalKmRodovia o total de quil�metros que ser� percorrido em rodovias
	 * @return a lista ranqueada
	 */
	List<VeiculoExpenseDTO> getRankedList(Double precoGasolina, Double totalKmCidade, Double totalKmRodovia);

}
