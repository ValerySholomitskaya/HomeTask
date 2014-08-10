package com.epam.Valery_Sholomitskaya.java.lesson1.task3;

import java.util.Map;
import java.util.TreeMap;

public class Main {
	public static void printMapOfArgumentsAndOfFunctions(
			TreeMap<Double, Double> mapOfArgumentsAndFunctions) {
		for (Map.Entry<Double, Double> temp : mapOfArgumentsAndFunctions
				.entrySet()) {
			System.out.print(temp.getKey());
			System.out.print("			");
			System.out.println(temp.getValue());
		}

	}

	public static void main(String[] args) {
		Function function = new Function();
		double start = 0.1;
		double end = 0.8;
		double h = 0.1;
		int accuracy = 3;

		try {
			function.qreateFunction(start, end, h);
			printMapOfArgumentsAndOfFunctions(function.truncationArguments(
					function.getMap(), accuracy));

		} catch (IllegalArgumentException e) {
			e.printStackTrace();

		}

	}

}
