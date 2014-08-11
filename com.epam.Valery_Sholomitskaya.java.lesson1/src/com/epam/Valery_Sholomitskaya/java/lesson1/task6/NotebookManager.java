package com.epam.Valery_Sholomitskaya.java.lesson1.task6;

public class NotebookManager {
	Notebook notebook = new Notebook();

	public void lookAllRecords() {
		if (notebook.getArrayOfRecords().size() == 0) {
			System.out.println("Notebook has no records");
		} else {
			for (Record element : notebook.getArrayOfRecords()) {
				System.out.println(element.getRecord());
			}

		}
	}

	/**
	 * add record into notebook.
	 * 
	 * @param recordOfUser
	 *            recordOfUser text of record
	 * @param id
	 *            number of record
	 * @throws IllegalArgumentException
	 *             ("incorrect id") if id is incorrect
	 * @throws IllegalArgumentException
	 *             ("such id already exist") if id of record already exist
	 **/
	public void addRecord(String recordOfUser, int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("incorrect id");
		}
		for (Record element : notebook.getArrayOfRecords()) {
			if (element.getId() == id) {
				throw new IllegalArgumentException("such id already exist");
			}
		}

		Record record = new Record();
		record.setRecord(recordOfUser);
		record.setId(id);
		notebook.setArrayOfRecords(record);
	}

	/**
	 * delete record from notebookById.
	 * 
	 * @param id
	 *            number of record
	 * @throws IllegalArgumentException
	 *             ("incorrect id") if id is incorrect
	 **/
	public void deleteRecordById(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("incorrect id");
		}
		boolean result = false;
		for (Record element : notebook.getArrayOfRecords()) {
			if (element.getId() == id) {
				notebook.getArrayOfRecords().remove(element);
				result = true;

			}
		}
		if (result == false) {

			System.out.println("there is no record with such id");

		}
	}

	/**
	 * delete record from notebook by text.
	 * 
	 * @param text
	 *            text of record
	 * @throws IllegalArgumentException
	 *             ("incorrect id") if id is incorrect
	 **/
	public void deleteRecordByText(String text) {

		boolean result = false;

		for (int i = 0; i < notebook.getArrayOfRecords().size(); i++) {
			if (text.equals(notebook.getArrayOfRecords().get(i).getRecord())) {
				notebook.getArrayOfRecords().remove(
						notebook.getArrayOfRecords().get(i).getRecord());
				notebook.getArrayOfRecords().remove(
						notebook.getArrayOfRecords().get(i).getId());
				result = true;
			}

		}
		if (result == false) {

			System.out.println("there is no record with such text");

		}
	}

	/**
	 * edit record in notebook by id.
	 * 
	 * @param newRecord
	 *            new text of record
	 * @param id
	 *            number of record
	 * @throws IllegalArgumentException
	 *             ("incorrect id") if id is incorrect
	 **/
	public void editRecordById(int id, String newRecord) {
		if (id <= 0) {
			throw new IllegalArgumentException("incorrect id");
		}
		boolean result = false;
		for (Record element : notebook.getArrayOfRecords()) {
			if (element.getId() == id) {
				element.setRecord(newRecord);
				result = true;
			}
		}
		if (result == false) {
			System.out.println("there is no record with such id");
		}
	}

	/**
	 * edit record in notebook by text.
	 * 
	 * @param newRecord
	 *            new text of record
	 * @param oldRecord
	 *           text of record by which we find record
	 * @throws IllegalArgumentException
	 *             ("incorrect id") if id is incorrect
	 **/
	public void editRecordByText(String oldRecord, String newRecord) {
		boolean result = false;

		for (int i = 0; i < notebook.getArrayOfRecords().size(); i++) {
			if (oldRecord.equals(notebook.getArrayOfRecords().get(i)
					.getRecord())) {
				notebook.getArrayOfRecords().get(i).setRecord(newRecord);
				result = true;
			}

		}
		if (result == false) {

			System.out.println("there is no record with such text");

		}
	}
}
