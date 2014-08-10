package com.epam.Valery_Sholomitskaya.java.lesson1.task4;

import java.util.ArrayList;


public class Main {
	public static void printArrayOfNumbers(ArrayList<Double> arrayList){
		for (double element : arrayList) {
			System.out.print(element + " ");
		
		}
	}
	

	public static void main(String[] args) {
		ArrayList<Double> arrayOfNumbers = new ArrayList<Double> ();
		arrayOfNumbers.add(1.0);
		arrayOfNumbers.add(1.0);
		arrayOfNumbers.add(2.0);
		arrayOfNumbers.add(9.0);
		arrayOfNumbers.add(3.0);
		arrayOfNumbers.add(5.0);
		Numbers number=new Numbers();
		try {
			number.createArrayOfNumbers(arrayOfNumbers);
			printArrayOfNumbers(number.getArrayOfSequence());
			System.out.println("   ");
			System.out.println(number.MaxSum(number.ArrayOfSumOfTwoNumbers(number.getArrayOfSequence())));

		} catch (IllegalArgumentException e) {
			e.printStackTrace();

		}
		
	}

}
