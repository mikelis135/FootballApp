
package com.football.taiwo.football.Apimodel.Player35;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Score {

    @SerializedName("winner")
    @Expose
    public Object winner;
    @SerializedName("duration")
    @Expose
    public String duration;
    @SerializedName("fullTime")
    @Expose
    public FullTime fullTime;
    @SerializedName("halfTime")
    @Expose
    public HalfTime halfTime;
    @SerializedName("extraTime")
    @Expose
    public ExtraTime extraTime;
    @SerializedName("penalties")
    @Expose
    public Penalties penalties;

}
