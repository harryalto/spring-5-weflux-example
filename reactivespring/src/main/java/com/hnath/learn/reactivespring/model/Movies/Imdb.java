package com.hnath.learn.reactivespring.model.Movies;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Data
@Getter
@Setter
public class Imdb {


    private String id;

    private float rating;
    private float votes;

    @PersistenceConstructor
    public Imdb(final float rating, final float votes) {
        this.rating = rating;
        this.votes = votes;
    }
}
