package com.example.nicolalisci.fetchjson;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.nicolalisci.fetchjson.Cards;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolalisci on 16/02/18.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardsViewHolder>{
    private Context context;
   private ArrayList<Whitebox> whiteboxList;

    public static class CardsViewHolder extends RecyclerView.ViewHolder {

        static TextView wb_name,wb_temp,wb_umid,wb_ora;



      public CardsViewHolder(final View itemView) {
            super(itemView);


            wb_name = (TextView)itemView.findViewById(R.id.wb_name);
            wb_temp = (TextView) itemView.findViewById(R.id.wb_temp);
            wb_umid = (TextView) itemView.findViewById(R.id.wb_umid);
            wb_ora = (TextView) itemView.findViewById(R.id.wb_ora);


        }


    }




    public RVAdapter(Context context, ArrayList<Whitebox> whiteboxList)
    {
        this.context = context;
        this.whiteboxList = whiteboxList;
    }


   @Override
    public CardsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

       View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cards, viewGroup, false);
       return new CardsViewHolder(v);

   }



    @Override
    public void onBindViewHolder(CardsViewHolder holder, int i) {

        Whitebox whitebox = this.whiteboxList.get(i);

        holder.wb_name.setText(whitebox.getWb_nome());
        holder.wb_temp.setText(whitebox.getWb_temp() + " °C");
        holder.wb_umid.setText(whitebox.getWb_umid() + " %");
        holder.wb_ora.setText("Ultima lettura: " + whitebox.getWb_ora());


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


