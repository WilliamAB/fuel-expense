package com.williamab.fuelexpense.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidade que representa um veículo.
 * 
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
@Entity
@Table(name = "veiculo")
public class VeiculoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "marca", nullable = false)
	private String marca;

	@Column(name = "modelo", nullable = false)
	private String modelo;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_fabricacao", nullable = false)
	private Date dataFabricacao;

	@Column(name = "consumo_medio_cidade", nullable = false)
	private Double consumoMedioCidade;

	@Column(name = "consumo_medio_rodovia", nullable = false)
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
