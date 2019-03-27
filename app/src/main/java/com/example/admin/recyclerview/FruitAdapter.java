package com.example.admin.recyclerview;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mFruitList;

    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fruit_item, viewGroup, false);
        final ViewHolder holder = new ViewHolder(view);
        //recyclerView的点击事件
        holder.fruitName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int positon = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(positon);
                Toast.makeText(v.getContext(), "you clicked view " + fruit.getName(), Toast.LENGTH_LONG).show();
            }
        });

        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int postion = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(postion);
                Toast.makeText(v.getContext(), "you clicked image " + fruit.getName(), Toast.LENGTH_LONG).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(@NonNull View view) {
            super(view);
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }



}
