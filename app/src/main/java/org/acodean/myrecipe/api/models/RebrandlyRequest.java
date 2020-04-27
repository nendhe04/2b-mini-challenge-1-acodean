package org.acodean.myrecipe.api.models;

public class RebrandlyRequest {
    String destination;

    public RebrandlyRequest(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
