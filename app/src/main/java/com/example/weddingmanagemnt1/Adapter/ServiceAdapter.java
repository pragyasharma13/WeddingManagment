package com.example.weddingmanagemnt1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weddingmanagemnt1.Model.ServiceModel;
import com.example.weddingmanagemnt1.R;


import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.RecentlyViewedViewHolder>  {
    Context context;
    List<ServiceModel> recentlyViewedList;

    public ServiceAdapter(Context context, List<ServiceModel> recentlyViewedList) {
        this.context = context;
        this.recentlyViewedList = recentlyViewedList;
    }

    @NonNull
    @Override
    public RecentlyViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_for_category_home, parent, false);

        return new RecentlyViewedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyViewedViewHolder holder, final int position) {

        holder.venue.setText(recentlyViewedList.get(position).getTvName());
      //  holder.image.setText(recentlyViewedList.get(position).getImageUrl());
        holder.image.setImageResource(recentlyViewedList.get(position).getImageSrc());


       // holder.bg.setBackgroundResource(recentlyViewedList.get(position).getImageSrc());

        /** holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        Intent i=new Intent(context, ProductDetails.class);
        i.putExtra("name", recentlyViewedList.get(position).getName());
        i.putExtra("image", recentlyViewedList.get(position).getBigimageurl());
        i.putExtra("price",recentlyViewedList.get(position).getPrice());
        i.putExtra("desc",recentlyViewedList.get(position).getDescription());
        i.putExtra("qty",recentlyViewedList.get(position).getQuantity());
        i.putExtra("unit",recentlyViewedList.get(position).getUnit());

        context.startActivity(i);

        }
        });**/

    }

    @Override
    public int getItemCount() {
        return recentlyViewedList.size();
    }



    public   class RecentlyViewedViewHolder extends RecyclerView.ViewHolder{

        TextView venue;
        ImageView image;
        LinearLayout bg;

        public RecentlyViewedViewHolder(@NonNull View itemView) {
            super(itemView);

            venue = itemView.findViewById(R.id.textvenue);
            image = itemView.findViewById(R.id.image1);

            bg = itemView.findViewById(R.id.background);



        }
    }
}