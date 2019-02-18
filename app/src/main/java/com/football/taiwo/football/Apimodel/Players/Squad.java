
package com.football.taiwo.football.Apimodel.Players;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Squad {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("position")
    @Expose
    public String position;
    @SerializedName("dateOfBirth")
    @Expose
    public String dateOfBirth;
    @SerializedName("countryOfBirth")
    @Expose
    public String countryOfBirth;
    @SerializedName("nationality")
    @Expose
    public String nationality;
    @SerializedName("shirtNumber")
    @Expose
    public Object shirtNumber;
    @SerializedName("role")
    @Expose
    public String role;

}
