package com.amco.tv.model.program;

import java.util.List;

import com.squareup.moshi.Json;

public class Program {

    @Json(name = "summary")
    private String summary;

    @Json(name = "image")
    private Image image;

    @Json(name = "_links")
    private Links links;

    @Json(name = "premiered")
    private String premiered;

    @Json(name = "rating")
    private Rating rating;

    @Json(name = "runtime")
    private int runtime;

    @Json(name = "weight")
    private int weight;

    @Json(name = "language")
    private String language;

    @Json(name = "type")
    private String type;

    @Json(name = "url")
    private String url;

    @Json(name = "officialSite")
    private String officialSite;

    @Json(name = "network")
    private Network network;

    @Json(name = "schedule")
    private Schedule schedule;

    @Json(name = "webChannel")
    private Object webChannel;

    @Json(name = "genres")
    private List<String> genres;

    @Json(name = "name")
    private String name;

    @Json(name = "id")
    private int id;

    @Json(name = "externals")
    private Externals externals;

    @Json(name = "updated")
    private int updated;

    @Json(name = "status")
    private String status;

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Links getLinks() {
        return links;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }

    public String getPremiered() {
        return premiered;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setOfficialSite(String officialSite) {
        this.officialSite = officialSite;
    }

    public String getOfficialSite() {
        return officialSite;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public Network getNetwork() {
        return network;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setWebChannel(Object webChannel) {
        this.webChannel = webChannel;
    }

    public Object getWebChannel() {
        return webChannel;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getGenres() {
        return genres;
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

    public void setExternals(Externals externals) {
        this.externals = externals;
    }

    public Externals getExternals() {
        return externals;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    public int getUpdated() {
        return updated;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return
                "Program{" +
                        "summary = '" + summary + '\'' +
                        ",image = '" + image + '\'' +
                        ",_links = '" + links + '\'' +
                        ",premiered = '" + premiered + '\'' +
                        ",rating = '" + rating + '\'' +
                        ",runtime = '" + runtime + '\'' +
                        ",weight = '" + weight + '\'' +
                        ",language = '" + language + '\'' +
                        ",type = '" + type + '\'' +
                        ",url = '" + url + '\'' +
                        ",officialSite = '" + officialSite + '\'' +
                        ",network = '" + network + '\'' +
                        ",schedule = '" + schedule + '\'' +
                        ",webChannel = '" + webChannel + '\'' +
                        ",genres = '" + genres + '\'' +
                        ",name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        ",externals = '" + externals + '\'' +
                        ",updated = '" + updated + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}