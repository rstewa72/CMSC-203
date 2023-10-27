import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	
	private GradeBook gb1, gb2, gb3;
	
	@BeforeEach
	void setUp() throws Exception {
		gb1 = new GradeBook(5);
		gb2 = new GradeBook(5);
		gb3 = new GradeBook(5);
		
		gb1.addScore(3.17);
		gb1.addScore(8.97);
		
		gb2.addScore(25.63);
		gb2.addScore(30.00);
		gb2.addScore(13.45);
		gb2.addScore(46.623);
		
		gb3.addScore(8.20);
		gb3.addScore(20.44);
		gb3.addScore(84.36);
		gb3.addScore(40.05);
		gb3.addScore(8.97);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		gb1 = null;
		gb2 = null;
		gb3 = null;
	}

	@Test
	void testAddScore() {
		assertEquals("3.17 8.97 ", gb1.toString());
		assertEquals(2, gb1.getScoreSize());
		
		assertEquals("25.63 30.0 13.45 46.623 ", gb2.toString());
		assertEquals(4, gb2.getScoreSize());
		
		assertEquals("8.2 20.44 84.36 40.05 8.97 ", gb3.toString());
		assertEquals(5, gb3.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(12.14, gb1.sum(), 0.001);
		assertEquals(115.703, gb2.sum(), 0.001);
		assertEquals(162.02, gb3.sum(), 0.001);
	}

	@Test
	void testMinimum() {
		assertEquals(3.17, gb1.minimum(), 0.001);
		assertEquals(13.45, gb2.minimum(), 0.001);
		assertEquals(8.20, gb3.minimum(), 0.001);
	}

	@Test
	void testFinalScore() {
		assertEquals(8.97, gb1.finalScore(), 0.001);
		assertEquals(102.253, gb2.finalScore(), 0.001);
		assertEquals(153.82, gb3.finalScore(), 0.001);
	}

}
