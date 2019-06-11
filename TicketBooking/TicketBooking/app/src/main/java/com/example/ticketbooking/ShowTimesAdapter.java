package com.example.ticketbooking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ShowTimesAdapter extends RecyclerView.Adapter<ShowTimesAdapter.ViewHolder> {

    RecyclerView temp;
    private Context context;
    private List<ShowTimes> showtimeList;
    int checkedPosition=-1;
    private Cinema cinema;
    int positionCinema;
    CinemaAdapter cinemaAdapter;
    CinemaAdapter.ViewHolder cinemaViewHolder;
    //CinemaAdapter

    public ShowTimesAdapter(Context context, Cinema cinema, int positionCinema, CinemaAdapter cinemaAdapter, CinemaAdapter.ViewHolder cinemaViewHolder) {
        this.context = context;
        this.showtimeList = cinema.getShowTimeList();
        this.cinema = cinema;
        this.positionCinema=positionCinema;
        this.cinemaAdapter = cinemaAdapter;
        this.cinemaViewHolder = cinemaViewHolder;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout Button;
        TextView timeText;
        public ViewHolder(View itemView)
        {
            super(itemView);
            timeText = itemView.findViewById(R.id.time_Text);
            Button = itemView.findViewById(R.id.button_time);
        }
        void bind(int position, int available) {
            if(available==-1)
                Button.setBackgroundResource(R.drawable.button_unavailable);
            else
            {
                if (checkedPosition == -1) {
                    Button.setBackgroundResource(R.drawable.button_available);
                } else {
                    if (checkedPosition == position) {
                        Button.setBackgroundResource(R.drawable.button_selected);
                    } else {
                        Button.setBackgroundResource(R.drawable.button_available);
                    }
                }}
        }}
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.button_time,viewGroup,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder,final int i) {
        ShowTimes temp = showtimeList.get(i);
        if (showtimeList.get(i).getTime().getHours() < 13)
            viewHolder.timeText.setText(String.format("%d:%d AM", showtimeList.get(i).getTime().getHours(), showtimeList.get(i).getTime().getMinutes()));
        else
            viewHolder.timeText.setText(String.format("%d:%d PM", showtimeList.get(i).getTime().getHours() - 12, showtimeList.get(i).getTime().getMinutes()));
        viewHolder.Button.setBackgroundResource(R.drawable.button_available);
        if(i==Load.getTimeChecked()&&positionCinema==Load.getCinemaChecked())
            viewHolder.Button.setBackgroundResource(R.drawable.button_selected);
        if (!temp.isAvailable())
            viewHolder.Button.setBackgroundResource(R.drawable.button_available);
        if (temp.isAvailable()) {
            viewHolder.Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int temp=Load.getCinemaChecked();
                    Load.setTemp(Load.getCinemaChecked(),Load.getTimeChecked());
                    if(Load.getCinemaChecked()==positionCinema)
                        notifyItemChanged(Load.getTimeChecked());

                    checkedPosition = viewHolder.getAdapterPosition();
                    viewHolder.Button.setBackgroundResource(R.drawable.button_selected);
                    Load.setCinemaChecked(positionCinema);
                    Load.setTimeChecked(checkedPosition);

                    if(temp!=positionCinema) {
                        for(int a=0;a<5;a++)
                        {
                            if(a!=Load.getCinemaChecked())
                            cinemaAdapter.notifyItemChanged(a);
                        }
                    }
                    Load.setCinemaName(cinema.getNameCinema());
                    if (showtimeList.get(i).getTime().getHours() < 13)
                        Load.setTime(String.format("%d:%d AM", showtimeList.get(i).getTime().getHours(), showtimeList.get(i).getTime().getMinutes()));
                    else Load.setTime(String.format("%d:%d PM", showtimeList.get(i).getTime().getHours() - 12, showtimeList.get(i).getTime().getMinutes()));
                }
            });
        }

    }
    @Override
    public int getItemCount() {
        return (showtimeList != null ? showtimeList.size() : 0);
    }
}

