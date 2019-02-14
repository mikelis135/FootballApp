package com.juangm.starwarsmvp.data.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.juangm.starwarsmvp.data.models.Character;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PeopleResponse {

    private int count;
    private String next;
    private String previous;
    private List<Character> results = new ArrayList<>();

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

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }
}
