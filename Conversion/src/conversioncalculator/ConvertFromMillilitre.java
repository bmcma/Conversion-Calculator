package conversioncalculator;

/**
 * 
 * @author Brian McMahon
 * Class to implement conversions from ml units. Extends Conversion superclass
 *
 */

public class ConvertFromMillilitre extends Conversion{
	
	public ConvertFromMillilitre(){}

	//setters and getters for user input values
	@Override
	public void setValue(double value){
		this.value = value;
	}
	
	@Override
	public double getValue(){
		return value;
	}
	//method to convert from ml to other units
	@Override
	public double convertTo(String unit){

		if (unit.equalsIgnoreCase("litre")){
			result = (value/1000);
		}else if (unit.equalsIgnoreCase("pint")){
			result = (value * 0.0021134);
		}else if (unit.equals("ml")){
			result = value;
		}else if (unit.equalsIgnoreCase("cup")){
			result = (value * 0.0042268);
		}else if (unit.equalsIgnoreCase("oz")){
			result = (value * 0.033814);
		}else if (unit.equalsIgnoreCase("tbsp")){
			result = (value * 0.067628);
		}else if (unit.equalsIgnoreCase("tsp")){
			result = (value * 0.20288);
		}else if (unit.equalsIgnoreCase("gallon")){
			result = (value * 0.00026417);
		}else if (unit.equalsIgnoreCase("quart")){
			result = (value * 0.00105667);
		}

		return result;
	}

}
