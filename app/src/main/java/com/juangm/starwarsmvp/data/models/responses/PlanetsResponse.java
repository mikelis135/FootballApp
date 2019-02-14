package com.juangm.starwarsmvp.data.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.juangm.starwarsmvp.data.models.Planet;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetsResponse {

    private int count;
    private String next;
    private String previous;
    private List<Planet> results = new ArrayList<>();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Planet> getResults() {
        return results;
    }

    public void setResults(ArrayList<Planet> results) {
        this.results = results;
    }
}
