package com.amco.tv.model.storage;

import com.amco.tv.model.MoviesRate;
import com.amco.tv.model.ResultsItem;

import java.util.List;

/**
 * Clase que almacena datos persistentes.
 */

public class DataSession {

    private final static String TAG = DataSession.class.getSimpleName();
    private static DataSession ourInstance = null;

    private MoviesRate moviesRate;
    private ResultsItem movieSelected;

    public static DataSession getInstance() {
        if (ourInstance == null)
            ourInstance = new DataSession();
        return ourInstance;
    }

    public MoviesRate getMoviesRate() {
        return moviesRate;
    }

    public void setMoviesRate(MoviesRate moviesRate) {
        this.moviesRate = moviesRate;
    }

    public ResultsItem getMovieSelected() {
        return movieSelected;
    }

    public void setMovieSelected(ResultsItem movieSelected) {
        this.movieSelected = movieSelected;
    }
}
