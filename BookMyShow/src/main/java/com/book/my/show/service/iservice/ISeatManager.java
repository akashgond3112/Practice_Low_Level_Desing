package com.book.my.show.service.iservice;


import com.book.my.show.exceptions.ShowNotFoundException;
import com.book.my.show.model.Seat;

import java.util.List;
import java.util.Set;

public interface ISeatManager {
    Set<Seat> getAvailableSeats(Long showId) throws ShowNotFoundException;
    Set<Seat> getUnAvailableSeats(Long showId) throws ShowNotFoundException;
}
