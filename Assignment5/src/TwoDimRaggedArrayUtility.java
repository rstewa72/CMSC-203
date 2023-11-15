import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A Utility class that provides static methods for 
 * reading/writing files containing ragged double arrays, 
 * and static methods for getting information about 
 * ragged double arrays in memory.
 * @author Robert
 */
public class TwoDimRaggedArrayUtility
{
	private static final int MAX_ROWS = 10;
	private static final int MAX_COLUMNS = 10;
	
	/**
	 * Reads from a file and returns a ragged array of doubles.
	 * Each row in the file is separated by a new line.
	 * Each element in the row is separated by a space.
	 * @param file the file to read from
	 * @return A two-dimensional ragged array of doubles.
	 */
	public static double[][] readFile(File file) {
		String[][] input = new String[MAX_ROWS][];
		int newRow = 0;
		try (Scanner fileInputScn = new Scanner(file)) {
			
			boolean stopReading = false;
			
			while (!stopReading) {
				if (fileInputScn.hasNextLine()) {
					String line = fileInputScn.nextLine();
					input[newRow] = line.split(" ");
					newRow++;
					if (newRow >= MAX_ROWS)
						stopReading = true;
				}
				else {
					stopReading = true;
				}
			}
			
		}
		catch (FileNotFoundException exc) {
			exc.printStackTrace();
			return null;
		}
		
		double[][] output = new double[newRow][];
		
		for (int r = 0; r < newRow; r++) {
			output[r] = new double[input[r].length];
			for (int c = 0; c < output[r].length; c++) {
				output[r][c] = Double.parseDouble(input[r][c]);
			}
		}
		
		return output;
	}
	
	/**
	 * Writes the ragged array of doubles into the file. 
	 * Each row is on a separate line within the file and 
	 * each double is separated by a space.
	 * @param data two dimensional ragged array of doubles
	 * @param file the file to write to
	 */
	public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(file)) {
			for (int r = 0; r < data.length; r++) {
				for (int c = 0; c < data[r].length; c++) {
					pw.print(data[r][c]);
					if (c < data[r].length-1)
						pw.print(" ");
				}
				pw.println();
			}
		}
	}
	
	/**
	 * Returns the total of all elements in the 2D array.
	 * @param data the 2D array to get the total of
	 * @return the sum of all elements in the 2D array
	 */
	public static double getTotal(double[][] data) {
		double sum = 0.0;
		for (double[] rowArray : data) {
			for (double n : rowArray) {
				sum += n;
			}
		}
		return sum;
	}
	
	/**
	 * Returns the average of the elements in the two dimensional array
	 * @param data the two dimensional array getting the average of
	 * @return the average of the elements in the two dimensional array (total 
	 * 		of elements/number of elements)
	 */
	public static double getAverage(double[][] data) {
		double sum = 0.0;
		int count = 0;
		for (double[] rowArray : data) {
			count += rowArray.length;
			for (double n : rowArray) {
				sum += n;
			}
		}
		return sum / count;
	}
	
	/**
	 * Returns the total of the selected row in the two dimensional array.
	 * Index 0 refers to the first row.
	 * @param data the two dimensional array
	 * @param row the row index to take the total of (0 refers to the first row)
	 * @return the total of the row
	 */
	public static double getRowTotal(double[][] data, int row) {
		double sum = 0.0;
		for (double n : data[row]) {
			sum += n;
		}
		return sum;
	}
	
	/**
	 * Returns the total of the selected column in the two dimensional array.
	 * Index 0 refers to the first column.
	 * @param data the two dimensional array
	 * @param column the column index to take the total of (0 refers to the first column)
	 * @return the total of the column
	 */
	public static double getColumnTotal(double[][] data, int column) {
		double sum = 0.0;
		for (double[] rowArray : data) {
			if (column < rowArray.length) {
				sum += rowArray[column];
			}
		}
		return sum;
	}
	
	/**
	 * Returns the largest element of the selected row in the two dimensional 
	 * array. Index 0 refers to the first row.
	 * @param data the two dimensional array
	 * @param row the row index to find the largest element of (0 refers to the first row)
	 * @return the largest element of the row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		return data[row][getHighestInRowIndex(data, row)];
	}
	
	/**
	 * Returns the index of the largest element of the selected row in the 
	 * two dimensional array. Index 0 refers to the first row.
	 * @param data the two dimensional array
	 * @param row the row index to find the largest element of (0 refers to the first row)
	 * @return the index of the largest element of the row
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		int highestIndex = 0;
		if (data[row].length == 1)
			return highestIndex;
		else {
			for (int c = 1; c < data[row].length; c++) {
				if (data[row][c] > data[row][highestIndex]) {
					highestIndex = c;
				}
			}
		}
		return highestIndex;
	}
	
	/**
	 * Returns the smallest element of the selected row in the two dimensional 
	 * array. Index 0 refers to the first row.
	 * @param data the two dimensional array
	 * @param row the row index to find the largest element of (0 refers to the first row)
	 * @return the smallest element of the row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		return data[row][getLowestInRowIndex(data, row)];
	}
	
	/**
	 * Returns the index of the smallest element of the selected row in the 
	 * two dimensional array. Index 0 refers to the first row.
	 * @param data the two dimensional array
	 * @param row the row index to find the largest element of (0 refers to the first row)
	 * @return the index of the smallest element of the row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		int lowestIndex = 0;
		if (data[row].length == 1)
			return lowestIndex;
		else {
			for (int c = 1; c < data[row].length; c++) {
				if (data[row][c] < data[row][lowestIndex]) {
					lowestIndex = c;
				}
			}
		}
		return lowestIndex;
	}
	
	/**
	 * Returns the largest element of the selected column in the two dimensional 
	 * array. Index 0 refers to the first column.
	 * @param data the two dimensional array
	 * @param column the column index to find the largest element of (0 refers to 
	 * 		the first column)
	 * @return the largest element of the column
	 */
	public static double getHighestInColumn(double[][] data, int column) {
		return data[getHighestInColumnIndex(data, column)][column];
	}
	
	/**
	 * Returns the index of the largest element of the selected column in the 
	 * two dimensional array. Index 0 refers to the first column.
	 * @param data the two dimensional array
	 * @param column the column index to find the largest element of (0 refers to 
	 * 		the first column)
	 * @return the index of the largest element of the column
	 */
	public static int getHighestInColumnIndex(double[][] data, int column) {
		int highestIndex = 0;
		if (data.length == 1)
			return highestIndex;
		else {
			for (int r = 1; r < data.length; r++) {
				if (column < data[r].length) {
					if (column >= data[highestIndex].length || data[r][column] > data[highestIndex][column]) {
						highestIndex = r;
					}
				}
			}
		}
		return highestIndex;
	}
	
	/**
	 * Returns the smallest element of the selected column in the two dimensional 
	 * array. Index 0 refers to the first column.
	 * @param data the two dimensional array
	 * @param column the column index to find the largest element of (0 refers to 
	 * 		the first column)
	 * @return the smallest element of the column
	 */
	public static double getLowestInColumn(double[][] data, int column) {
		return data[getLowestInColumnIndex(data, column)][column];
	}
	
	/**
	 * Returns the index of the smallest element of the selected column in the 
	 * two dimensional array. Index 0 refers to the first column.
	 * @param data the two dimensional array
	 * @param column the column index to find the largest element of (0 refers to 
	 * 		the first column)
	 * @return the index of the smallest element of the column
	 */
	public static int getLowestInColumnIndex(double[][] data, int column) {
		int lowestIndex = 0;
		if (data.length == 1)
			return lowestIndex;
		else {
			for (int r = 0; r < data.length; r++) {
				if (column < data[r].length) {
					if (column >= data[lowestIndex].length || data[r][column] < data[lowestIndex][column]) {
						lowestIndex = r;
					}
				}
			}
		}
		return lowestIndex;
	}
	
	/**
	 * Returns the largest element in the two dimensional array
	 * @param data the two dimensional array
	 * @return the largest element in the two dimensional array
	 */
	public static double getHighestInArray(double[][] data) {
		double highest = 0;
		for (double[] rowArray : data) {
			for (double n : rowArray) {
				if (n > highest) {
					highest = n;
				}
			}
		}
		return highest;
	}
	
	/**
	 * Returns the smallest element in the two dimensional array
	 * @param data the two dimensional array
	 * @return the smallest element in the two dimensional array
	 */
	public static double getLowestInArray(double[][] data) {
		double lowest = 0;
		for (double[] rowArray : data) {
			for (double n : rowArray) {
				if (n < lowest) {
					lowest = n;
				}
			}
		}
		return lowest;
	}
}
