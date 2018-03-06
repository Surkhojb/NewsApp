package com.clean.juanjo.newsapp.domain.model;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 06/03/2018.
 */

public interface Mapper<A extends Object,B extends Object> {
    A map(B b);
    B inverseMap(A a);
}
