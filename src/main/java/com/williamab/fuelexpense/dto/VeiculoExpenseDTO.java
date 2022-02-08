package com.williamab.fuelexpense.dto;

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
	private Double quantidadeCombustivelGasto;
	private Double valorTotalGastoCombustivel;

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

	public Double getQuantidadeCombustivelGasto() {
		return quantidadeCombustivelGasto;
	}

	public void setQuantidadeCombustivelGasto(Double quantidadeCombustivelGasto) {
		this.quantidadeCombustivelGasto = quantidadeCombustivelGasto;
	}

	public Double getValorTotalGastoCombustivel() {
		return valorTotalGastoCombustivel;
	}

	public void setValorTotalGastoCombustivel(Double valorTotalGastoCombustivel) {
		this.valorTotalGastoCombustivel = valorTotalGastoCombustivel;
	}

}
