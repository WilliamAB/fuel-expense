package com.williamab.fuelexpense.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import com.williamab.fuelexpense.dto.VeiculoExpenseDTO;

/**
 * Testes para {@link FuelExpenseService}.
 * 
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
@SpringBootTest
@WebAppConfiguration
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class FuelExpenseServiceTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private FuelExpenseService service;

	private final Double precoGasolina = 6.5;
	private final Double totalKmCidade = 150.0;
	private final Double totalKmRodovia = 80.5;

	@Test
	public void testService() {
		assertNotNull(service);
	}

	@Test(dependsOnMethods = "testService")
	public void testFindAll() {
		List<VeiculoExpenseDTO> rankedList = service.getRankedList(precoGasolina, totalKmCidade, totalKmRodovia);
		assertFalse(rankedList.isEmpty());
	}

}
