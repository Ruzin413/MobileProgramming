package com.example.androidproject.movies;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
public class MovieContainer {
    @SerializedName("page")
    @Expose
     int page;
    @SerializedName("results")
    @Expose
    List<MovieResults> resultlist;
    public List<MovieResults> getResultlist() {
        return resultlist;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public void setResultlist(List<MovieResults> resultlist) {
        this.resultlist = resultlist;
    }

}