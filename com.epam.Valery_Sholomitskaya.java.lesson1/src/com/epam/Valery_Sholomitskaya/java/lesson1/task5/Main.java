package com.epam.Valery_Sholomitskaya.java.lesson1.task5;



public class Main {

	public static void printMatrix(int[][] matrix){
		
		for (int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length;j++){
				System.out.print(matrix[i][j] +

				        "\t");
			}
			 System.out.println();
		}
	}
	public static void main(String[] args) {
		Matrix matrix=new Matrix();
		int size=6;
		try {
			matrix.createMatrixWithNulls(size);
			printMatrix(matrix.MatrixFillNulls(matrix.getMatrix(), matrix.getSize()));

		} catch (IllegalArgumentException e) {
			e.printStackTrace();

		}
		

	}

}
