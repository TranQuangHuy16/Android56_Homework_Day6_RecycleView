package com.example.android56_homework_day6_recyclerview.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android56_homework_day6_recyclerview.R;
import com.example.android56_homework_day6_recyclerview.interfaces.ProductClickListener;
import com.example.android56_homework_day6_recyclerview.models.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private static final String TAG = "ProductAdapter";
    private ArrayList<Product> mProductList;
    private Context mContext;
    private ProductClickListener mProductClickListener;
    public ProductAdapter(ArrayList<Product> productList) {
        this.mProductList = productList;
    }

    public void setmProductClickListener(ProductClickListener mProductClickListener) {
        this.mProductClickListener = mProductClickListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        Product product = mProductList.get(position);
        holder.txtTitle.setText(product.getTitle());
        holder.txtDescription.setText(product.getDescription());
        holder.txtPrice.setText("₹" + product.getPrice());
        holder.ratingBar.setRating(product.getRating());
        holder.txtReviews.setText("(" + product.getReviews() + ")");
        Glide.with(mContext).load(product.getImageResId()).into(holder.imgProduct);
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgProduct;
        TextView txtTitle, txtDescription, txtPrice, txtReviews;
        RatingBar ratingBar;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtReviews = itemView.findViewById(R.id.txtReviews);
            ratingBar = itemView.findViewById(R.id.ratingBar);

            imgProduct.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.imgProduct) {
                int position = getAdapterPosition();
                if (mProductClickListener != null) {
                    mProductClickListener.onItemClickListener(position, mProductList.get(getAdapterPosition()));
                }
            }
        }
    }
}
