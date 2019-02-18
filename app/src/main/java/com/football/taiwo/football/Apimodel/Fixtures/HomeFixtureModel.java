
package com.football.taiwo.football.Apimodel.Fixtures;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeFixtureModel {

    @SerializedName("count")
    @Expose
    public Integer count;
    @SerializedName("filters")
    @Expose
    public Filters filters;
    @SerializedName("matches")
    @Expose
    public List<Match> matches = null;

}
