/**
 * 
 */
package conversioncalculator;

/**
 * @author Brian
 *
 */
public class ConvertFromGram extends Conversion{

	@Override
	public void setValue(double value) {
		this.value = value;
		
	}

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public double convertTo(String unit) {
		if (unit.equals("g")){
			result = value;
		}else if(unit.equals("kg")){
			result = value / 1000;
		}else if(unit.equals("oz")){
			result = value * 0.035274;
		}else if(unit.equals("lb")){
			result = value * 0.0022046;
		}
		return result;
	}


}
