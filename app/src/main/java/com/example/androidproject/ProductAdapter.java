package com.example.androidproject;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.androidproject.movies.MovieResults;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
public class ProductAdapter extends RecyclerView.Adapter<ProductVH> {
    private ArrayList<MovieResults> movieResultslist = new ArrayList<>();
    private Context mcontext;
    public  ProductAdapter(ArrayList<MovieResults> datalist, Context context){
        movieResultslist.clear();
        movieResultslist.addAll(datalist);
        context = mcontext;
    }
    @NonNull
    @Override
    public ProductVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list_item,parent,false);
        return new ProductVH(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ProductVH holder, int position) {
        holder.txtproductname.setText(movieResultslist.get(position).getTitle());
        holder.txtproductdescription.setText(movieResultslist.get(position).getOverview());
        holder.txtproductprice.setText(String.valueOf(movieResultslist.get(position).getReleaseDate()));
        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+movieResultslist.get(position).getPosterPath()).into(holder.productimg);
    }
    @Override
    public int getItemCount() {
        return movieResultslist.size();
    }
}
