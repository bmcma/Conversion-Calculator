package conversioncalculator;
/**
 * 
 * @author Brian McMahon
 * Class to implement conversions from ounces units. Extends Conversion superclass
 *
 */

public class ConvertFromOz extends Conversion{

	//setters and getters for user input values
	@Override
	public void setValue(double value) {
		this.value=value;
	}

	@Override
	public double getValue() {
		return value;
	}
	//method to convert from ounces to other units
	@Override
	public double convertTo(String unit) {
		if(unit.equals("oz")){
			result = value;
		}else if(unit.equals("ml")){
			result = value / 0.033814;
		}else if(unit.equals("gallon")){
			result = value * 0.0078125;
		}else if (unit.equals("cup")){
			result = value * 0.12500;
		}else if(unit.equals("pint")){
			result = value * 0.062500;
		}else if(unit.equals("litre")){
			result = value / 33.814;
		}else if (unit.equals("quart")){
			result = value * 0.031250;
		}else if(unit.equals("tbsp")){
			result = value * 2.0000;
		}else if(unit.equals("tsp")){
			result = value * 6.0000;
		}
		return result;
	}


}
