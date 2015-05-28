package conversioncalculator;

/**
 * 
 * @author Brian McMahon
 * Factory class for weight unit creation
 *
 */

public class WeightConversionFactory {
	
	public Conversion getWeightConversion(String unit){
		if(unit.equals("g")){
			return new ConvertFromGram();
		}
		else if(unit.equals("kg")){
			return new ConvertFromKilogram();
		}else if(unit.equals("oz")){
			return new ConvertFromOzWeight();
		}else if(unit.equals("lb")){
			return new ConvertFromPound();
		}else 
			return null;
	}

}
