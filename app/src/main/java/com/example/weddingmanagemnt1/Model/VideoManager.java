package com.example.weddingmanagemnt1.Model;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.weddingmanagemnt1.R;
import com.google.android.material.snackbar.Snackbar;


public class VideoManager extends RecyclerView.Adapter<VideoManager.RecyclerViewHolder> {

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView mName;
        ImageView mImage,mShare,mPlay,mDownload;

        RecyclerViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.title);
            mImage = (ImageView) itemView.findViewById(R.id.image);
            mShare = (ImageView) itemView.findViewById(R.id.share);
            mPlay = (ImageView) itemView.findViewById(R.id.play);
            mDownload = (ImageView) itemView.findViewById(R.id.download);
        }
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_category_video, viewGroup, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder viewHolder, int i) {
        // get the single element from the main array

        final VideoDatabase items = VideoDatabase.VIDEO[i];
        // Set the values
        viewHolder.mName.setText(items.get(VideoDatabase.Field.NAME));
        viewHolder.mImage.setImageResource(items.geti(VideoDatabase.Field.IMAGE));
        viewHolder.mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar snackbar = Snackbar.make(v, "Streaming", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });
        viewHolder.mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar snackbar = Snackbar.make(v, "Play", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });
        viewHolder.mShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar snackbar = Snackbar.make(v, "Sharing", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });
        viewHolder.mDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar snackbar = Snackbar.make(v, "Downloading", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });
    }


    @Override
    public int getItemCount() {

        return VideoDatabase.VIDEO.length;
    }


}