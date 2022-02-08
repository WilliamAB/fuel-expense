package com.williamab.fuelexpense.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.williamab.fuelexpense.converter.VeiculoConverter;
import com.williamab.fuelexpense.dto.VeiculoDTO;
import com.williamab.fuelexpense.dto.VeiculoExpenseDTO;
import com.williamab.fuelexpense.model.VeiculoEntity;
import com.williamab.fuelexpense.service.FuelExpenseService;
import com.williamab.fuelexpense.service.VeiculoService;

import io.swagger.v3.oas.annotations.Operation;

/**
 * Controller com requisições para <code>/veiculo</code>.
 * 
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@Autowired
	private FuelExpenseService fuelExpenseService;

	/**
	 * Requisição para salvar um veículo.
	 * 
	 * @param veiculo o veículo a ser salvo
	 * @return a resposta com a entidade salva
	 */
	@PostMapping
	@Operation(summary = "Salva um veículo")
	public ResponseEntity<VeiculoDTO> save(@RequestBody @Valid VeiculoDTO veiculo) {

		// Converte o DTO em entidade
		VeiculoEntity entity = VeiculoConverter.getInstance().convertDTOToEntity(veiculo);

		// Salva a entidade
		entity = veiculoService.save(entity);

		// Converte a entidade salva em DTO
		VeiculoDTO savedDTO = VeiculoConverter.getInstance().convertEntityToDTO(entity);

		return new ResponseEntity<>(savedDTO, HttpStatus.CREATED);
	}

	/**
	 * Requisição para buscar todos os veículos.
	 * 
	 * @return a resposta com a lista de veículos
	 */
	@GetMapping
	@Operation(summary = "Retorna todos os veículos")
	public ResponseEntity<List<VeiculoDTO>> findAll() {

		// Busca todas as entidades
		List<VeiculoEntity> entities = veiculoService.findAll();

		// Converte a lista de entidades em lista de dtos
		List<VeiculoDTO> dtos = entities.stream().map(VeiculoConverter.getInstance()::convertEntityToDTO).toList();

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	/**
	 * Requisição para buscar a lista ranqueada de veículos da empresa levando em
	 * consideração o valor gasto com combustível.
	 * 
	 * @param precoGasolina  o preço da gasolina
	 * @param totalKmCidade  total de km que será percorrido dentro da cidade
	 * @param totalKmRodovia total de km que será percorrido em rodovias
	 * @return a lista ranqueada
	 */
	@GetMapping("/rank")
	@Operation(summary = "Retorna a lista ranqueada de veículos", description = "Retorna a lista ranqueada "
			+ "de veículos da empresa levando em consideração o valor gasto com combustível")
	public ResponseEntity<List<VeiculoExpenseDTO>> getRankedFuelExpense(
			@RequestParam(name = "precoGasolina") Double precoGasolina,
			@RequestParam(name = "totalKmCidade") Double totalKmCidade,
			@RequestParam(name = "totalKmRodovia") Double totalKmRodovia) {

		// Busca a lista ranqueada conforme parâmetros
		List<VeiculoExpenseDTO> rankedList = fuelExpenseService.getRankedList(precoGasolina, totalKmCidade,
				totalKmRodovia);

		return new ResponseEntity<>(rankedList, HttpStatus.OK);
	}

}
