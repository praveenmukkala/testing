package uk.co.o2.exercies;

/**
 * SteamEngine Class
 * 
 * @author THBS
 *
 *
 */
public class SteamEngine extends Engine {

    public SteamEngine(FuelType requiredFuelType) {
    	
    	super(requiredFuelType);

    	if(requiredFuelType != FuelType.WOOD && requiredFuelType != FuelType.COAL )
    		
    		throw new IllegalArgumentException("Trying to initialize Steam Engine with wrong fuel type");

    }
}
