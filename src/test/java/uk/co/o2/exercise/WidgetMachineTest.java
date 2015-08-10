package uk.co.o2.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import uk.co.o2.exercies.EngineType;
import uk.co.o2.exercies.FuelType;
import uk.co.o2.exercies.WidgetMachine;

/**
 * Unit test for simple App.
 */

public class WidgetMachineTest 
     
{
    //==================No-Arg constructor  tests starts============================================
     @Test
    public void createDefaultEngine() {
    
        WidgetMachine wm = new WidgetMachine();
 
        //ensure the widget m/c not null
        assertNotNull(wm);
        
        //Error if Engine is not Internal Combustion and fuel type used is Petrol
        assertEquals(EngineType.INTERNAL_COMBUSTION, wm.getEngineType());
        assertEquals(FuelType.PETROL, wm.getFuelType());
        
     }
     //==================No-Arg constructor  tests ends ============================================
     
     //==================WidgetMachine(EngineType) constructor tests starts============================================
     //create a ICE ( petrol should have been used to create the engine)
     @Test
     public void createInternalCombustionEngine() {
    	 
    	 WidgetMachine wm = new WidgetMachine(EngineType.INTERNAL_COMBUSTION);
    	 
    	 assertNotNull(wm);
    	 
    	 //Error if Engine is not Internal Combustion and fuel used is Petrol
    	 assertEquals(EngineType.INTERNAL_COMBUSTION, wm.getEngineType());
    	 assertEquals(FuelType.PETROL, wm.getFuelType());
     }
     
     //create a SE ( Wood should have been used to create the engine)
     @Test
     public void createSteamEngine() {
    	 
    	 WidgetMachine wm = new WidgetMachine(EngineType.STEAM);
    	 
    	 assertNotNull(wm);
    	 
    	 //Error if Engine is not Steam and fuel used is wood
    	 assertEquals(EngineType.STEAM, wm.getEngineType());
    	 assertEquals(FuelType.WOOD, wm.getFuelType());
     }
     
    //ensure you are not able to create an unknown engines
    @Test(expected=IllegalArgumentException.class)
    public void createUnknownEngine() {
    	
    	new WidgetMachine(null);
    }
    //===================WidgetMachine(EngineType) constructor tests ends============================================
    
    //===================WidgetMachine(EngineType, FuelType) constructor 3 tests starts===========================================
    
    //create an ICE with Petrol & Diesel 
    @Test
    public void createICEWithFuelTypes() {
    	
    	 WidgetMachine wm = new WidgetMachine(EngineType.INTERNAL_COMBUSTION, FuelType.PETROL);
    	 assertNotNull(wm);
    	 
    	//Ensure you are able to create a ICE with Petrol 
    	 assertEquals(EngineType.INTERNAL_COMBUSTION, wm.getEngineType());
    	 assertEquals(FuelType.PETROL, wm.getFuelType());
    	 
    	 //Ensure you are able to create a ICE with Diesel
    	 wm = new WidgetMachine(EngineType.INTERNAL_COMBUSTION, FuelType.DIESEL);
    	 assertEquals(EngineType.INTERNAL_COMBUSTION, wm.getEngineType());
    	 assertEquals(FuelType.DIESEL, wm.getFuelType());
    }
    
    //create an SE with Wood & Coal 
    @Test
    public void createSEWithWoodAndCoal() {

   	 WidgetMachine wm = new WidgetMachine(EngineType.STEAM, FuelType.WOOD);
   	 assertNotNull(wm);
   	 
   	 //Ensure you are able to create a Steam Engine with Wood
   	 assertEquals(EngineType.STEAM, wm.getEngineType());
   	 assertEquals(FuelType.WOOD, wm.getFuelType());
   	 
     //Ensure you are able to create a Steam Engine with Coal
   	 wm = new WidgetMachine(EngineType.STEAM, FuelType.COAL);
   	 assertEquals(EngineType.STEAM, wm.getEngineType());
   	 assertEquals(FuelType.COAL, wm.getFuelType());

    }
     
    //check  for an invalid engine type.
    @Test(expected=IllegalArgumentException.class)
    public void createSEWithFuelTypePetrol() {
    	
        new WidgetMachine(null, FuelType.PETROL);
    	
    }
    //checking for an invalid fuel type is part of the Engine constructors hence
    //not included here and must be part of EngineTests
    
    //==================WidgetMachine(EngineType, FuelType) constructor tests ends===========================================
    
    
    //try producing widgets without filling the engine with fuel
    @Test(expected=IllegalStateException.class)
    public void produceWidgetsWithoutFillingFuel() {
    	 WidgetMachine wm = new WidgetMachine(EngineType.STEAM, FuelType.WOOD);
    	 wm.produceWidgets(10);
    	
    }
   
    //===================Widget Production with different engine types and fuel types tests start====================
    
    
    //produce widgets with default ICE & fuel type
    @Test 
    public void produceWidgetsWithPetrol() {
    	
    	//anyway default engine is with ICE & Petrol combination 
    	WidgetMachine wm = new WidgetMachine();

    	wm.fillFuel(FuelType.PETROL, 90);

        //produce several widgets and see if the cost is appropriate    	
    	assertEquals(1 * 9.0f, wm.produceWidgets(5), 0.001);
    	assertEquals(1 * 9.0f, wm.produceWidgets(8), 0.001);
    	assertEquals(2 * 9.0f, wm.produceWidgets(10), 0.001);
    	assertEquals(2 * 9.0f, wm.produceWidgets(16), 0.001);
    	assertEquals(3 * 9.0f, wm.produceWidgets(18), 0.001);
    	
    }

    //produce widgets using SE and Wood as fuel
    @Test 
    public void produceWidgetsWithSteamEngineAndDefaultFuel() {
    	
    	//anyway default engine is with ICE & Petrol combination 
    	WidgetMachine wm = new WidgetMachine(EngineType.STEAM);

    	wm.fillFuel(FuelType.WOOD, 90);

        //produce several widgets and see if the cost is appropriate    	
    	assertEquals(1 * 4.35f, wm.produceWidgets(1), 0.001);
    	assertEquals(1 * 4.35f, wm.produceWidgets(2), 0.001);
    	assertEquals(2 * 4.35f, wm.produceWidgets(3), 0.001);
    	assertEquals(2 * 4.35f, wm.produceWidgets(4), 0.001);
    	assertEquals(3 * 4.35f, wm.produceWidgets(5), 0.001);
    	
    }        
    
    //produce widgets using ICE and Petrol as fuel
    @Test 
    public void produceWidgetsWithICEngineAndDefaultFuel() {
    	
    	//anyway default engine is with ICE & Petrol combination 
    	WidgetMachine wm = new WidgetMachine(EngineType.INTERNAL_COMBUSTION);

    	wm.fillFuel(FuelType.PETROL, 90);

        //produce several widgets and see if the cost is appropriate    	
    	assertEquals(1 * 9.0f, wm.produceWidgets(5), 0.001);
    	assertEquals(1 * 9.0f, wm.produceWidgets(8), 0.001);
    	assertEquals(2 * 9.0f, wm.produceWidgets(10), 0.001);
    	assertEquals(2 * 9.0f, wm.produceWidgets(16), 0.001);
    	assertEquals(3 * 9.0f, wm.produceWidgets(18), 0.001);
    	
    }
        
    //produce widgets with ICE & Petrol
    @Test 
    public void produceWidgetsWithICEngineAndPetrolFuel() {
    	
    	//anyway default engine is with ICE & Petrol combination 
    	WidgetMachine wm = new WidgetMachine(EngineType.INTERNAL_COMBUSTION, FuelType.PETROL);

    	wm.fillFuel(FuelType.PETROL, 90);

        //produce several widgets and see if the cost is appropriate    	
    	assertEquals(1 * 9.0f, wm.produceWidgets(5), 0.001);
    	assertEquals(1 * 9.0f, wm.produceWidgets(8), 0.001);
    	assertEquals(2 * 9.0f, wm.produceWidgets(10), 0.001);
    	assertEquals(2 * 9.0f, wm.produceWidgets(16), 0.001);
    	assertEquals(3 * 9.0f, wm.produceWidgets(18), 0.001);
    	
    }
    
    //produce widgets with ICE & Diesel
    @Test 
    public void produceWidgetsWithICEngineAndDieselFuel() {
    	
    	//anyway default engine is with ICE & Petrol combination 
    	WidgetMachine wm = new WidgetMachine(EngineType.INTERNAL_COMBUSTION, FuelType.DIESEL);

    	wm.fillFuel(FuelType.DIESEL, 90);

        //produce several widgets and see if the cost is appropriate    	
    	assertEquals(1 * 12.0f, wm.produceWidgets(5), 0.001);
    	assertEquals(1 * 12.0f, wm.produceWidgets(8), 0.001);
    	assertEquals(2 * 12.0f, wm.produceWidgets(10), 0.001);
    	assertEquals(2 * 12.0f, wm.produceWidgets(16), 0.001);
    	assertEquals(3 * 12.0f, wm.produceWidgets(18), 0.001);
    	
    }
    

    //produce widgets with SE and Coal
    @Test 
    public void produceWidgetsWithSteamEngineAndCoalFuel() {
    	
    	//anyway default engine is with ICE & Petrol combination 
    	WidgetMachine wm = new WidgetMachine(EngineType.STEAM, FuelType.COAL);

    	wm.fillFuel(FuelType.COAL, 90);

        //produce several widgets and see if the cost is appropriate    	
    	assertEquals(1 * 5.65f, wm.produceWidgets(1), 0.001);
    	assertEquals(1 * 5.65f, wm.produceWidgets(2), 0.001);
    	assertEquals(2 * 5.65f, wm.produceWidgets(3), 0.001);
    	assertEquals(2 * 5.65f, wm.produceWidgets(4), 0.001);
    	assertEquals(3 * 5.65f, wm.produceWidgets(5), 0.001);
    	
    }    
    
    //produce widgets with SE and wood
    @Test 
    public void produceWidgetsWithSteamEngineAndWoodFuel() {
    	
    	//anyway default engine is with ICE & Petrol combination 
    	WidgetMachine wm = new WidgetMachine(EngineType.STEAM, FuelType.WOOD);

    	wm.fillFuel(FuelType.WOOD, 90);

        //produce several widgets and see if the cost is appropriate    	
    	assertEquals(1 * 4.35f, wm.produceWidgets(1), 0.001);
    	assertEquals(1 * 4.35f, wm.produceWidgets(2), 0.001);
    	assertEquals(2 * 4.35f, wm.produceWidgets(3), 0.001);
    	assertEquals(2 * 4.35f, wm.produceWidgets(4), 0.001);
    	assertEquals(3 * 4.35f, wm.produceWidgets(5), 0.001);
    	
    }
    
    //check what engine type you are seeing after creating different engines
    @Test
    public void getEngineTypeTests() {
    	
    	WidgetMachine defualt = new  WidgetMachine();
    	assertEquals(EngineType.INTERNAL_COMBUSTION, defualt.getEngineType());
    	
    	WidgetMachine ICE = new WidgetMachine(EngineType.INTERNAL_COMBUSTION);
    	assertEquals(EngineType.INTERNAL_COMBUSTION, ICE.getEngineType());
    	
    	WidgetMachine SE = new WidgetMachine(EngineType.STEAM);
    	assertEquals(EngineType.STEAM, SE.getEngineType());
    	
    	WidgetMachine petrolICE = new WidgetMachine(EngineType.INTERNAL_COMBUSTION, FuelType.PETROL); 
    	assertEquals(EngineType.INTERNAL_COMBUSTION, petrolICE.getEngineType());
    			
        WidgetMachine diesellICE =  new WidgetMachine(EngineType.INTERNAL_COMBUSTION, FuelType.DIESEL); 
        assertEquals(EngineType.INTERNAL_COMBUSTION, diesellICE.getEngineType());	    			
    	
    	WidgetMachine woodSE = new WidgetMachine(EngineType.STEAM, FuelType.WOOD); 
    	assertEquals(EngineType.STEAM, woodSE.getEngineType());
    			
        WidgetMachine coalSE =  new WidgetMachine(EngineType.STEAM, FuelType.COAL); 
        assertEquals(EngineType.STEAM, coalSE.getEngineType());	   
    	
    	
    }
    

}
