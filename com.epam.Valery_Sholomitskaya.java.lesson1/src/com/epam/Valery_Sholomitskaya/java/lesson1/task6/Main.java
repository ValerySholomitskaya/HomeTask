package com.epam.Valery_Sholomitskaya.java.lesson1.task6;

public class Main {

	public static void main(String[] args) {
		try {
			NotebookManager notebookManager = new NotebookManager();
			notebookManager.addRecord("1");
			notebookManager.addRecord("2");
			notebookManager.addRecord("3");
			notebookManager.lookAllRecords();
			System.out.println("  ");
			notebookManager.deleteRecordById(2);
			notebookManager.lookAllRecords();
			notebookManager.addRecord("25");
			notebookManager.deleteRecordByText("1");
			System.out.println("  ");
			notebookManager.lookAllRecords();
			notebookManager.editRecordById(1, "aaa");
			System.out.println("  ");
			notebookManager.lookAllRecords();
			notebookManager.editRecordByText("25", "rty");
			System.out.println("  ");
			notebookManager.lookAllRecords();

		} catch (IllegalArgumentException e) {
			e.printStackTrace();

		}

	}

}
