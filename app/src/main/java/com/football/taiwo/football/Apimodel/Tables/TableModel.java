
package com.football.taiwo.football.Apimodel.Tables;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TableModel {

    @SerializedName("filters")
    @Expose
    public Filters filters;
    @SerializedName("competition")
    @Expose
    public Competition competition;
    @SerializedName("season")
    @Expose
    public Season season;
    @SerializedName("standings")
    @Expose
    public List<Standing> standings = null;

}