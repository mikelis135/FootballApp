
package com.football.taiwo.football.Apimodel.Fixtures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HalfTime {

    @SerializedName("homeTeam")
    @Expose
    public Integer homeTeam;
    @SerializedName("awayTeam")
    @Expose
    public Integer awayTeam;

}
