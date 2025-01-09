package com.book.my.show.service;

import com.book.my.show.exceptions.ShowAlreadyExistsException;
import com.book.my.show.exceptions.ShowNotFoundException;
import com.book.my.show.model.Show;
import com.book.my.show.service.iservice.IShowService;

import java.util.concurrent.ConcurrentHashMap;

public class ShowService implements IShowService {
    ConcurrentHashMap<Long, Show> showMap;

    public ShowService() {
        this.showMap = new ConcurrentHashMap<>();
    }

    public Show getShowById(Long id) throws ShowNotFoundException {
        if(showMap.contains(id))
            return showMap.get(id);
        throw new ShowNotFoundException(id);
    }

    public Boolean addShow(Show show) throws ShowAlreadyExistsException {
        if(show!=null && showMap.contains(show.getId()))
            throw new ShowAlreadyExistsException(show.getId());
		assert show != null;
		showMap.put(show.getId(),show);
        return true;
    }
}
