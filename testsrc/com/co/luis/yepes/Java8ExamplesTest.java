package com.co.luis.yepes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

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
		int expected = 55;
		int actual = java8Examples.numbersBetweenRank(initialRank, finalRank); 
		assertEquals(expected, actual);
	}
// 2. Return the sum from a given double numbers array using reduce -----------------------------
	@Test
	void testReduceSum() {
		double[] numbers = {2.5, 3.5, 6.0, 1.2};
		double expected = 13.2;
		double actual = java8Examples.reduceSum(numbers);
		assertEquals(expected, actual);
	}
// 3. Return the average from the numbers among a given rank, skip the n first elements ---------
	@Test
	void testAverageNumber() {
		int initialRank = 2;
		int finalRank = 10;
		int steps = 5; 
		double expected = 8.5;
		double actual = java8Examples.averageNumber(initialRank, finalRank, steps);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	
	@Test
	void testAverageNumberException() {
		int initialRank = 2;
		int finalRank = 10;
		int steps = 12; 
		assertThrows(NullPointerException.class, () -> {
			java8Examples.averageNumber(initialRank, finalRank, steps);
		});
	}
// 4. Order and return the first element of a given words list ----------------------------------
	@Test
	void testFirstOrderedWord() {
		List<String> words = Arrays.asList("soccer","house", "lorem", "Ipsum");
		String expected = "house";
		String actual = java8Examples.firstOrderedWord(words);
		assertEquals(expected, actual);
	}
	
	@Test
	void testFirstOrderedWordNull() {
		List<String> words = null;
		assertThrows(NullPointerException.class, () -> {
			java8Examples.firstOrderedWord(words);
		});
	}
	
	@Test
	void testFirstOrderedWordEmpty() {
		List<String> words = Arrays.asList();
		assertNull(java8Examples.firstOrderedWord(words));
	}
// 5. Return the bigger square from a given decimal numbers array ------------------------------
	@Test
	void testBiggerDecimalSquare() {
		Double[] numbers = {3.05, 4.201, 7.66};
		double expected = 58.6756;
		double actual = java8Examples.biggerDecimalSquare(numbers);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBiggerDecimalSquareEmpty() {
		Double[] numbers = {};
		assertThrows(NoSuchElementException.class, () -> {
			java8Examples.biggerDecimalSquare(numbers);
		});
	}
	
	@Test
	void testBiggerDecimalSquareNull() {
		Double[] numbers = null;
		assertThrows(NullPointerException.class, () -> {
			java8Examples.biggerDecimalSquare(numbers);
		});
	}
// 6.  Filter by prefix, order and return the words array changed from the given one ------------
	@Test
	void testOrderedFilteredWords() {
		String[] words = {"airpod", "biscuit", "airforce", "zelta", "airplane", "java", "airport"};
		String prefix = "airp";
		String[] expected = {"airplane", "airpod", "airport"};
		String[] actual = java8Examples.orderedFilteredWords(words, prefix);
		assertArrayEquals(expected, actual);
	}
// 7. Return the amount of words with more than four letters in a referenced text file ----------
	@Test
	void testBiggerThan4() {
		String uriTxt = "bin/testassets/bands.txt";
		int expected = 26;
		int actual = java8Examples.biggerThan4(uriTxt);
		assertEquals(expected, actual);
	}
/* 8. Return from a referenced text file, in uppercase,------------------------------------------
 * 	the list of words that end with a given postfix ---------------------------------------------
 */
	@Test
	void testEndWithPostfix() {
		String uriTxt = "bin/testassets/bands.txt";
		String postfix = "es";
		List<String> expected = Arrays.asList("BEATLES", "STONES", "RAMONES");
		List<String> actual = java8Examples.endWithPostfix(uriTxt, postfix); 
		assertIterableEquals(expected, actual);
	}
// 9. Return how many rows with numbers does a referenced CSV file has --------------------------
	@Test
	void testRowsWithNumbers() {
		String uriCsv = "bin/testassets/bands.csv";
		int expected = 2;
		int actual = java8Examples.rowsWithNumbers(uriCsv);
		assertEquals(expected, actual);
	}
// 10. Return an array with all prime numbers from a referenced CSV file ------------------------
	@Test
	void testPrimeNumbers() {
		String uriCsv = "bin/testassets/numbers.csv";
		int[] expected = {2, 7, 3, 11, 105};
		int[] actual = java8Examples.primeNumbers(uriCsv);
		assertArrayEquals(expected, actual);
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
