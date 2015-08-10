package uk.co.o2.exercise;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.co.o2.exercies.Engine;
import uk.co.o2.exercies.FuelType;
import uk.co.o2.exercies.SteamEngine;

public class SteamEngineTest {

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
	public void createSEWithDifferentFuels() {
		
		Engine engine = new SteamEngine(FuelType.COAL);
		assertEquals(FuelType.COAL, engine.getFuelType());
		
		engine = new SteamEngine(FuelType.WOOD);
		assertEquals(FuelType.WOOD, engine.getFuelType());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createSEWithOtherFuelType() {
		
		new SteamEngine(FuelType.DIESEL);
		
	}
	

}
