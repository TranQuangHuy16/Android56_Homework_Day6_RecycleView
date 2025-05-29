package com.example.android56_homework_day6_recyclerview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.android56_homework_day6_recyclerview.models.Product;

public class ProductDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);

        initView();
    }

    private void initView() {
        Product product = (Product) getIntent().getSerializableExtra("product_detail");

        ImageView imgProduct = findViewById(R.id.imgProduct);
        TextView txtTitle = findViewById(R.id.txtTitle);
        TextView txtDescription = findViewById(R.id.txtDescription);
        TextView txtPrice = findViewById(R.id.txtPrice);
        TextView txtReviews = findViewById(R.id.txtReviews);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        if (product != null) {
            txtTitle.setText(product.getTitle());
            txtDescription.setText(product.getDescription());
            txtPrice.setText("₹" + product.getPrice());
            ratingBar.setRating(product.getRating());
            txtReviews.setText("(" + product.getReviews() + ")");
            Glide.with(this)
                    .load(product.getImageResId())  // URL hoặc đường dẫn ảnh
                    .into(imgProduct);
        }
    }
}