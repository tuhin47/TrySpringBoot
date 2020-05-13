package com.tuhin.springboot.topic;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic,Long>{


//    12. Data JPA | MVC | H2 | Query Methods Example  – 01:45:12

    List<Topic> findByIdGreaterThan(long id);

    @Query("from Topic order by name")
    List<Topic> findTopicsOrderByName();

    Topic findOneTopicByIdAndName(long id, String name);

    Topic findFirstTopicByName(String name);

    List<Topic> findByDescriptionContainsOrNameContainsAllIgnoreCase(String descriptionPart,
                                                                     String namePart);

//    @Query("from Topic where id=?1 and name=?2 limit 1")

}
