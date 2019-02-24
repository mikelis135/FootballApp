
package com.football.taiwo.football.Apimodel.Competitions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeCompetitionModel {

    @SerializedName("count")
    @Expose
    public Integer count;
    @SerializedName("filters")
    @Expose
    public Filters filters;
    @SerializedName("competitions")
    @Expose
    public List<Competition> competitions = null;

}
