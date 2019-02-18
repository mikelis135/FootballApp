
package com.football.taiwo.football.Apimodel.Tables;

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
    public String code;
    @SerializedName("plan")
    @Expose
    public String plan;
    @SerializedName("lastUpdated")
    @Expose
    public String lastUpdated;

}
