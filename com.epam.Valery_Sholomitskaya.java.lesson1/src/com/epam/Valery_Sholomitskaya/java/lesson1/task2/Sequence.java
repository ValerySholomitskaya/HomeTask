package com.epam.Valery_Sholomitskaya.java.lesson1.task2;

import java.util.ArrayList;

public class Sequence {

	private ArrayList<Double> arrayOfSequence = null;

	public void sequencingToTheNumber(double n) {

		if (n <= 0) {
			throw new IllegalArgumentException(
					"n<0. such sequence impossible to create");
		}

		ArrayList<Double> tempArray = new ArrayList<Double>();
		for (int i = 0; i < n ; i++) {
			double a = 1 / Math.pow((1 + i), 2);
			tempArray.add(a);
		}
		arrayOfSequence = tempArray;

	}

	public ArrayList<Double> getArrayOfSequence() {
		return arrayOfSequence;
	}

	public int findTheSmallestIndexElementOfSequenceByCondition(double precision) {
		if (arrayOfSequence == null) {
			throw new IllegalArgumentException("Sequence hasnt elements ");
		}
		if (precision < 0) {
			throw new IllegalArgumentException("precision <0");
		}
		if (precision >1) {
			throw new IllegalArgumentException("precision >1");
		}

		int index = 0;
		for (int i = 0; i < arrayOfSequence.size(); i++) {
			if (arrayOfSequence.get(i) < precision) {
				index = i;
				break;
			}
		}
		return index;
	}

}
