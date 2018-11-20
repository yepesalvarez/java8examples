package com.co.luis.yepes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.math.NumberUtils;

public class Java8Examples {
	
// 1. Return the sum from the numbers among a given rank ----------------------------------------
	public int numbersBetweenRank(int initialRank, int finalRank) {
		return
				IntStream
					.rangeClosed(initialRank, finalRank)
					.sum();
	}
// 2. Return the sum from a given double numbers array using reduce -----------------------------
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
		throw new NoSuchElementException();
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
// 5. Return the bigger square from a given decimal numbers array -------------------------------
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
		if(words!=null && prefix!=null)
			return
				Arrays.stream(words)
					.filter(x -> x.startsWith(prefix))
					.sorted(String::compareToIgnoreCase)
					.toArray(String[]::new);
		throw new NullPointerException();
	}
// 7. Return the amount of words with more than four letters in a referenced text file ----------
	public int biggerThan4(String uriTxt) throws IOException {
		if(uriTxt != null) {
			Stream<String> words = Files.lines(Paths.get(uriTxt));
			int wordsBiggerThan4 =   
				(int) words
						.map(x -> x.split(" "))
						.flatMap(Arrays::stream)
						.filter(x -> x.length() > 4)
						.count();
			words.close();
			return wordsBiggerThan4;
		}else {throw new NullPointerException();}
	}
/* 8. Return from a referenced text file, in upper case,------------------------------------------
 * 	the list of words that end with a given suffix ---------------------------------------------
 */
	public List<String> endWithSuffix(String uriTxt, String suffix) throws IOException{
		if(uriTxt != null) {
			Stream<String> words = Files.lines(Paths.get(uriTxt));
			List<String> wordsSuffix =
				words
					.map(x -> x.split(" "))
					.flatMap(Arrays::stream)
					.filter(x -> x.endsWith(suffix))
					.map(String::toUpperCase)
					.collect(Collectors.toList());
			words.close();
			return wordsSuffix;
		}else {throw new NullPointerException();}
	}
// 9. Return how many rows with numbers does a referenced CSV file has --------------------------
	public int rowsWithNumbers(String uriCsv) throws IOException {
		if(uriCsv != null) {
			Stream<String> words = Files.lines(Paths.get(uriCsv));
			int rows = 
					(int) words
							.map(x -> x.split(","))
							.filter( x -> Stream.of(x)
											.map(z -> z.split(""))
											.flatMap(Arrays::stream)
											.filter(NumberUtils::isCreatable)
											.count() > 0)
							.count();
			words.close();
			return rows;
		}else {throw new NullPointerException();}
	}
// 10. Return an array with all prime numbers from a referenced CSV file ------------------------
	public int[] primeNumbers(String uriCsv) throws IOException {
		if(uriCsv!=null) {
			Stream<String> numbers = Files.lines(Paths.get(uriCsv));
			int[] primeNumbers = numbers
					.map(x -> x.split(","))
					.flatMap(Arrays::stream)
					.map(x -> x.replace(" ", ""))
					.filter(NumberUtils::isCreatable)
					.filter(x -> IntStream
							.range(2, NumberUtils.createInteger(x))
							.noneMatch(i -> NumberUtils.createInteger(x) % i == 0))
					.mapToInt(NumberUtils::createInteger)
					.toArray();
			numbers.close();
			return primeNumbers;
		}else {throw new NullPointerException();}
	}
/* 11. Return a String with the IntSummaryStatistics from the people's ages in a given Person ---
 * list. Person class should have id, name, age properties. Skip those with repeated id --------- 
 */
	public String ageStatistics(List<Person> people) {
		if (people != null) {
			Collection<Person> noRepeated = people.stream().collect(Collectors.toMap(Person::getId, p -> p, (p, q) -> p)).values();
			return noRepeated.stream().collect(Collectors.summarizingInt(Person::getAge)).toString();
		}else {throw new NullPointerException();}
	}
}
