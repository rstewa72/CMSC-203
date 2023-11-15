import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TwoDimRaggedArrayUtilityStudentTest
{
	private static final File 
		FILE_DATASET1 = new File("dataSet1.txt"),
		FILE_DATASET2 = new File("dataSet2.txt"),
		FILE_DATASET3 = new File("dataSet3.txt"),
		FILE_DATASET4 = new File("dataSet4.txt"),
		FILE_DISTRICT3 = new File("district3.txt"),
		FILE_DISTRICT4 = new File("district4.txt"),
		FILE_DISTRICT5 = new File("district5.txt");
	
	private static final double[][]
		DATASET_DISTRICT3 = 
			{{1.65, 4.50, 2.36, 7.45, 3.44, 6.23}, 
			 {2.22, -3.24, -1.66, -5.48, 3.46}, 
			 {4.23, 2.29, 5.29},
			 {2.76, 3.76, 4.29, 5.48, 3.43}, 
			 {3.38, 3.65, 3.76},
			 {2.46, 3.34, 2.38, 8.26, 5.34}},
		DATASET_4 = 
			{{-2.5, -5.3, 6.1},
			 {-4.4, 8.2},
			 {2.3, -7.5},
			 {-4.2, 7.3, -5.9, 2.6}};
	
	private static void checkFileExists(File file) {
		if (!file.exists()) {
			throw new RuntimeException(file.getName()
				+ " does not exist.");
		}
	}
	
	@BeforeAll
	static void setUpBeforeClass() {
		checkFileExists(FILE_DATASET1);
		checkFileExists(FILE_DATASET2);
		checkFileExists(FILE_DATASET3);
		checkFileExists(FILE_DATASET4);
		checkFileExists(FILE_DISTRICT3);
		checkFileExists(FILE_DISTRICT4);
		checkFileExists(FILE_DISTRICT5);
	}
	
//	@AfterAll
//	static void tearDownAfterClass() {
//	}
//	
//	@BeforeEach
//	void setUp() {
//	}
//	
//	@AfterEach
//	void tearDown() {
//	}
	
	@Test
	void test_readFile_1() {
		// Pre-test
		File inputFile = FILE_DATASET1;
		double[][] expectedOutput = new double[][] {
			{1.0, 2.0, 3.0},
			{4.0, 5.0},
			{6.0, 7.0, 8.0}
		};
		
		// Test
		double[][] output = TwoDimRaggedArrayUtility.readFile(inputFile);
		
		assertArrayEquals(expectedOutput, output);
	}
	
	@Test
	void test_readFile_2() {
		// Pre-test
		File inputFile = FILE_DATASET2;
		double[][] expectedOutput = new double[][] {
			{7.0, 2.0, 9.0, 4.0},
			{5.0},
			{8.0, 1.0, 3.0},
			{11.0, 6.0, 7.0, 2.0}
		};
		
		// Test
		double[][] output = TwoDimRaggedArrayUtility.readFile(inputFile);
		
		assertArrayEquals(expectedOutput, output);
	}
	
	@Test
	void test_readFile_3() {
		// Pre-test
		File inputFile = FILE_DATASET3;
		double[][] expectedOutput = new double[][] {
			{7.2, 2.5, 9.3, 4.8}, 
			{5.9},
			{8.1, 1.7, 3.3},  
			{11.6, 6.9, 7.3, 2.7} 
		};
		
		// Test
		double[][] output = TwoDimRaggedArrayUtility.readFile(inputFile);
		
		assertArrayEquals(expectedOutput, output);
	}
	
	@Test
	void test_readFile_4() {
		// Pre-test
		File inputFile = FILE_DATASET4;
		double[][] expectedOutput = DATASET_4;
		
		// Test
		double[][] output = TwoDimRaggedArrayUtility.readFile(inputFile);
		
		assertArrayEquals(expectedOutput, output);
	}
	
	@Test
	void test_readFile_5() {
		// Pre-test
		File inputFile = FILE_DISTRICT3;
		double[][] expectedOutput = DATASET_DISTRICT3;
		
		// Test
		double[][] output = TwoDimRaggedArrayUtility.readFile(inputFile);
		
		assertArrayEquals(expectedOutput, output);
	}
	
	@Test
	void test_writeToFile() throws FileNotFoundException {
		// Pre-test
		File outputFile = new File("output.txt");
		double[][] input = {
			{32.4, -9.66, 6.25, 59.86},
			{9.32, 15.09, 25.54, -8.66, -7.42},
			{24.33, 60.91, -4.24, 82.82, 93.24},  
			{22.99, -5.28, 41.91, 38.18, 27.35},
			{87.30, -47.11, 5.98, 73.05},
			{9.08, 13.27, 16.52, -9.88}
		};
		
		// Test
		TwoDimRaggedArrayUtility.writeToFile(input, outputFile);
		
		double[][] output = TwoDimRaggedArrayUtility.readFile(outputFile);
		
		assertArrayEquals(input, output);
	}
	
	@Test
	void test_getTotal() {
		double output = TwoDimRaggedArrayUtility.getTotal(DATASET_4);
		
		assertEquals(-3.3, output, 0.001);
	}
	
	@Test
	void test_getAverage() {
		double output = TwoDimRaggedArrayUtility.getAverage(DATASET_4);
		
		assertEquals(-0.3, output, 0.001);
	}
	
	@Test
	void test_getRowTotal_1() {
		double output = TwoDimRaggedArrayUtility.getRowTotal(DATASET_DISTRICT3, 1);
		
		assertEquals(-4.7, output, 0.001);
	}
	
	@Test
	void test_getRowTotal_2() {
		double output = TwoDimRaggedArrayUtility.getRowTotal(DATASET_DISTRICT3, 4);
		
		assertEquals(10.79, output, 0.001);
	}
	
	@Test
	void test_getColumnTotal_1() {
		double output = TwoDimRaggedArrayUtility.getColumnTotal(DATASET_DISTRICT3, 0);
		
		assertEquals(16.7, output, 0.001);
	}
	
	@Test
	void test_getColumnTotal_2() {
		double output = TwoDimRaggedArrayUtility.getColumnTotal(DATASET_DISTRICT3, 4);
		
		assertEquals(15.67, output, 0.001);
	}
	
	@Test
	void test_getHighestInRow() {
		double output = TwoDimRaggedArrayUtility.getHighestInRow(DATASET_DISTRICT3, 3);
		
		assertEquals(5.48, output);
	}
	
	@Test
	void test_getHighestInRowIndex() {
		int output = TwoDimRaggedArrayUtility.getHighestInRowIndex(DATASET_DISTRICT3, 3);
		
		assertEquals(3, output);
	}
	
	@Test
	void test_getLowestInRow() {
		double output = TwoDimRaggedArrayUtility.getLowestInRow(DATASET_DISTRICT3, 3);
		
		assertEquals(2.76, output);
	}
	
	@Test
	void test_getLowestInRowIndex() {
		int output = TwoDimRaggedArrayUtility.getLowestInRowIndex(DATASET_DISTRICT3, 3);
		
		assertEquals(0, output);
	}
	
	@Test
	void test_getHighestInColumn() {
		double output = TwoDimRaggedArrayUtility.getHighestInColumn(DATASET_DISTRICT3, 2);
		
		assertEquals(5.29, output);
	}
	
	@Test
	void test_getHighestInColumnIndex() {
		int output = TwoDimRaggedArrayUtility.getHighestInColumnIndex(DATASET_DISTRICT3, 2);
		
		assertEquals(2, output);
	}
	
	@Test
	void test_getLowestInColumn() {
		double output = TwoDimRaggedArrayUtility.getLowestInColumn(DATASET_DISTRICT3, 4);
		
		assertEquals(3.43, output);
	}
	
	@Test
	void test_getLowestInColumnIndex() {
		int output = TwoDimRaggedArrayUtility.getLowestInColumnIndex(DATASET_DISTRICT3, 4);
		
		assertEquals(3, output);
	}
	
	
	
	@Test
	void test_getHighestInArray() {
		double[][] data = TwoDimRaggedArrayUtility.readFile(FILE_DISTRICT3);
		double output = TwoDimRaggedArrayUtility.getHighestInArray(data);
		
		assertEquals(8.26, output);
	}
	
	@Test
	void test_getLowestInArray() {
		double output = TwoDimRaggedArrayUtility.getLowestInArray(DATASET_DISTRICT3);
		
		assertEquals(-5.48, output);
	}
	

}
