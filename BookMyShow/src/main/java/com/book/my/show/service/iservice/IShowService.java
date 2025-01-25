package com.book.my.show.service.iservice;


import com.book.my.show.exceptions.ShowAlreadyExistsException;
import com.book.my.show.exceptions.ShowNotFoundException;
import com.book.my.show.model.Show;

public interface IShowService {
    Show getShowById(Long id) throws ShowNotFoundException;
    Boolean addShow(Show show) throws ShowAlreadyExistsException;
}
