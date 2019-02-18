
package com.football.taiwo.football.Apimodel.Tables;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Team {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("crestUrl")
    @Expose
    public String crestUrl;

}
