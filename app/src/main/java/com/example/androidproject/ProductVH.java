package com.example.androidproject;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class ProductVH  extends RecyclerView.ViewHolder {
    ImageView productimg;
    TextView txtproductname , txtproductdescription ,txtproductprice ;
    public ProductVH(@NonNull View view) {
        super(view);
        productimg = view.findViewById(R.id.imageproduct);
        txtproductname = view.findViewById(R.id.txtproductname);
        txtproductdescription =view.findViewById(R.id.txtproductdiscription);
        txtproductprice = view.findViewById(R.id.txtproductprice);
    }
}
