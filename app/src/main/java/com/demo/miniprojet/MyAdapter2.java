package com.demo.miniprojet;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {

//    Company List Declaration
    ArrayList<Entreprise> companies = new ArrayList<>() ;

    private OnNoteListener onNoteListener;
    int images[];
    Context context;
    public MyAdapter2(Context ct, ArrayList<Entreprise> Comp,  int img[],OnNoteListener onNoteL) {
        context = ct;
        companies = Comp;
        images = img;
        onNoteListener = onNoteL;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate (R.layout.my_rowentreprise, parent, false);
        return new MyViewHolder (view,onNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Entreprise companie = companies.get(position);
        holder.myText1.setText (companie.getNom());
        holder.myImage.setImageResource (images [position]);

    }

    @Override
    public int getItemCount() {
        return companies.size();
    }

    public class MyViewHolder  extends  RecyclerView.ViewHolder implements View.OnClickListener{
        TextView myText1;
        ImageView myImage;
        OnNoteListener onNoteListener;

        public MyViewHolder(@NonNull View itemView,OnNoteListener onNoteL) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.myText1);
            myImage = itemView.findViewById(R.id.myImageView);
            onNoteListener = onNoteL;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }
    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}