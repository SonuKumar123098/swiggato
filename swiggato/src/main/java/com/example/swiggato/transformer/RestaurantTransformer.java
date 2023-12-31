package com.example.swiggato.transformer;

import com.example.swiggato.dto.request.RestaurantRequest;
import com.example.swiggato.dto.response.MenuResponse;
import com.example.swiggato.dto.response.RestaurantResponse;
import com.example.swiggato.model.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantTransformer {

    public static Restaurant RestaurantResponseToRestaurant(RestaurantRequest restaurantRequest){
        return Restaurant.builder()
                .restaurantCategory(restaurantRequest.getRestaurantCategory())
                .name(restaurantRequest.getName())
                .opened(true)
                .location(restaurantRequest.getLocation())
                .contactNumber(restaurantRequest.getContactNumber())
                .availableItems(new ArrayList<>())
                .orderEntityList(new ArrayList<>())
                .build();
    }
    public static RestaurantResponse RestaurantToRestaurantResponse(Restaurant restaurant){
        // used stream api
        List<MenuResponse>menu= restaurant.getAvailableItems()
                .stream()
                .map(menuItem -> MenuItemTransformer.MenuItemToMenuResponse(menuItem))
                .collect(Collectors.toList());
        return RestaurantResponse.builder()
                .contactNumber(restaurant.getContactNumber())
                .opened(restaurant.isOpened())
                .location(restaurant.getLocation())
                .name(restaurant.getName())
                .menu(menu)
                .build();
    }
}
