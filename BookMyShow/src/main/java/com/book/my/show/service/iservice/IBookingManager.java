package com.book.my.show.service.iservice;


import com.book.my.show.model.Seat;
import com.book.my.show.model.Ticket;
import com.book.my.show.model.User;

import java.util.List;

public interface IBookingManager {
    Ticket bookSeats(User user, List<Seat> seats);
}
