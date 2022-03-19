package com.tuhin.springboot.overflow.q71522210;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantServices service;

    @GetMapping
    public Page<RestaurantDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public RestaurantDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }
    
    @GetMapping(value = "/winner")
    public Restaurant findWinner(Integer count) throws NotFoundException
    {
        return service.findWinner(count);     
    };

    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant newRestaurant) {
        return service.addRestaurant(newRestaurant);
    }
    
}