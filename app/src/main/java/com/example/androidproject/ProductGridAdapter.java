package com.example.androidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductGridAdapter extends BaseAdapter {
    private ArrayList<Product> productList = new ArrayList<>();
    private Context context;
    public ProductGridAdapter(ArrayList<Product> datalist , Context mcontext){
        productList.clear();
        productList.addAll(datalist);
        context = mcontext;

    }
    @Override
    public int getCount() {
        return productList.size();
    }
    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater =LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.adapter_grid_item,null);
        ProductViewHolder productViewHolder = new ProductViewHolder(view);
        productViewHolder.txtproductname.setText(productList.get(position).getName());
        productViewHolder.txtproductdescription.setText(productList.get(position).getDescription());
        productViewHolder.txtproductprice.setText(String.valueOf(productList.get(position).getPrice()));
        productViewHolder.productimg.setImageDrawable(context.getDrawable(productList.get(position).getImage()));
        return view;
    }
    public static class ProductViewHolder{
        ImageView productimg;
        TextView txtproductname , txtproductdescription ,txtproductprice ;
        public ProductViewHolder(View view){
            productimg = view.findViewById(R.id.imagegridproduct);
            txtproductname = view.findViewById(R.id.txtgridproductname);
            txtproductdescription =view.findViewById(R.id.txtgridproductdiscription);
            txtproductprice = view.findViewById(R.id.txtgridproductprice);

        }
    }
}
