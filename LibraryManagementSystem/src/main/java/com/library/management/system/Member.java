package com.library.management.system;

import com.library.management.system.book.BookIssueService;

class Member extends SystemUser{
	int totCheckoutBooks;
	Search searchObj;
	BookIssueService bookIssueService;
}