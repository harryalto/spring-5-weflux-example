package com.hnath.learn.reactivespring.model.movies;

import java.util.ArrayList;
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
public class Moviedetails {

    ArrayList<String> countries = new ArrayList<String>();
    ArrayList<String> genres = new ArrayList<String>();
    ArrayList<String> writers = new ArrayList<String>();
    ArrayList<String> actors = new ArrayList<String>();

    @PersistenceConstructor
    public Moviedetails(final ArrayList<String> countries, final ArrayList<String> genres,
            final ArrayList<String> writers, final ArrayList<String> actors, final String title, final float year,
            final String rated,
            final String released, final float runtime, final String director, final String plot, final String poster,
            final Imdb imdb, final Tomato tomato, final float metacritic,
            final Awards awards, final String type) {
        this.countries = countries;
        this.genres = genres;
        this.writers = writers;
        this.actors = actors;
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.director = director;
        this.plot = plot;
        this.poster = poster;
        this.imdb = imdb;
        this.tomato = tomato;
        this.metacritic = metacritic;
        this.awards = awards;
        this.type = type;
    }

    @Id
    private String id;
    private String title;
    private float year;
    private String rated;
    private String released;
    private float runtime;
    private String director;
    private String plot;
    private String poster;
    private Imdb imdb;
    private Tomato tomato;
    private float metacritic;
    private Awards awards;
    private String type;

}


