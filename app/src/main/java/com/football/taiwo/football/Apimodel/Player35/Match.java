
package com.football.taiwo.football.Apimodel.Player35;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Match {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("competition")
    @Expose
    public Competition competition;
    @SerializedName("season")
    @Expose
    public Season season;
    @SerializedName("utcDate")
    @Expose
    public String utcDate;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("matchday")
    @Expose
    public Integer matchday;
    @SerializedName("stage")
    @Expose
    public String stage;
    @SerializedName("group")
    @Expose
    public String group;
    @SerializedName("lastUpdated")
    @Expose
    public String lastUpdated;
    @SerializedName("score")
    @Expose
    public Score score;
    @SerializedName("homeTeam")
    @Expose
    public HomeTeam homeTeam;
    @SerializedName("awayTeam")
    @Expose
    public AwayTeam awayTeam;
    @SerializedName("referees")
    @Expose
    public List<Object> referees = null;

}
