package com.skybox.isasetiawan.emochi.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by isasetiawan on 09/02/2017.
 */

public class Lantas {
    @SerializedName("data")
    @Expose
    public List<Datum> data = null;


    public class Datum {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;
        @SerializedName("konten")
        @Expose
        public String konten;
        @SerializedName("img")
        @Expose
        public String img;

    }
}
