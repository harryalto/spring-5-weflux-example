package com.hnath.learn.reactivespring.model.Movies;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class Awards {
    private float wins;
    private float nominations;
    private String text;

}
