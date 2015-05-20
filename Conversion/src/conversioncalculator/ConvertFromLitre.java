package conversioncalculator;

/**
 * 
 * @author Brian McMahon
 * Class to implement conversions from litre units. Extends Conversion superclass
 *
 */

public class ConvertFromLitre extends Conversion{
	
	//setters and getters for user input values
	@Override
	public void setValue(double value) {
		this.value=value;
	}

	@Override
	public double getValue() {
		return value;
	}
	//method to convert from litres to other units
	@Override
	public double convertTo(String unit) {
		if(unit.equals("litre")){
			result = value;
		}else if(unit.equals("ml")){
			result = value * 1000;
		}else if(unit.equals("gallon")){
			result = value * 0.26417;
		}else if (unit.equals("cup")){
			result = value * 4.2268;
		}else if(unit.equals("pint")){
			result = value * 2.1134;
		}else if(unit.equals("oz")){
			result = value * 33.814;
		}else if (unit.equals("quart")){
			result = value * 1.0567;
		}else if(unit.equals("tbsp")){
			result = value * 67.628;
		}else if(unit.equals("tsp")){
			result = value * 202.88;
		}
		return result;
	}


}
