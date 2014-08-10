package com.epam.Valery_Sholomitskaya.java.lesson1.task4;

import java.util.ArrayList;


public class Numbers {
	private ArrayList<Double> arrayOfNumbers = null;

	public ArrayList<Double> getArrayOfSequence() {
		return arrayOfNumbers;
	}

	public void createArrayOfNumbers(ArrayList<Double> numbers) {

		if (numbers.size() == 0) {
			throw new IllegalArgumentException("insert numbers");
		}
		if ((numbers.size() % 2) != 0) {
			throw new IllegalArgumentException("insert even numbers");
		}
		arrayOfNumbers = numbers;

	}

	public ArrayList<Double> ArrayOfSumOfTwoNumbers(
			ArrayList<Double> arrayOfNumbers) {
		ArrayList<Double> ArrayOfSumOfTwoNumbers = new ArrayList<Double>();

		for (int i = 0; i <(arrayOfNumbers.size() / 2); i++) {
			double tempSum = arrayOfNumbers.get(i)+ arrayOfNumbers.get(arrayOfNumbers.size() - i-1);
			ArrayOfSumOfTwoNumbers.add(tempSum);
		}
		return ArrayOfSumOfTwoNumbers;
	}

	public double MaxSum(ArrayList<Double> ArrayOfSumOfTwoNumbers) {

		double max = ArrayOfSumOfTwoNumbers.get(0);
		for (int i = 1; i < ArrayOfSumOfTwoNumbers.size(); i++) {
			if (max < ArrayOfSumOfTwoNumbers.get(i)) {
				max = ArrayOfSumOfTwoNumbers.get(i);
			}

		}

		return max;
	}

}
