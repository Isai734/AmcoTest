package com.amco.tv.model.cast;

import com.amco.tv.model.program.Image;
import com.squareup.moshi.Json;

public class Person {

    @Json(name = "birthday")
    private Object birthday;

    @Json(name = "country")
    private Object country;

    @Json(name = "image")
    private Image image;

    @Json(name = "gender")
    private Object gender;

    @Json(name = "_links")
    private Links links;

    @Json(name = "name")
    private String name;

    @Json(name = "id")
    private int id;

    @Json(name = "deathday")
    private Object deathday;

    @Json(name = "url")
    private String url;

    public void setBirthday(Object birthday) {
        this.birthday = birthday;
    }

    public Object getBirthday() {
        return birthday;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public Object getCountry() {
        return country;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public Object getGender() {
        return gender;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Links getLinks() {
        return links;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDeathday(Object deathday) {
        this.deathday = deathday;
    }

    public Object getDeathday() {
        return deathday;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return
                "Person{" +
                        "birthday = '" + birthday + '\'' +
                        ",country = '" + country + '\'' +
                        ",image = '" + image + '\'' +
                        ",gender = '" + gender + '\'' +
                        ",_links = '" + links + '\'' +
                        ",name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        ",deathday = '" + deathday + '\'' +
                        ",url = '" + url + '\'' +
                        "}";
    }
}