package com.example.marmm.demoweek3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import static com.example.marmm.demoweek3.MainActivity.INTENT_DETAIL_REMINDER_TEXT;
import static com.example.marmm.demoweek3.MainActivity.INTENT_DETAIL_ROW_NUMBER;
import static com.example.marmm.demoweek3.MainActivity.REQUESTCODE;


/**
 * Created by marmm on 3/28/17.
 */

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ViewHolder>  {

    private List<Reminder> mReminders;
    private Context mContext;

    final private ReminderClickListener mReminderClickListener;


    public interface ReminderClickListener{

        void ReminderonClick (Reminder reminder, int position);
        void ReminderonLongClick (int position);
    }


    public ReminderAdapter(ReminderClickListener reminderClickListener, List<Reminder> mReminders) {
        this.mReminders = mReminders;
        this.mReminderClickListener = reminderClickListener;
    }

    @Override
    public ReminderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, null);

        // Return a new holder instance
        ReminderAdapter.ViewHolder viewHolder = new ReminderAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ReminderAdapter.ViewHolder holder, final int position) {

        final Reminder reminder =  mReminders.get(position);

        holder.textView.setText(reminder.getmReminderText());


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mReminderClickListener.ReminderonClick(reminder, position);
            }
        });

        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mReminderClickListener.ReminderonLongClick(position);
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return mReminders.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public View mView;

        //Constructor
        public ViewHolder(View v) {


            super(v);
            textView = (TextView) v.findViewById(android.R.id.text1);
            mView = v;
        }


    }


}



