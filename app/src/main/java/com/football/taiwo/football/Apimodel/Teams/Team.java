
package com.football.taiwo.football.Apimodel.Teams;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Team {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("area")
    @Expose
    public Area area;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("shortName")
    @Expose
    public String shortName;
    @SerializedName("tla")
    @Expose
    public String tla;
    @SerializedName("crestUrl")
    @Expose
    public String crestUrl;
    @SerializedName("address")
    @Expose
    public String address;
    @SerializedName("phone")
    @Expose
    public String phone;
    @SerializedName("website")
    @Expose
    public String website;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("founded")
    @Expose
    public Integer founded;
    @SerializedName("clubColors")
    @Expose
    public String clubColors;
    @SerializedName("venue")
    @Expose
    public String venue;
    @SerializedName("lastUpdated")
    @Expose
    public String lastUpdated;

}
