package com.library.management.system;

import com.library.management.system.book.BookIssueService;
import com.library.management.system.book.BookItem;

class Librarian extends SystemUser {
	Search searchObj;
	BookIssueService bookIssueService;

	public void addBook(BookItem bookItem) {

	}

	public BookItem deleteBook(BookItem bookItem) {
		return null;
	}

	public BookItem editBook(BookItem bookItem) {
		return null;
	}
}