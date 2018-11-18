package com.co.luis.yepes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Java8ExamplesTest {
	
	private Java8Examples java8Examples;
	
	@BeforeEach
	public void setUp() {
		java8Examples = new Java8Examples();
	}
	
// 1. Return the sum from the numbers among a given rank ----------------------------------------
	@Test
	void testNumbersBetweenRank() {
		int initialRank = 1;
		int finalRank = 10;
		int expectedResult = 55;
		int actualResult = java8Examples.numbersBetweenRank(initialRank, finalRank); 
		assertEquals(expectedResult, actualResult);
	}
// 2. Return the sum from a given double numbers array using reduce -----------------------------
	@Test
	void testReduceSum() {
		double[] numbers = {2.5, 3.5, 6.0, 1.2};
		double expectedResult = 13.2;
		double actualResult = java8Examples.reduceSum(numbers);
		assertEquals(expectedResult, actualResult);
	}
// 3. Return the average from the numbers among a given rank, skip the n first elements ---------
	@Test
	void testAverageNumber() {
		int initialRank = 2;
		int finalRank = 10;
		int steps = 5; 
		double expectedResult = 8.5;
		double actualResult = java8Examples.averageNumber(initialRank, finalRank, steps);
		assertEquals(expectedResult, actualResult);
	}
// 4. Order and return the first element of a given words list ----------------------------------
	@Test
	void testFirstOrderedWord() {
		List<String> words = Arrays.asList("soccer","house", "lorem", "Ipsum");
		String expectedResult = "house";
		String actualResult = java8Examples.firstOrderedWord(words);
		assertEquals(expectedResult, actualResult);
	}
// 5. Return the bigger square from a given floating numbers array ------------------------------
	@Test
	void testBiggerFloatSquare() {
		float[] numbers = {3.05f, 4.201f, 7.66f};
		float expectedResult = 58.6756f;
		float actualResult = java8Examples.biggerFloatSquare(numbers);
		assertEquals(expectedResult, actualResult);
	}
// 6.  Filter by prefix, order and return the words array changed from the given one ------------
	@Test
	void testOrderedFilteredWords() {
		String[] words = {"airpod", "biscuit", "airforce", "zelta", "airplane", "java", "airport"};
		String prefix = "airp";
		String[] expectedResult = {"airplane", "airpod", "airport"};
		String[] actualResult = java8Examples.orderedFilteredWords(words, prefix);
		assertArrayEquals(expectedResult, actualResult);
	}
// 7. Return the amount of words with more than four letters in a referenced text file ----------
	@Test
	void testBiggerThan4() {
		String uriTxt = "bin/testassets/bands.txt";
		int expectedResult = 26;
		int actualResult = java8Examples.biggerThan4(uriTxt);
		assertEquals(expectedResult, actualResult);
	}
/* 8. Return from a referenced text file, in uppercase,------------------------------------------
 * 	the list of words that end with a given postfix ---------------------------------------------
 */
	@Test
	void testEndWithPostfix() {
		String uriTxt = "bin/testassets/bands.txt";
		String postfix = "es";
		List<String> expectedResult = Arrays.asList("BEATLES", "STONES", "RAMONES");
		List<String> actualResult = java8Examples.endWithPostfix(uriTxt, postfix); 
		assertIterableEquals(expectedResult, actualResult);
	}
// 9. Return how many rows with numbers does a referenced CSV file has --------------------------
	@Test
	void testRowsWithNumbers() {
		String uriCsv = "bin/testassets/bands.csv";
		int expectedResult = 2;
		int actualResult = java8Examples.rowsWithNumbers(uriCsv);
		assertEquals(expectedResult, actualResult);
	}
// 10. Return an array with all prime numbers from a referenced CSV file ------------------------
	@Test
	void testPrimeNumbers() {
		String uriCsv = "bin/testassets/numbers.csv";
		int[] expectedResult = {2, 7, 3, 11, 105};
		int[] actualResult = java8Examples.primeNumbers(uriCsv);
		assertArrayEquals(expectedResult, actualResult);
	}
/* 11. Return a String with the IntSummaryStatistics from the people's ages in a given Person ---
 * list. Person class should have id, name, age properties. Skip those with repeated id --------- 
 */
	@Test
	void testAgeStatistics() {
		List<Person> people = Arrays.asList(
				  new Person(1, "John", 12),
				  new Person(2, "Anna", 21),
				  new Person(3, "Paul", 23),
				  new Person(2, "Anna", 21)
				);
		String expected = "IntSummaryStatistics{count=3, sum=56, min=12, average=18,666667, max=23}";
		String actual = java8Examples.ageStatistics(people);
		assertEquals(expected, actual);
	}
}
