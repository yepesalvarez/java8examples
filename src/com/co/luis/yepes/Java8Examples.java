package com.co.luis.yepes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Examples {
	
// 1. Return the sum from the numbers among a given rank ----------------------------------------
	public int numbersBetweenRank(int initialRank, int finalRank) {
			return IntStream
					.rangeClosed(initialRank, finalRank)
					.sum();
	}
// 2. Return the sum from a given double numbers array using reduce ----------------------------
	public double reduceSum(double[] numbers) {
		if(numbers != null)
			return Arrays.stream(numbers)
				.reduce(0.0, (a, b) -> a + b);
		throw new NullPointerException();
	}
// 3. Return the average from the numbers among a given rank, skip the n first elements ---------
	public double averageNumber(int initialRank, int finalRank, int n) {
		if (n < finalRank - initialRank)
			return IntStream
					.rangeClosed(initialRank, finalRank)
					.skip(n)
					.average()
					.getAsDouble();
		throw new NullPointerException();
	}
// 4. Order and return the first element of a given words list ----------------------------------
	public String firstOrderedWord(List<String> words) {
		if(words != null)
			return words.stream()
					.sorted(String::compareToIgnoreCase)
					.findFirst()
					.orElse(null);
		throw new NullPointerException();
	}
// 5. Return the bigger square from a given decimal numbers array ------------------------------
	public double biggerDecimalSquare(Double[] numbers) {
		if(numbers != null){
			if(numbers.length > 0) {
				return Stream.of(numbers)
						.map(x -> Math.pow( x, 2))
						.max(Comparator.comparing(Double::valueOf))
						.get();
			}else{	throw new NoSuchElementException();}
		}else{throw new NullPointerException();}
	}
// 6.  Filter by prefix, order and return the words array changed from the given one ------------
	public String[] orderedFilteredWords(String[] words, String prefix) {
		return words;
	}
// 7. Return the amount of words with more than four letters in a referenced text file ----------
	public int biggerThan4(String uriTxt) {
		return 0;
	}
/* 8. Return from a referenced text file, in uppercase,------------------------------------------
 * 	the list of words that end with a given postfix ---------------------------------------------
 */
	public List<String> endWithPostfix(String uriTxt, String postfix){
		return null;
	}
// 9. Return how many rows with numbers does a referenced CSV file has --------------------------
	public int rowsWithNumbers(String uriCsv) {
		return 0;	
	}
// 10. Return an array with all prime numbers from a referenced CSV file ------------------------
	public int[] primeNumbers(String uriCsv) {
		return null;
	}
/* 11. Return a String with the IntSummaryStatistics from the people's ages in a given Person ---
 * list. Person class should have id, name, age properties. Skip those with repeated id --------- 
 */
	public String ageStatistics(List<Person> people) {
		return null;
	}
}
