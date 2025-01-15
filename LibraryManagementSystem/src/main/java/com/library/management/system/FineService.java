package com.library.management.system;


import com.library.management.system.book.BookItem;

import java.util.Date;

public class FineService{
	public Fine calculateFine(BookItem bookItem, SystemUser user, int days) {
		return null;
	}
}

class Fine{
	Date fineDate;
	BookItem book;
	SystemUser user;
	Double fineValue;
}