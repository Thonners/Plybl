package com.thonners.plybl;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Class to manage the recyclerview in the HomeActivity
 *
 * @author M Thomas
 * @since 18/05/17
 */

public class RecyclerViewAdapterDefault extends RecyclerView.Adapter<CardViewHolder> {

    private Context context ;
    private List<CardEntry> cardEntryList ;

    public RecyclerViewAdapterDefault(Context context, List<CardEntry> cardEntryList) {
        this.context = context ;
        this.cardEntryList = cardEntryList ;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate and initialise the view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_default_layout, parent, false) ;
        CardViewHolder holder = new CardViewHolder(v, (CardViewHolder.CardViewHolderListener) context) ;
        return holder;
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.setMainText(cardEntryList.get(position).getMainText());
        holder.setImage(cardEntryList.get(position).getImageResource());
    }

    @Override
    public int getItemCount() {
        return cardEntryList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, CardEntry cardEntry) {
        cardEntryList.add(position, cardEntry);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(CardEntry cardEntry) {
        int position = cardEntryList.indexOf(cardEntry);
        cardEntryList.remove(position);
        notifyItemRemoved(position);
    }

}
