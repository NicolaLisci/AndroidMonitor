package com.example.nicolalisci.fetchjson;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.io.Serializable;
import java.util.ArrayList;

import Models.Whitebox;

import static com.example.nicolalisci.fetchjson.SplashActivity.rilevazioni;
import static com.example.nicolalisci.fetchjson.SplashActivity.statsArrayList;

/**
 * Created by nicolalisci on 16/02/18.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardsViewHolder>{
    private Context context;
    private ArrayList<Whitebox> whiteboxList;
    private int cvID;
    private DetailsAdapterListener listener;

    public interface DetailsAdapterListener {
        public void OnCardClicked  (int position);



    }


    public class CardsViewHolder extends RecyclerView.ViewHolder{

        TextView wb_name,wb_temp,wb_umid,wb_ora;
        CardView cardView;




      public CardsViewHolder(final View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);
            wb_name = (TextView)itemView.findViewById(R.id.wb_name);
            wb_temp = (TextView) itemView.findViewById(R.id.wb_temp);
            wb_umid = (TextView) itemView.findViewById(R.id.wb_umid);
            wb_ora = (TextView) itemView.findViewById(R.id.wb_ora);


          //cardView.setOnClickListener(listener);


        }


    }

    private Context getActivity() {
        return context;
    }


    public RVAdapter(Context context, ArrayList<Whitebox> whiteboxList, DetailsAdapterListener listener )
    {
        this.context = context;
        this.whiteboxList = whiteboxList;
        this.listener = listener;

    }


   @Override
    public CardsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

       View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cards, viewGroup, false);
       return new CardsViewHolder(v);

   }



    @Override
    public void onBindViewHolder(CardsViewHolder holder, final int position) {



        final Whitebox whitebox = this.whiteboxList.get(position);

        holder.wb_name.setText(whitebox.getWb_nome());
        holder.wb_temp.setText(whitebox.getWb_temp() + " °C");
        holder.wb_umid.setText(whitebox.getWb_umid() + " %");
        holder.wb_ora.setText("Ultima lettura: " + whitebox.getWb_ora());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.OnCardClicked(position);
            }
        });



        }

    @Override
    public int getItemCount() {

        return(whiteboxList != null ? whiteboxList.size() : 0 );
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}


