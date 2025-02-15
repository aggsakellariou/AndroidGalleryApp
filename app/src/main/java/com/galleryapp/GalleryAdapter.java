package com.galleryapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private final List<Painting> paintingList;
    private final Context context;

    public GalleryAdapter(List<Painting> paintingList, Context context) {
        this.paintingList = paintingList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Painting painting = paintingList.get(position);

        holder.imageView.setImageResource(painting.getImageResource());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            Gson gson = new Gson();
            String paintingJson = gson.toJson(painting);
            intent.putExtra("painting", paintingJson);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return paintingList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView paintingArtistYear;
        TextView descriptionTextView;
        Button speakButton;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.painting_image);
            titleTextView = view.findViewById(R.id.painting_title);
            paintingArtistYear = view.findViewById(R.id.painting_artist_year);
            descriptionTextView = view.findViewById(R.id.painting_description);
            speakButton = view.findViewById(R.id.speak_button);
        }
    }
}
