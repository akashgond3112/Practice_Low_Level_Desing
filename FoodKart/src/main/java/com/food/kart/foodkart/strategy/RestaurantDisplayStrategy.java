package com.food.kart.foodkart.strategy;


import com.food.kart.foodkart.model.Restaurant;
import com.food.kart.foodkart.model.User;

import java.util.List;

public interface RestaurantDisplayStrategy {
    public List<Restaurant> findRestaurants(List<Restaurant> listOfRestaurants, User currentUser);
}
