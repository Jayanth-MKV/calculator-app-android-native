package com.jay.mynotes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.Myviewholder> implements Filterable {

    Context ct;
    Activity at;
    List<Model> modelList;
    List<Model> notesList;
    private Filter example=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Model> filterList=new ArrayList<>();
            if(constraint==null || constraint.length()==0){
                filterList.addAll(notesList);
            }
            else{
                String matchStr=constraint.toString().toLowerCase().trim();
                for(Model item:notesList){
                    if(item.getTitle().toLowerCase().contains(matchStr)){
                        filterList.add(item);
                    }
                }
            }
            FilterResults filterResults=new FilterResults();
            filterResults.values=filterList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            modelList.clear();
            modelList.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };


    public Myadapter(Context ct, Activity at, List<Model> modelList) {
        this.ct = ct;
        this.at = at;
        this.modelList = modelList;
        this.notesList=new ArrayList<>(modelList);
    }


    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(ct).inflate(R.layout.recycler_view_layout,parent,false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(modelList.get(position).getTitle());
        holder.desc.setText(modelList.get(position).getDescription());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i;
                i = new Intent(ct,UpdateNoteActivity.class);
                i.putExtra("title",modelList.get(position).getTitle());
                i.putExtra("desc",modelList.get(position).getDescription());
                i.putExtra("Id",modelList.get(position).getUrl());
                at.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    @Override
    public Filter getFilter() {
        return example;
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        TextView title,desc;
        RelativeLayout relativeLayout;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.note);
            desc=itemView.findViewById(R.id.description);
            relativeLayout=itemView.findViewById(R.id.innerrelative);
        }
    }

    public List<Model> getList(){
        return modelList;
    }

    public void removeNote(int position){
        modelList.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreNote(Model item,int position){
        modelList.add(position,item);
        notifyItemInserted(position);
    }
}
