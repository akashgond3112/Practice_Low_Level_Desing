package com.library.management.system.book;

import com.library.management.system.ReservationStatus;
import com.library.management.system.SystemUser;

import java.util.Date;

class BookLanding{
	BookItem book;
	SystemUser user;
	Date issueDate;
}

class BookReservationDetails extends BookLanding{
	ReservationStatus reservationStatus;
}

class BookIssueDetails extends BookLanding{
	Date dueDate;
}