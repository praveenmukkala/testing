 
package uk.co.o2.exercies;

public class WidgetMachine {
	
    private Engine engine ;
    
    private EngineType engineType;
    
    //defaults to the existing behaviour
    public WidgetMachine() {
    	
    	engine = new InternalCombustionEngine(FuelType.PETROL);
    	
    	this.engineType = EngineType.INTERNAL_COMBUSTION;
    }
    
    //if you need a specific engine type
    public WidgetMachine(EngineType engineType) {
    	
    	if(engineType == EngineType.INTERNAL_COMBUSTION) {
    		
    		engine = new InternalCombustionEngine(FuelType.PETROL);
    		
    		this.engineType = engineType;
    	
    	}else if(engineType == EngineType.STEAM) {

    		//default to WOOD as that seems to be comparatively less cost
    		engine = new SteamEngine(FuelType.WOOD);
    	    
    		this.engineType = engineType;
    	      
    	}
    	else 
    		throw new IllegalArgumentException("Engine Type not recognized ..");
    	
    }
    
    //Constructor if you need a  specific combination of engine and fuel type to produce.
    //Fuel type compatibility to an engine type logic is part  of individual Engine type
    public WidgetMachine(EngineType engineType, FuelType requiredFuelType)
    {
    	if(engineType == EngineType.INTERNAL_COMBUSTION) {
    		
    		engine = new InternalCombustionEngine(requiredFuelType);
    		
    		this.engineType = engineType; 
    	
    	} else if (engineType == EngineType.STEAM) {
    	
    		engine = new SteamEngine(requiredFuelType);
    	    
    		this.engineType = engineType;
    		
    	}else throw new IllegalArgumentException("Engine Type not recognized");
    }
    
    
    public float produceWidgets(int quantity) {
        engine.start();
        float cost = 0f;

        if (engine.isRunning()) {
            cost = produce(quantity);
        }

        engine.stop();

        return cost;
    }


    private float produce(int quantity) {
        int batch = 0;
        int batchCount = 0;
        float costPerBatch = 0;
        float cost = 0;
        
        if(engine.getFuelType() == FuelType.PETROL || engine.getFuelType() == FuelType.DIESEL) {
	    
        	if (engine.getFuelType() == FuelType.PETROL) {
        		
	            costPerBatch = 9;
	        
        	} else { costPerBatch = 12;  } 
	
	        while (batch < quantity) {

	        	batch = batch + 8;
	            batchCount++;
	            
	        }

           cost = batchCount * costPerBatch;
        }
    

        if(engine.getFuelType() == FuelType.COAL || engine.getFuelType() == FuelType.WOOD) {
        	
	        if (engine.getFuelType() == FuelType.COAL) {
	            costPerBatch = 5.65f;
	        } else   { costPerBatch = 4.35f;  } 
	
	        while (batch < quantity) {
	            batch = batch + 2;
	            batchCount++;
	        }
	        
	        cost =  batchCount * costPerBatch;
        }
    
        return cost;
    }
    
    
    public void  fillFuel(FuelType fuelType, int fuelLevel) {  
    	engine.fill(fuelType, fuelLevel);
    }

    public EngineType getEngineType() {
    	
    	return this.engineType;
    }
    
    public FuelType getFuelType() {
    	
    	return this.engine.getFuelType();
    }
}
