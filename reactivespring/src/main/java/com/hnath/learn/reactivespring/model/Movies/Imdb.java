package com.hnath.learn.reactivespring.model.movies;

import org.springframework.data.annotation.PersistenceConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


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
