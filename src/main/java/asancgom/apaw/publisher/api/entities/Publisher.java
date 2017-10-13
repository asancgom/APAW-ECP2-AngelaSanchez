package asancgom.apaw.publisher.api.entities;

import java.util.Calendar;

import asancgom.apaw.publisher.api.entities.Author;

public class Publisher {
	private int id;
	private String title;
	private String city;
	private Calendar date;
	private Author author;

	public Publisher() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getTitle() {
		return this.title;
	}

	public String getCity() {
		return this.city;
	}

	public Calendar getDate() {
		return this.date;
	}

	public Author getAuthor() {
		return this.author;
	}

	public int getId() {
		return this.id;
	}
}
