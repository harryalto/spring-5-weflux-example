package com.hnath.learn.reactivespring.model.movies;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;


@Document
@Getter
@Setter
public class Tomato {

    private float meter;
    private String image;
    private float rating;
    private float reviews;
    private float fresh;
    private String consensus;
    private float userMeter;
    private float userRating;
    private float userReviews;

}
