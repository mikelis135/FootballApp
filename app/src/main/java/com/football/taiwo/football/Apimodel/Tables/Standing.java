
package com.football.taiwo.football.Apimodel.Tables;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Standing {

    @SerializedName("stage")
    @Expose
    public String stage;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("group")
    @Expose
    public Object group;
    @SerializedName("table")
    @Expose
    public List<Table> table = null;

}