package com.example.ariel.googlecards;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ariel on 3/12/2016.
 */
public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {


    ArrayList<String> array = new ArrayList<>();

    public CustomRecyclerAdapter(ArrayList<String> array){

        this.array = array;

    }

    @Override
    public CustomRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
    //Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.

    //inflating the row layout we created earlier
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);

    //making a ViewHolder object with the view we just inflated
        ViewHolder vh = new ViewHolder(v);


        return vh;
    }



    @Override
    public void onBindViewHolder(final CustomRecyclerAdapter.ViewHolder holder, final int position) {

        //Called by RecyclerView to display the data at the specified position.
        //This method should update the contents of the RecyclerView.ViewHolder.itemView to reflect the item at the given position.


        //we can access the textview we created in the ViewHolder class by typing holder.name_of_view
        holder.textView.setText(array.get(position));



    }

    @Override
    public int getItemCount(){



        return array.size();

    }

    public void addItem(String dataObj, int index) {
        array.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        array.remove(index);
        notifyItemRemoved(index);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        //reference to the row view
        public View view;

        //reference to a textView in the row layout to display the row number
        TextView textView;

        //constructing the viewHolder
        public ViewHolder(View v) {
            super(v);
            view = v;
            textView = (TextView) v.findViewById(R.id.textView);

        }
    }

}
