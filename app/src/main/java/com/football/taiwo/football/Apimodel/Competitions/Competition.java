
package com.football.taiwo.football.Apimodel.Competitions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Competition {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("area")
    @Expose
    public Area area;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("code")
    @Expose
    public Object code;
    @SerializedName("emblemUrl")
    @Expose
    public Object emblemUrl;
    @SerializedName("plan")
    @Expose
    public String plan;
    @SerializedName("currentSeason")
    @Expose
    public CurrentSeason currentSeason;
    @SerializedName("numberOfAvailableSeasons")
    @Expose
    public Integer numberOfAvailableSeasons;
    @SerializedName("lastUpdated")
    @Expose
    public String lastUpdated;

}
