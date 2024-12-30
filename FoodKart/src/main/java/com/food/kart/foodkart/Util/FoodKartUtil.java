package com.food.kart.foodkart.Util;


import com.food.kart.foodkart.model.Restaurant;
import com.food.kart.foodkart.model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FoodKartUtil {
    public static List<Restaurant> getMatchingRestaurant(List<Restaurant> listOfRestaurants, User currentUser) {
        List<Restaurant> list = new ArrayList<>(listOfRestaurants);
        Iterator<Restaurant> iterator = list.iterator();
        while (iterator.hasNext()) {
            Restaurant restaurant = (Restaurant) iterator.next();
            if (!restaurant.isLocationServiceAble(currentUser.getPincode()) && restaurant.isEnoughQuantityAvailable()) {
                iterator.remove();
            }
        }
        return list;
    }
}
