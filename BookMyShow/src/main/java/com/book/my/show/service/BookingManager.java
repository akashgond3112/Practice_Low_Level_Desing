package com.book.my.show.service;


import com.book.my.show.model.Seat;
import com.book.my.show.model.Ticket;
import com.book.my.show.model.User;
import com.book.my.show.service.iservice.IBookingManager;
import com.book.my.show.service.iservice.IPaymentManager;
import com.book.my.show.service.iservice.ISeatManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookingManager implements IBookingManager {
    @Autowired
    private ISeatManager seatManager;

    @Autowired
    private IPaymentManager paymentManager;

    public Ticket bookSeats(User user, List<Seat> seats) {
        //check all seats are available

        //lock all the seats

        //to payment

        //if unsuccessful payment release all the earlier locked seats and update Booking status

        return null;
    }
}
