package conversioncalculator;

/**
 * 
 * @author Brian McMahon
 * Factory class for volume unit creation
 *
 */

public class VolumeConversionFactory {

	public Conversion getVolumeConversion(String unit) {
		if (unit.equals("litre")) {
			return new ConvertFromLitre();
		} else if (unit.equals("cup")) {
			return new ConvertFromCup();
		} else if (unit.equals("pint")) {
			return new ConvertFromPint();
		} else if (unit.equals("ml")) {
			return new ConvertFromMillilitre();
		} else if (unit.equals("oz")) {
			return new ConvertFromOz();
		} else if (unit.equals("tbsp")) {
			return new ConvertFromTbsp();
		} else if (unit.equals("tsp")) {
			return new ConvertFromTsp();
		} else if (unit.equals("gallon")) {
			return new ConvertFromGallon();
		} else if (unit.equals("quart")) {
			return new ConvertFromQuart();
		} else
			return null;
	}

}
