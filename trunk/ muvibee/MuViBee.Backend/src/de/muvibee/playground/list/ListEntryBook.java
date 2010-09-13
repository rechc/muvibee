package de.muvibee.playground.list;

import de.muvibee.media.Book;

@SuppressWarnings("serial")
public class ListEntryBook extends ListEntry{

	public ListEntryBook(Book book) {
		super(book, book.getAuthor());
	}
}
