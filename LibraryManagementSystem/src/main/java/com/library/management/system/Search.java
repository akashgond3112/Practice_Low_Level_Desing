package com.library.management.system;

import com.library.management.system.book.Book;
import com.library.management.system.book.BookType;

import java.util.List;

interface Search{
	public List<Book> getBookByTitle(String title);
	public List<Book> getBookByAuthor(String author);
	public List<Book> getBookByType(BookType type);
}