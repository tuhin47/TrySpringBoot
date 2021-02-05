package com.tuhin.springboot.entityinheritance.singletable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("1")
public class Book extends MyProduct {
    private String author;

    public Book(long productId, String name, String author) {
        super(productId, name);
        this.author = author;
    }
}
