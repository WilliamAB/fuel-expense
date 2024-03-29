package com.williamab.fuelexpense.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.williamab.fuelexpense.dto.VeiculoExpenseDTO;
import com.williamab.fuelexpense.model.VeiculoEntity;
import com.williamab.fuelexpense.service.FuelExpenseService;
import com.williamab.fuelexpense.service.VeiculoService;

/**
 * Implementa��o de {@link FuelExpenseService}.
 * 
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
@Service
public class FuelExpenseServiceImpl implements FuelExpenseService {

	@Autowired
	private VeiculoService veiculoService;

	@Override
	public List<VeiculoExpenseDTO> getRankedList(Double precoGasolina, Double totalKmCidade, Double totalKmRodovia) {

		List<VeiculoEntity> veiculos = veiculoService.findAll();

		List<VeiculoExpenseDTO> dtos = veiculos.stream().map(v -> {

			VeiculoExpenseDTO dto = new VeiculoExpenseDTO();

			dto.setNome(v.getNome());
			dto.setModelo(v.getModelo());
			dto.setMarca(v.getMarca());

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(v.getDataFabricacao());
			dto.setAno(calendar.get(Calendar.YEAR));

			Double quantidadeCombustivelGasto = getQuantidadeCombustivelGasto(totalKmCidade, totalKmRodovia, v);

			dto.setQuantidadeCombustivelGasto(
					new BigDecimal(quantidadeCombustivelGasto).setScale(2, RoundingMode.HALF_DOWN));

			dto.setValorTotalGastoCombustivel(
					new BigDecimal(quantidadeCombustivelGasto * precoGasolina).setScale(2, RoundingMode.HALF_DOWN));

			return dto;
		}).sorted((o1, o2) -> {
			return o2.getValorTotalGastoCombustivel().compareTo(o1.getValorTotalGastoCombustivel());
		}).toList();

		return dtos;
	}

	/**
	 * Calcula a quantidade de combust�vel gasto por um ve�culo em determinada
	 * quilometragem na cidade e na rodovia.
	 * 
	 * @param totalKmCidade  o total de quil�metros percorridos na cidade
	 * @param totalKmRodovia o total de quil�metros percorridos na rodovia
	 * @param veiculo        a entidade do ve�culo
	 * @return a quantidade de combust�vel gasto
	 */
	private Double getQuantidadeCombustivelGasto(Double totalKmCidade, Double totalKmRodovia, VeiculoEntity veiculo) {
		return Double.sum(totalKmCidade / veiculo.getConsumoMedioCidade(),
				totalKmRodovia / veiculo.getConsumoMedioRodovia());
	}

}
