import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HolidayBonusStudentTest
{
	
	private static final double[][]
		DATASET_1 = 
			{{1, 2, 3},
			 {4, 5},
			 {6, 7, 8}},
		DATASET_DISTRICT3 = 
			{{1.65, 4.50, 2.36, 7.45, 3.44, 6.23},
			 {2.22, -3.24, -1.66, -5.48, 3.46},
			 {4.23, 2.29, 5.29},
			 {2.76, 3.76, 4.29, 5.48, 3.43},
			 {3.38, 3.65, 3.76},
			 {2.46, 3.34, 2.38, 8.26, 5.34}},
		DATASET_DISTRICT5 = 
			{{12536.54, 45665.05, 21543.66, 75324.57, 33884.48, 65982.39},
			 {28762.21, 35762.42, 19546.63},
			 {48962.34, 28552.95, 23863.66, 54992.97},
			 {22567.63, 36237.64, 42862.95, 54384.86, 37944.37},
			 {31843.86, 36546.57, 34557.68, 63872.39, 42657.70, 45924.51},
			 {26574.65, 32653.46, 22563.87, 89352.68, 52873.49}};
	
	
	@Test
	void test_calculateHolidayBonus() {
		double[] stores = HolidayBonus.calculateHolidayBonus(DATASET_DISTRICT5);
		assertEquals(16_000.0, stores[0]);
		assertEquals(5_000.0, stores[1]);
		assertEquals(10_000.0, stores[2]);
		assertEquals(12_000, stores[3]);
		assertEquals(11_000.0, stores[4]);
		assertEquals(16_000.0, stores[5]);
	}
	
	@Test
	void test_calculateHolidayBonus_2() {
		double[] stores = HolidayBonus.calculateHolidayBonus(DATASET_1);
		
		assertEquals(3, stores.length);
		assertEquals(3000.0, stores[0]);
		assertEquals(4000.0, stores[1]);
		assertEquals(15000.0, stores[2]);
		
		/* for (int i = 0; i < stores.length; i++) {
			System.out.print(stores[i] + " ");
		}
		System.out.println();
		*/ 
	}
	
	@Test
	void test_calculateTotalHolidayBonus() {
		double total = HolidayBonus.calculateTotalHolidayBonus(DATASET_DISTRICT5);
		assertEquals(70_000, total);
	}
}
