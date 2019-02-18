
package com.football.taiwo.football.Apimodel.Teams;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Filters {

    @SerializedName("areas")
    @Expose
    public List<Integer> areas = null;
    @SerializedName("permission")
    @Expose
    public String permission;

}
