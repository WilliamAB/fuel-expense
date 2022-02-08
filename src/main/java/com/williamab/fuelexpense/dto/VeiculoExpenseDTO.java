package com.williamab.fuelexpense.dto;

import java.math.BigDecimal;

/**
 * DTO (Data Transfer Object) para informações do veículo e gasto com
 * combustível.
 * 
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
public class VeiculoExpenseDTO {

	private String nome;
	private String marca;
	private String modelo;
	private Integer ano;
	private BigDecimal quantidadeCombustivelGasto;
	private BigDecimal valorTotalGastoCombustivel;

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

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public BigDecimal getQuantidadeCombustivelGasto() {
		return quantidadeCombustivelGasto;
	}

	public void setQuantidadeCombustivelGasto(BigDecimal quantidadeCombustivelGasto) {
		this.quantidadeCombustivelGasto = quantidadeCombustivelGasto;
	}

	public BigDecimal getValorTotalGastoCombustivel() {
		return valorTotalGastoCombustivel;
	}

	public void setValorTotalGastoCombustivel(BigDecimal valorTotalGastoCombustivel) {
		this.valorTotalGastoCombustivel = valorTotalGastoCombustivel;
	}

}
