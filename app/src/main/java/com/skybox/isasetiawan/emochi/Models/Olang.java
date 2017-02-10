package com.skybox.isasetiawan.emochi.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by isasetiawan on 09/02/2017.
 */

public class Olang {
    @SerializedName("data")
    @Expose
    public List<Datum> data = new ArrayList<>();

    public class Datum {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("nama")
        @Expose
        public String nama;
        @SerializedName("address")
        @Expose
        public String address;
        @SerializedName("usia")
        @Expose
        public String usia;
        @SerializedName("sex")
        @Expose
        public String sex;
        @SerializedName("img")
        @Expose
        public String img;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;
        @SerializedName("kontak")
        @Expose
        public String kontak;
        @SerializedName("validate")
        @Expose
        public String validate;
        @SerializedName("ciri")
        @Expose
        public String ciri;

    }
}
