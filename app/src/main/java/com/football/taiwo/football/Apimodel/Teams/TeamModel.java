
package com.football.taiwo.football.Apimodel.Teams;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamModel {

    @SerializedName("count")
    @Expose
    public Integer count;
    @SerializedName("filters")
    @Expose
    public Filters filters;
    @SerializedName("teams")
    @Expose
    public final List<Team> teams = null;

}
