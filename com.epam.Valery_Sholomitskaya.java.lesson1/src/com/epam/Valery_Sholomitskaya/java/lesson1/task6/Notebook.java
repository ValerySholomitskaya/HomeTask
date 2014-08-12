package com.epam.Valery_Sholomitskaya.java.lesson1.task6;

import java.util.ArrayList;

public class Notebook {

	private ArrayList<Record> arrayOfRecords = new ArrayList<Record>();

	public ArrayList<Record> getArrayOfRecords() {
		return arrayOfRecords;
	}

	public void setArrayOfRecords(Record note) {
		this.arrayOfRecords.add(note);
	}

}
