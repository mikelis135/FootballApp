
package com.football.taiwo.football.Apimodel.Player35;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Match35 {

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
