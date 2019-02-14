package com.juangm.starwarsmvp.data.network;

import com.juangm.starwarsmvp.data.models.responses.PeopleResponse;
import com.juangm.starwarsmvp.data.models.responses.PlanetsResponse;
import com.juangm.starwarsmvp.data.models.responses.StarshipsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StarWarsService {

    /**
     * Retrieve a list of planets
     */
    @GET("planets/")
    Call<PlanetsResponse> getPlanets();

    /**
     * Retrieve a list of people
     */
    @GET("people/")
    Call<PeopleResponse> getPeople();

    /**
     * Retrieve a list of starships
     */
    @GET("starships/")
    Call<StarshipsResponse> getStarships();
}
