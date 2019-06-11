package com.example.ticketbooking;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.ViewHolder> {

    private List<Date> mShowDates;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private int checkedPosition = -1;

    public DateAdapter(List _date, Context mContext) {
        this.mShowDates = _date;
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private View itemview;
        public TextView dayWeek;
        public TextView dayMonth;
        public LinearLayout Button;

        public ViewHolder(View itemView) {
            super(itemView);
            itemview = itemView;
            Button = itemView.findViewById(R.id.button_showdate);
            dayWeek = itemView.findViewById(R.id.dWeek);
            dayMonth = itemView.findViewById(R.id.dMonth);
        }
        void bind(int position) {
            if (checkedPosition == -1) {
                Button.setBackgroundResource(R.drawable.button_available);
            } else {
                if (checkedPosition == position) {
                    Button.setBackgroundResource(R.drawable.button_selected);
                } else {
                    Button.setBackgroundResource(R.drawable.button_available);
                }
            }
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View DateView = mLayoutInflater.from(parent.getContext()).inflate(R.layout.button_date, parent,false);
        return new ViewHolder(DateView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Date date = mShowDates.get(position);
        //holder.setIsRecyclable(false);
        final String weekDay;
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEE", Locale.US);
        weekDay = dayFormat.format(date.getTime());
        holder.dayWeek.setText(weekDay);
        holder.dayMonth.setText(String.valueOf(date.getDate()));
        holder.bind(position);
        if(Load.getDateChecked()==position)
            holder.Button.setBackgroundResource(R.drawable.button_selected);
        //active when click
        holder.Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.Button.setBackgroundResource(R.drawable.button_selected);
                notifyItemChanged(Load.getDateChecked());
                checkedPosition = holder.getAdapterPosition();
                Load.setDateChecked(checkedPosition);
                Load.setDayMonth(String.valueOf(date.getDate()));
                Load.setDayWeek(weekDay);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mShowDates.size();
    }

}
