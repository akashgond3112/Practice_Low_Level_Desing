package com.library.management.system.book;


import com.library.management.system.Rack;

public class BookItem extends Book{
	Long uuid;
	Rack rack;
	BookGenre bookgenre;
	Double price;
	BookStatus status;
}