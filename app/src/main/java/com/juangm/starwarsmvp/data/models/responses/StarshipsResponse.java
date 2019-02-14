package com.juangm.starwarsmvp.data.models.responses;

import com.juangm.starwarsmvp.data.models.Starship;

import java.util.ArrayList;
import java.util.List;

public class StarshipsResponse {

    private int count;
    private String next;
    private String previous;
    private List<Starship> results = new ArrayList<>();

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

    public List<Starship> getResults() {
        return results;
    }

    public void setResults(List<Starship> results) {
        this.results = results;
    }
}
