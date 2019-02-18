
package com.football.taiwo.football.Apimodel.Player35;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Filters {

    @SerializedName("dateFrom")
    @Expose
    public String dateFrom;
    @SerializedName("dateTo")
    @Expose
    public String dateTo;
    @SerializedName("permission")
    @Expose
    public String permission;

}
