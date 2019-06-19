package com.amco.tv.model.program;

import com.squareup.moshi.Json;

public class Rating {

    @Json(name = "average")
    private String average;

    public void setAverage(String average) {
        this.average = average;
    }

    public String getAverage() {
        return average;
    }

    @Override
    public String toString() {
        return
                "Rating{" +
                        "average = '" + average + '\'' +
                        "}";
    }
}