package com.epam.Valery_Sholomitskaya.java.lesson1.task5;

public class Matrix {

	private int matrixOfUser[][] = null;
	private int size;
	public int[][] getMatrix() {
		return matrixOfUser;
	}
	public int getSize() {
		return size;
	}
	public void createMatrixWithNulls(int sizeOfUser) {
		if (sizeOfUser <= 0) {
			throw new IllegalArgumentException(
					"impossible to create matrix, insert another size");
		}
		int matrix[][] = new int[sizeOfUser][sizeOfUser];
		for (int i = 0; i < sizeOfUser; i++) {
			for (int j = 0; j < sizeOfUser; j++) {
				matrix[i][j] = 0;
				;
			}
		}

		matrixOfUser = matrix;
		size=sizeOfUser;
	}
	boolean isOnDiaganal(int i, int j, int size)
	{
	    return i == j || j==size-i-1 ;
	}
	
	
	public int[][] MatrixFillNulls(int[][] matrix, int size) {
		if (matrixOfUser == null) {
			throw new IllegalArgumentException("create matrix! ");
		}
		 for (int i = 0; i < size; i++)
		    {
		        for (int j = 0; j < size; j++)
		        {
		            if (isOnDiaganal(i,j,size)){
		                matrix[i][j] = 1;
		            }

		        }

		    }
		return matrix;
	}
}
