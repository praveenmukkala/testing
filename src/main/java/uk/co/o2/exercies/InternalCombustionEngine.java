 
package uk.co.o2.exercies;

public class InternalCombustionEngine extends Engine {

    public InternalCombustionEngine(FuelType requiredFuelType) {
    	
    	super(requiredFuelType);

    	if(requiredFuelType != FuelType.PETROL && requiredFuelType != FuelType.DIESEL)
    		throw new IllegalArgumentException("Trying to initialize Internal Combustion Engine with wrong fuel type");

    }
    

  
}
