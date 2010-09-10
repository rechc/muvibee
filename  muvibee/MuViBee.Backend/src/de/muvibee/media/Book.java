package de.muvibee.media;

import java.awt.image.BufferedImage;

public class Book extends Media{
	private String author;
	private String language;
	private String isbn;

	public Book(String author, String language, String isbn, String title,
			String ean, String genre, int year, String location, String lendTo,
			String lendDate, String backDate, int rating, String description,
			String comment, BufferedImage cover, boolean isDeleted) {
		super(title, ean, genre, year, location, lendTo, lendDate, backDate, rating, description, comment, cover, isDeleted);
		this.author = author;
		this.language = language;
		this.isbn = isbn;
	}

//----------------( Compare )--------->
	
	public int compareAuthor(String compAuthor){
		return author.compareTo(compAuthor); 
	}
	
	public int compareLanguage(String compLanguage){
		return language.compareTo(compLanguage);
	}
	
	public int compareTitle(String compTitle){
		return getTitle().compareTo(compTitle);
	}
	
	public int compareGenre(String compGenre){
		return getGenre().compareTo(compGenre);
	}
	
	public int compareRating(int compRating){
		int rating = getRating();
		if (rating == compRating)
			return 0;
		else if (rating < compRating)
			return 1;
		else
			return -1;
	}
	
//-------------( Getter & Setter )------------->
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}