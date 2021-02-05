package com.tuhin.springboot.entityinheritance.singletable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type", discriminatorType = DiscriminatorType.INTEGER)
// @DiscriminatorFormula("case when author is not null then 1 else 2 end")
public class MyProduct {
    @Id
    private long productId;

    private String name;


}
