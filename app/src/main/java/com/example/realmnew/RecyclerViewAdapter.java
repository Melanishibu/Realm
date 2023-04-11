package com.example.realmnew;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.realm.Realm;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder> {


    List<DataModel> dataModelList;
    Context context;
    RecyclerView.ViewHolder holder;
    Realm realm;

    public RecyclerViewAdapter(List<DataModel> dataModelList, Context context) {
        this.dataModelList = dataModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.viewHolder holder, int position) {
        DataModel model= dataModelList.get(position);


        holder.vh_cname.setText(model.getSname());
        holder.vh_track.setText(model.getStrk());
        holder.vh_duration.setText(model.getSdur());
        holder.vh_desc.setText(model.getSdesc());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,update.class);
                i.putExtra("course name",model.getSname());
                i.putExtra("course duration",model.getSdur());
                i.putExtra("course track",model.getStrk());
                i.putExtra("coursr description",model.getSdesc());
                i.putExtra("id",model.getId());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        private TextView vh_cname,vh_duration,vh_track,vh_desc;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            vh_cname = itemView.findViewById(R.id.vh_name);
            vh_duration = itemView.findViewById(R.id.vh_dur);
            vh_track = itemView.findViewById(R.id.vh_trk);
            vh_desc = itemView.findViewById(R.id.vh_desc);

        }
    }
}


