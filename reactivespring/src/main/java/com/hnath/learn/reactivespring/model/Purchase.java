package com.hnath.learn.reactivespring.model;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;
import lombok.Getter;
import lombok.Setter;



@Document
@Getter
@Setter
@ToString(exclude = {"id"})
public class Purchase {

    @Id
    private String id;

    private String name;
    private String price;
    private LocalDateTime createdAt;

    @PersistenceConstructor
    public Purchase(String name, String price,  LocalDateTime createdAt) {
        super();
        this.name = name;
        this.price = price;
        this.createdAt =createdAt ;
    }



}
