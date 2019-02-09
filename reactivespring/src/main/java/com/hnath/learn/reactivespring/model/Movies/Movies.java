package com.hnath.learn.reactivespring.model.movies;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Document
@Getter
@Setter
@ToString(exclude = {"id"})
public class Movies {

    @Id
    private String id;

    private String imdb;
    private String title;
    private String type;
    private Number year;



    @PersistenceConstructor
    public Movies(String imdb, String title,  String type, Number year) {
        super();
        this.imdb = imdb;
        this.title = title;
        this.type = type;
        this.year = year;
    }



}
