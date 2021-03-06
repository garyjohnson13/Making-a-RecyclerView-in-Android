package com.codegarycode.recyclerviewexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    // create global variables
    private String[] name;
    private String[] subject;
    private String[] message;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textViewName;
        public TextView textViewSubject;
        public TextView textViewMessage;
        public ViewHolder(LinearLayout v) {
            super(v);
            textViewName    = (TextView) v.findViewById(R.id.name);
            textViewSubject = (TextView) v.findViewById(R.id.subject);
            textViewMessage = (TextView) v.findViewById(R.id.message);
        }
    }

    // this is the constructor. It takes in 3 String arrays
    public MyAdapter(String[] names, String[] subjects, String[] messages) {
        name = names;
        subject = subjects;
        message = messages;
    }

    // Create new view to inflate
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        ViewHolder vh = new ViewHolder((LinearLayout)v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textViewName.setText(name[position]);
        holder.textViewSubject.setText(subject[position]);
        holder.textViewMessage.setText(message[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return name.length;
    }
}
