package uk.co.o2.exercise;



import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.co.o2.exercies.Engine;
import uk.co.o2.exercies.FuelType;

public class EngineTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	//Test all the getters
	@Test
	public void testEngineInitialization() {
		
		Engine engine = new Engine(FuelType.PETROL);
		
		assertEquals(FuelType.PETROL, engine.getFuelType());
		assertEquals(false, engine.isRunning());
		assertEquals(engine.getFuelLevel(), 0);
		
	}
	

	@Test(expected=IllegalStateException.class)
	public void startEngineWithoutFuelling() {
		System.out.println("Testing......");
		Engine engine = new Engine(FuelType.PETROL);
		engine.start();
	}
	
	@Test 
	public void startEngineAfterFuelling() {
		
		Engine engine = new Engine(FuelType.PETROL);
		engine.fill(FuelType.PETROL, 50);
		engine.start();
		assertEquals(true, engine.isRunning());
		assertEquals(engine.getFuelLevel(),50);
		assertEquals(FuelType.PETROL, engine.getFuelType());
		assertEquals(FuelType.PETROL, engine.getFilledFuelType());
	}
	
	@Test(expected=IllegalStateException.class)
	public void startEngineByFillingWrongFuel() {
		
		Engine engine = new Engine(FuelType.PETROL);
		engine.fill(FuelType.DIESEL, 50);
		engine.start();
		 
	}
	
	@Test(expected=IllegalStateException.class)
	public void startEngineByFillingInsufficientFuel_1() {
		
		Engine engine = new Engine(FuelType.PETROL);
		engine.fill(FuelType.PETROL, -1);
		engine.start();
		 
	}
	
	@Test(expected=IllegalStateException.class)
	public void startEngineByFillingInsufficientFuel_2() {
		
		Engine engine = new Engine(FuelType.PETROL);
		engine.fill(FuelType.PETROL, 0);
		engine.start();
		 
	}
	
	@Test
	public void startEngineByFillingMaxFuel() {
		
		Engine engine = new Engine(FuelType.PETROL);
		engine.fill(FuelType.PETROL, 100);
		engine.start();
		assertEquals(true,  engine.isRunning());
		assertEquals(FuelType.PETROL, engine.getFuelType());
		assertEquals(FuelType.PETROL, engine.getFilledFuelType());
		
	}
	
	@Test
	public void startEngineByFillingExcessFuel() {
		
		Engine engine = new Engine(FuelType.PETROL);
		engine.fill(FuelType.PETROL, 101);
		engine.start();
		assertEquals(true,  engine.isRunning());
		assertEquals(FuelType.PETROL, engine.getFuelType());
		assertEquals(FuelType.PETROL, engine.getFilledFuelType());
		
	}
	
	@Test
	public void startEngineByFillingSufficientFuel() {
		
		Engine engine = new Engine(FuelType.PETROL);
		engine.fill(FuelType.PETROL, 50);
		engine.start();
		assertEquals(true,  engine.isRunning());
		assertEquals(FuelType.PETROL, engine.getFuelType());
		assertEquals(FuelType.PETROL, engine.getFilledFuelType());
		assertEquals(50, engine.getFuelLevel());
		
	}
	//fillFuel(..) Tests
	@Test
	public void fillInsufficientFuel() {
		
		Engine engine = new Engine(FuelType.PETROL);
		engine.fill(FuelType.PETROL, -1);
		assertEquals(0, engine.getFuelLevel());
		assertEquals(FuelType.PETROL, engine.getFuelType());
		
		engine.fill(FuelType.PETROL, 0);
		assertEquals(0, engine.getFuelLevel());
		assertEquals(FuelType.PETROL, engine.getFuelType());
	}
	
	@Test
	public void fillMaxAndExcessFuel() {
	
		Engine engine = new Engine(FuelType.PETROL);
		engine.fill(FuelType.PETROL, 100);
		assertEquals(100, engine.getFuelLevel());
		assertEquals(FuelType.PETROL, engine.getFuelType());
		
		engine.fill(FuelType.PETROL, 102);
		assertEquals(100, engine.getFuelLevel());
		assertEquals(FuelType.PETROL, engine.getFuelType());
	}
	
	@Test
	public void checkEngineRunningBeforeStarting() {
		Engine engine = new Engine(FuelType.PETROL);
		assertEquals(false, engine.isRunning());
	}

    //redundant as its covered in tests of start(..) mentioned here for completion
	@Test
	public void checkEngineRunningAfterFuellingAndStarting() {
		
		Engine engine = new Engine(FuelType.PETROL);
		engine.fill(FuelType.PETROL, 50);
		engine.start();
		assertEquals(true, engine.isRunning());
	}
	
	@Test
	public void checkEngineRunningAfterStopping() {
		
		Engine engine = new Engine(FuelType.PETROL);
		engine.stop();
		assertEquals(false, engine.isRunning());
	}


}

