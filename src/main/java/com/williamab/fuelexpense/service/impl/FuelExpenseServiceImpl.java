package com.williamab.fuelexpense.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.williamab.fuelexpense.dto.VeiculoExpenseDTO;
import com.williamab.fuelexpense.model.VeiculoEntity;
import com.williamab.fuelexpense.service.FuelExpenseService;
import com.williamab.fuelexpense.service.VeiculoService;

/**
 * Implementação de {@link FuelExpenseService}.
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

			LocalDate localDate = v.getDataFabricacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			dto.setAno(localDate.getYear());

			Double quantidadeCombustivelGasto = getQuantidadeCombustivelGasto(totalKmCidade, totalKmRodovia, v);
			dto.setQuantidadeCombustivelGasto(quantidadeCombustivelGasto);

			dto.setValorTotalGastoCombustivel(quantidadeCombustivelGasto * precoGasolina);

			return dto;
		}).sorted((o1, o2) -> {
			return o2.getValorTotalGastoCombustivel().compareTo(o1.getValorTotalGastoCombustivel());
		}).toList();

		return dtos;
	}

	/**
	 * Calcula a quantidade de combustível gasto por um veículo em determinada
	 * quilometragem na cidade e na rodovia.
	 * 
	 * @param totalKmCidade  o total de quilômetros percorridos na cidade
	 * @param totalKmRodovia o total de quilômetros percorridos na rodovia
	 * @param veiculo        a entidade do veículo
	 * @return a quantidade de combustível gasto
	 */
	private Double getQuantidadeCombustivelGasto(Double totalKmCidade, Double totalKmRodovia, VeiculoEntity veiculo) {
		return Double.sum(totalKmCidade / veiculo.getConsumoMedioCidade(),
				totalKmRodovia / veiculo.getConsumoMedioRodovia());
	}

}
