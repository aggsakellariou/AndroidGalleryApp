package com.galleryapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        dbHelper = new DatabaseHelper(this);

        String category = getIntent().getStringExtra("category");
        List<Painting> paintingList;

        if ("All Paintings".equals(category)) {
            paintingList = dbHelper.getAllPaintings();
        } else {
            paintingList = dbHelper.getPaintingsByCategory(category);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        GalleryAdapter galleryAdapter = new GalleryAdapter(paintingList, this);
        recyclerView.setAdapter(galleryAdapter);
    }

    public void close(View view) {
        finish();
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }
}