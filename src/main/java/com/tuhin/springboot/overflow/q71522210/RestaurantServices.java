package com.tuhin.springboot.overflow.q71522210;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class RestaurantServices {

    @Autowired
    private RestaurantRepository repository;

    @Transactional(readOnly = true)
    public Page<RestaurantDTO> findAll(Pageable pageable) {
        Page<Restaurant> result = repository.findAll(pageable);
        Page<RestaurantDTO> page = result.map(x -> new RestaurantDTO(x));
        return page;
    }

    @Transactional(readOnly = true)
    public RestaurantDTO findById(Long id) {
        Restaurant result = repository.findById(id).get();
        RestaurantDTO dto = new RestaurantDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public Restaurant findWinner(Integer count) throws NotFoundException
    {
        /*List<Restaurant> restaurants = repository.findAll();

        for (Restaurant restaurant : restaurants) {
            // Hibernate.initialize(restaurant.getCount());
            if (restaurant.getCount() >= 3) {
                return restaurant;
            }
        }*/
        Optional<Restaurant> data = repository.findFirstByCountGreaterThanEqualOrderByCountDesc(2);
        if (data.isPresent())
        {
            return data.get();
        }

        throw new NotFoundException("Nenhum restaurante ganhou a votação, é necessário um total de 3 votos para ter um restaurante vencedor.");
    }   

    @Transactional
    public Restaurant addRestaurant(Restaurant newRestaurant) {
        return repository.saveAndFlush(newRestaurant);
    }



}