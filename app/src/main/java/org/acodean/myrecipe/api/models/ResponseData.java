package org.acodean.myrecipe.api.models;

public class ResponseData {

    String id,title,destination,shortUrl,image;

    public ResponseData(String id, String title, String destination, String shortUrl) {
        this.id = id;
        this.title = title;
        this.destination = destination;
        this.shortUrl = shortUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

}
