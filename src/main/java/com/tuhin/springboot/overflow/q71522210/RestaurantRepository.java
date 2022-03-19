package com.tuhin.springboot.overflow.q71522210;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>
{

    Optional<Restaurant> findFirstByCountGreaterThanEqualOrderByCountDesc (Integer count);

}