package com.food.kart.foodkart.strategy;

import com.food.kart.foodkart.Util.FoodKartUtil;
import com.food.kart.foodkart.model.Restaurant;
import com.food.kart.foodkart.model.User;

import java.util.*;

public class PriceStrategy implements RestaurantDisplayStrategy {
    @Override
    public List<Restaurant> findRestaurants(List<Restaurant> listOfRestaurants, User currentUser) {
        List<Restaurant> list = FoodKartUtil.getMatchingRestaurant(listOfRestaurants, currentUser);
        list.sort(new Comparator<Restaurant>() {
			@Override
			public int compare(Restaurant restaurant1, Restaurant restaurant2) {
				return Double.compare(restaurant2.getFoodItem().getPrice(), restaurant1.getFoodItem().getPrice());
			}
		});

        return list;
    }
}
