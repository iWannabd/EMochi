package com.skybox.isasetiawan.emochi.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by isasetiawan on 12/02/2017.
 */

public class Spph {

    @SerializedName("nama")
    @Expose
    public String nama;
    @SerializedName("lpnum")
    @Expose
    public String lpnum;
    @SerializedName("data")
    @Expose
    public List<Datum> data = null;

    public class Datum {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("fileurl")
        @Expose
        public String fileurl;
        @SerializedName("nama")
        @Expose
        public String nama;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;
        @SerializedName("spph_id")
        @Expose
        public String spphId;

    }

}
