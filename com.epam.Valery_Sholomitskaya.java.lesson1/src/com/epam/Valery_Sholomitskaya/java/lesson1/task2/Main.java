package com.epam.Valery_Sholomitskaya.java.lesson1.task2;

import java.util.ArrayList;

public class Main {
	public static void printAllElementsOfArrayBeforeIndex(
			ArrayList<Double> array, int index) {

		for(int i=0;i<index;i++){
			System.out.print(" "+array.get(i));
		}

	}

	public static void main(String[] args) {
		Sequence sequence = new Sequence();
		double precision = 0.1;
		double number = 5;
		double criticalElement;
		try {
			sequence.sequencingToTheNumber(number);
			printAllElementsOfArrayBeforeIndex(sequence.getArrayOfSequence(),
					sequence.getArrayOfSequence().size());
			criticalElement = sequence
					.findTheSmallestIndexElementOfSequenceByCondition(precision);
			System.out.println("\n "+" criticalElement " + criticalElement);
			printAllElementsOfArrayBeforeIndex(
					sequence.getArrayOfSequence(),
					sequence.findTheSmallestIndexElementOfSequenceByCondition(precision));

		} catch (IllegalArgumentException e) {
			e.printStackTrace();

		}

	}
}