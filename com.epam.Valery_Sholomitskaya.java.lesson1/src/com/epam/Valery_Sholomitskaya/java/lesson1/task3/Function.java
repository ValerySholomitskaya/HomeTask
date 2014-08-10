package com.epam.Valery_Sholomitskaya.java.lesson1.task3;

import java.util.Map;
import java.util.TreeMap;

public class Function {
	private Map<Double, Double> mapOfArgumentsAndFunctions = null;

	public void qreateFunction(double start, double end, double h) {

		if (h == 0) {
			throw new IllegalArgumentException(
					"impossible to create such function, there is no increase in the argument");
		}
		if (h > 0) {
			if (end < start) {
				throw new IllegalArgumentException(
						"impossible to create such function, end of the segment must be greater than the start");
			}

		}
		if (h < 0) {
			if (start > end) {
				throw new IllegalArgumentException(
						"impossible to create such function, end of the segment must be less than the start");
			}

		}
		if ((start == 0) && (end == 0)) {
			throw new IllegalArgumentException(
					"impossible to create such function,end and sturt must be different ");
		}
		Map <Double, Double> tempMapOfArgumentsAndFunctions = new TreeMap<Double, Double>();
		double argument = start;

		for (int i = 0; i <= Math.abs((int) ((start - end) / h)); i++) {
			double function = (Math.tan(2 * argument) - 3);
			tempMapOfArgumentsAndFunctions.put(argument, function);
			argument = argument + h;
		}

		mapOfArgumentsAndFunctions = tempMapOfArgumentsAndFunctions;
	}

	public TreeMap<Double, Double> getMap() {
		return (TreeMap<Double, Double>) mapOfArgumentsAndFunctions;
	}

	double formatDouble(double number, int accuracy) {
		double tempNumber = Math.pow(10, accuracy);
		return Math.round(number * tempNumber) / tempNumber;
	}

	public TreeMap<Double, Double> truncationArguments(
			TreeMap<Double, Double> mapOfArgumentsAndFunctions, int accuracy) {
		if (mapOfArgumentsAndFunctions == null) {
			throw new IllegalArgumentException("create function! ");
		}
		Map<Double, Double> tempMap = new TreeMap<Double, Double>();
		for (Map.Entry<Double, Double> temp : mapOfArgumentsAndFunctions
				.entrySet()) {

			tempMap.put(formatDouble(temp.getKey(), accuracy), temp.getValue());
		}

		return (TreeMap<Double, Double>) tempMap;
	}

}
