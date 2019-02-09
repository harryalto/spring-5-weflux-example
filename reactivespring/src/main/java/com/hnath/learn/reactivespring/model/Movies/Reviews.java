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
@ToString(exclude = { "id" })
public class Reviews {

    @Id
    private String id;
    private float rating;
    private String date;
    private String reviewer;
    private String text;

    @PersistenceConstructor
    public Reviews(final float rating, final String date, final String reviewer, final String text) {
        this.rating = rating;
        this.date = date;
        this.reviewer = reviewer;
        this.text = text;
    }
}
