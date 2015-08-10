package uk.co.o2.exercise;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.co.o2.exercies.Engine;
import uk.co.o2.exercies.FuelType;
import uk.co.o2.exercies.InternalCombustionEngine;
import uk.co.o2.exercies.SteamEngine;

public class InternalCombustionEngineTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void createICEWithDifferentFuels() {
		
		Engine engine = new InternalCombustionEngine(FuelType.PETROL);
		assertEquals(FuelType.PETROL, engine.getFuelType());
		
		engine = new InternalCombustionEngine(FuelType.DIESEL);
		assertEquals(FuelType.DIESEL, engine.getFuelType());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createICEWithOtherFuelType() {
		
		new InternalCombustionEngine(FuelType.WOOD);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createICEWithUnknownFuelType() {
		
		new InternalCombustionEngine(null);
		
	}
 
}
