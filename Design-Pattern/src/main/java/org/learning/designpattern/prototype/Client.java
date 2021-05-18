package org.learning.designpattern.prototype;

public class Client {

	public static void main(String[] args) throws CloneNotSupportedException {
		BookShop bookShop = new BookShop();
		bookShop.setName("BookShop_1");
		bookShop.loadDate();
		
		
		
		BookShop bookShop2 = bookShop.clone();
		bookShop.getBooks().remove(2);
		bookShop2.setName("BookShop_2");
		
		
		System.out.println(bookShop.hashCode());
		System.out.println(bookShop2.hashCode());

	}

}
