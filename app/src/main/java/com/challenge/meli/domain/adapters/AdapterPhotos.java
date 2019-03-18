package com.challenge.meli.domain.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.challenge.meli.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterPhotos extends RecyclerView.Adapter<AdapterPhotos.ViewHolder> {

    private List<String> photos = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_photo, viewGroup, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(photos.get(i));
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        String urlPhoto;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.photo);
        }

        void bind(String urlPhoto) {
            this.urlPhoto = urlPhoto;
            Picasso.get().load(this.urlPhoto).into(image);
        }
    }
}
