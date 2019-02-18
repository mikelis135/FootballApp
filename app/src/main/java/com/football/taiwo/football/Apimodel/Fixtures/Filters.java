
package com.football.taiwo.football.Apimodel.Fixtures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Filters {

    @SerializedName("permission")
    @Expose
    public String permission;
    @SerializedName("limit")
    @Expose
    public Integer limit;

}
