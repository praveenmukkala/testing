package uk.co.o2.exercies;


public class Engine {

    private boolean running;
    private int fuelLevel;
    private FuelType requiredFuelType;
    private FuelType fuelType;
    
    
      public Engine(FuelType requiredFuelType)  {
      	this.requiredFuelType = requiredFuelType;
      }
      
      
	  public void start() {
	        if (fuelLevel > 0 && requiredFuelType.equals(fuelType)) {
	            running = true;
	        } else {
	            throw new IllegalStateException("Not able to start engine.");
	        }
	    }

	    public void stop() {
	        running = false;
	    }

	    public boolean isRunning() {
	        return running;
	    }

	    public void fill(FuelType fuelType, int fuelLevel) {
	        if (fuelLevel > 0 && fuelLevel < 100) {
	            this.fuelLevel = fuelLevel;
	        }
	        else if (fuelLevel >= 100) {
	            this.fuelLevel = 100;
	        }
	        else {
	            this.fuelLevel = 0;
	        }

	        this.fuelType = fuelType;
	    }

	    public FuelType getFuelType() {
	        return  requiredFuelType;
	    }
	    

	    //no harm in returning the  fuel level
	    public int getFuelLevel() {
	    	return this.fuelLevel;
	    }
	    
	    //no harm in returning whats  filled in the engine
	    public FuelType getFilledFuelType() {
	    	return this.fuelType;
	    }
	    
}
