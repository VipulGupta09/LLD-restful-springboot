package org.learning.designpattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class BookShop implements Cloneable {
	private String name;
	private List<Book> books = new ArrayList<Book>();

	public void loadDate() {
		for (int i = 0; i < 10; i++) {
			Book book = new Book();
			book.setId(i);
			book.setName("Book_" + i);
			books.add(book);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "BookShop [name=" + name + ", books=" + books + "]";
	}

	@Override
	protected BookShop clone() throws CloneNotSupportedException {
		 return (BookShop) super.clone(); //Swallow Copy

		//deepcopy
		/*
		 * BookShop bookShop = new BookShop(); for (Book b : this.getBooks()) {
		 * bookShop.getBooks().add(b); } return bookShop;
		 */
	}

}
