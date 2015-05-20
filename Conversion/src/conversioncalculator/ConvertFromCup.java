package conversioncalculator;

/**
 * 
 * @author Brian McMahon
 * Class to implement conversions from cup units. Extends Conversion superclass
 *
 */

public class ConvertFromCup extends Conversion{

	
	public ConvertFromCup(){
		
	}
	//setters and getters for userInput values 
	@Override
	public void setValue(double value){
		this.value = value;
	}
	@Override
	public double getValue(){
		return value;
	}
	
	//method to convert from cups based on user input
	@Override
	public double convertTo(String unit) {
		
		if (unit.equalsIgnoreCase("litre")){
			result = (value/4.2268);
		}else if (unit.equals("cup")){
			result = value;
		}else if (unit.equalsIgnoreCase("pint")){
			result = (value * 0.50000);
		}else if (unit.equalsIgnoreCase("ml")){
			result = (value/0.0042268);			
		}else if (unit.equalsIgnoreCase("oz")){
			result = (value * 8.0);
		}else if (unit.equalsIgnoreCase("tbsp")){
			result = (value * 16.000);
		}else if (unit.equalsIgnoreCase("tsp")){
			result = (value * 48.000);
		}else if (unit.equalsIgnoreCase("gallon")){
			result = (value * 0.062500);
		}else if (unit.equalsIgnoreCase("quart")){
			result = (value * 0.25000);
		}
		return result;
		
	}

}
