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
        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        int price = getIntent().getIntExtra("price", 0);
        float rating = getIntent().getFloatExtra("rating", 0);
        int reviews = getIntent().getIntExtra("reviews", 0);
        String imageResId = getIntent().getStringExtra("imageResId");

        ImageView imgProduct = findViewById(R.id.imgProduct);
        TextView txtTitle = findViewById(R.id.txtTitle);
        TextView txtDescription = findViewById(R.id.txtDescription);
        TextView txtPrice = findViewById(R.id.txtPrice);
        TextView txtReviews = findViewById(R.id.txtReviews);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

            txtTitle.setText(title);
            txtDescription.setText(description);
            txtPrice.setText(price);
            ratingBar.setRating(rating);
            txtReviews.setText(reviews);
            Glide.with(this)
                    .load(imageResId)  // URL hoặc đường dẫn ảnh
                    .into(imgProduct);

    }
}