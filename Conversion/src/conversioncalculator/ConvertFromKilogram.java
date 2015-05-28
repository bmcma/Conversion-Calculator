package conversioncalculator;

public class ConvertFromKilogram extends Conversion{

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
		if(unit.equals("kg")){
			result = value;
		}else if(unit.equals("g")){
			result = value / 0.0010000;
		}else if(unit.equals("oz")){
			result = value * 35.274;
		}else if(unit.equals("lb")){
			result = value * 2.2046;
		}
		return result;
	}

}
