package com.williamab.fuelexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.williamab.fuelexpense.model.VeiculoEntity;

/**
 * Repositório para {@link VeiculoEntity}.
 * 
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
public interface VeiculoRepository extends JpaRepository<VeiculoEntity, Long> {

}
