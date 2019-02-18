
package com.football.taiwo.football.Apimodel.Teams;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamModel {

    @SerializedName("count")
    @Expose
    public Integer count;
    @SerializedName("filters")
    @Expose
    public Filters filters;
    @SerializedName("teams")
    @Expose
    public List<Team> teams = null;

}
