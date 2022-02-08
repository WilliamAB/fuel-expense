package com.williamab.fuelexpense.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO (Data Transfer Object) para veículo.
 * 
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
public class VeiculoDTO {

	private Long id;

	@NotNull(message = "Nome deve ser informado!")
	private String nome;

	@NotNull(message = "Marca deve ser informada!")
	private String marca;

	@NotNull(message = "Modelo deve ser informado!")
	private String modelo;

	@NotNull(message = "Data de fabricação deve ser informada!")
	@Schema(example = "01/01/2022", pattern = "dd/MM/yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataFabricacao;

	@NotNull(message = "Consumo médio na cidade deve ser informado!")
	private Double consumoMedioCidade;

	@NotNull(message = "Consumo médio na rodovia deve ser informado!")
	private Double consumoMedioRodovia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Double getConsumoMedioCidade() {
		return consumoMedioCidade;
	}

	public void setConsumoMedioCidade(Double consumoMedioCidade) {
		this.consumoMedioCidade = consumoMedioCidade;
	}

	public Double getConsumoMedioRodovia() {
		return consumoMedioRodovia;
	}

	public void setConsumoMedioRodovia(Double consumoMedioRodovia) {
		this.consumoMedioRodovia = consumoMedioRodovia;
	}

}
