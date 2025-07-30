package models.implementation;

import models.abstraction.Person;

public class Professor extends Person {

	private int booksPublished;

	public Professor() {
	}

	public Professor(String name, int booksPublished) {
		super(name);
		this.booksPublished = booksPublished;
	}

	public int getBooksPublished() {
		return booksPublished;
	}

	public void setBooksPublished(int booksPublished) {
		this.booksPublished = booksPublished;
	}

	@Override
	public boolean isOutstanding() {
		return booksPublished >= 5;
	}

}
