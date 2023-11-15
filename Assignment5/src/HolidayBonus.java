
/**
 * A class containing static methods that calculate 
 * holiday bonus amounts to be given out to a particular 
 * retail district.
 * @author Robert
 */
public class HolidayBonus
{
	private static final double bonusHighest = 5_000;
	private static final double bonusLowest = 1_000;
	private static final double bonusOther = 2_000;
	
	private static int getHighestColumnLength(double[][] data) {
		int highestLength = 0;
		for (double[] rowArray : data)
			if (rowArray.length > highestLength)
				highestLength = rowArray.length;
		
		return highestLength;
	}
	
	/**
	 * Calculates the holiday bonus for each store
	 * @param data the two dimensional array of store sales
	 * @return an array of the bonus for each store
	 */
	public static double[] calculateHolidayBonus(double[][] data) {
		int numOfCategories = getHighestColumnLength(data);
		double[] stores = new double[data.length];
		for (int c = 0; c < numOfCategories; c++) {
			int highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, c);
			int lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, c);
			for (int i = 0; i < stores.length; i++) {
				if (i == highestIndex)
					stores[i] += bonusHighest;
				else if (i == lowestIndex)
					stores[i] += bonusLowest;
				else if (c < data[i].length)
					stores[i] += bonusOther;
			}
		}
		return stores;
	}
	
	/**
	 * Calculates the total holiday bonuses
	 * @param data the two dimensional array of store sales
	 * @return the total of all holiday bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data) {
		double[] stores = calculateHolidayBonus(data);
		double sum = 0;
		for (double n : stores)
			sum += n;
		return sum;
	}
}
