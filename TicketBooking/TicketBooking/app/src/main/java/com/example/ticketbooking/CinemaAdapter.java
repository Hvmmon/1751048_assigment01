package com.example.ticketbooking;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CinemaAdapter extends RecyclerView.Adapter<CinemaAdapter.ViewHolder> {

    private Context context;
    private List<Cinema> cinemaList;

    public CinemaAdapter(List<Cinema> cinemaList, Context context) {
        this.context = context;
        this.cinemaList = cinemaList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.sub_layout, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.cinemaNameText.setText(cinemaList.get(i).getNameCinema());
        List<ShowTimes> showtimesList = cinemaList.get(i).getShowTimeList();

        ShowTimesAdapter showtimesAdapter = null;
        showtimesAdapter = new ShowTimesAdapter(context,cinemaList.get(i),i,this,viewHolder);

        viewHolder.recyclerViewTime.setHasFixedSize(true);
        viewHolder.recyclerViewTime.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        viewHolder.recyclerViewTime.setAdapter(showtimesAdapter);
        viewHolder.recyclerViewTime.setNestedScrollingEnabled(false);
    }

    @Override
    public int getItemCount() {
        return ( cinemaList.size() );
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cinemaNameText;
        RecyclerView recyclerViewTime;

        public ViewHolder(View itemView) {
            super(itemView);
            cinemaNameText = itemView.findViewById(R.id.Cinema_name);
            recyclerViewTime = itemView.findViewById(R.id.list_item);
        }
    }

}
