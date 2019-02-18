
package com.football.taiwo.football.Apimodel.Fixtures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Penalties {

    @SerializedName("homeTeam")
    @Expose
    public Object homeTeam;
    @SerializedName("awayTeam")
    @Expose
    public Object awayTeam;

}
