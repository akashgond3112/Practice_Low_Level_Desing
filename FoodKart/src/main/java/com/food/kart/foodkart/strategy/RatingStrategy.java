package com.food.kart.foodkart.strategy;

import com.food.kart.foodkart.Util.FoodKartUtil;
import com.food.kart.foodkart.model.Restaurant;
import com.food.kart.foodkart.model.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RatingStrategy implements RestaurantDisplayStrategy {
    @Override
    public List<Restaurant> findRestaurants(List<Restaurant> listOfRestaurants, User currentUser) {
        List<Restaurant> list = FoodKartUtil.getMatchingRestaurant(listOfRestaurants, currentUser);
        list.sort(new Comparator<Restaurant>() {
			@Override
			public int compare(Restaurant o1, Restaurant o2) {
				return Double.compare(o2.getRestaurantRating(), o1.getRestaurantRating());
			}
		});
        return list;
    }
}
