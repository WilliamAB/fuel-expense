package com.williamab.fuelexpense.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import com.williamab.fuelexpense.model.VeiculoEntity;

/**
 * Testes para {@link VeiculoService}.
 * 
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
@SpringBootTest
@WebAppConfiguration
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class VeiculoServiceTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private VeiculoService service;

	private final String nome = "Teste Nome";
	private final String marca = "Teste Marca";
	private final String modelo = "Teste Modelo";
	private final Date dataFabricacao = new GregorianCalendar(2020, 1, 1).getTime();
	private final Double consumoMedioCidade = 12.34;
	private final Double consumoMedioRodovia = 15.67;

	@Test
	public void testService() {
		assertNotNull(service);
	}

	@Test(dependsOnMethods = "testService")
	public void testSave() {
		VeiculoEntity entity = new VeiculoEntity();

		entity.setNome(nome);
		entity.setMarca(marca);
		entity.setModelo(modelo);
		entity.setDataFabricacao(dataFabricacao);
		entity.setConsumoMedioCidade(consumoMedioCidade);
		entity.setConsumoMedioRodovia(consumoMedioRodovia);

		entity = service.save(entity);

		assertNotNull(entity);
		assertNotNull(entity.getId());
		assertEquals(nome, entity.getNome());
		assertEquals(marca, entity.getMarca());
		assertEquals(modelo, entity.getModelo());
		assertEquals(dataFabricacao, entity.getDataFabricacao());
		assertEquals(consumoMedioCidade, entity.getConsumoMedioCidade());
		assertEquals(consumoMedioRodovia, entity.getConsumoMedioRodovia());
	}

	@Test(dependsOnMethods = "testSave")
	public void testFindAll() {
		List<VeiculoEntity> entities = service.findAll();

		assertFalse(entities.isEmpty());

		VeiculoEntity entity = entities.get(0);

		assertNotNull(entity);
		assertNotNull(entity.getId());
		assertEquals(nome, entity.getNome());
		assertEquals(marca, entity.getMarca());
		assertEquals(modelo, entity.getModelo());
		assertEquals(dataFabricacao, entity.getDataFabricacao());
		assertEquals(consumoMedioCidade, entity.getConsumoMedioCidade());
		assertEquals(consumoMedioRodovia, entity.getConsumoMedioRodovia());
	}

	@Test(dependsOnMethods = { "testSave", "testFindAll" })
	public void testDeleteById() {
		List<VeiculoEntity> entities = service.findAll();
		VeiculoEntity entity = entities.get(0);

		service.deleteById(entity.getId());

		List<VeiculoEntity> emptyEntities = service.findAll();
		assertTrue(emptyEntities.isEmpty());
	}

	@Test(dependsOnMethods = "testDeleteById")
	public void testSaveExternal() {
		VeiculoEntity entity = new VeiculoEntity();

		entity.setNome(nome);
		entity.setMarca(marca);
		entity.setModelo(modelo);
		entity.setDataFabricacao(dataFabricacao);
		entity.setConsumoMedioCidade(consumoMedioCidade);
		entity.setConsumoMedioRodovia(consumoMedioRodovia);

		entity = service.save(entity);

		assertNotNull(entity);
		assertNotNull(entity.getId());
		assertEquals(nome, entity.getNome());
		assertEquals(marca, entity.getMarca());
		assertEquals(modelo, entity.getModelo());
		assertEquals(dataFabricacao, entity.getDataFabricacao());
		assertEquals(consumoMedioCidade, entity.getConsumoMedioCidade());
		assertEquals(consumoMedioRodovia, entity.getConsumoMedioRodovia());
	}

}
