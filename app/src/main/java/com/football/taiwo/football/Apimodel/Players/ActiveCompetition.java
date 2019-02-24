
package com.football.taiwo.football.Apimodel.Players;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class ActiveCompetition {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("area")
    @Expose
    public Area_ area;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("code")
    @Expose
    public String code;
    @SerializedName("plan")
    @Expose
    public String plan;
    @SerializedName("lastUpdated")
    @Expose
    public String lastUpdated;

}
