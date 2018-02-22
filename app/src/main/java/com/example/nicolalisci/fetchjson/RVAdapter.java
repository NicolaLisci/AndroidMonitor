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

import static com.example.nicolalisci.fetchjson.SplashActivity.bisettimanaleArrayList;
import static com.example.nicolalisci.fetchjson.SplashActivity.statsArrayList;

/**
 * Created by nicolalisci on 16/02/18.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardsViewHolder>{
    private Context context;
    private ArrayList<Whitebox> whiteboxList;
    private int cvID;


    public class CardsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView wb_name,wb_temp,wb_umid,wb_ora;
        CardView cardView;



      public CardsViewHolder(final View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);
            wb_name = (TextView)itemView.findViewById(R.id.wb_name);
            wb_temp = (TextView) itemView.findViewById(R.id.wb_temp);
            wb_umid = (TextView) itemView.findViewById(R.id.wb_umid);
            wb_ora = (TextView) itemView.findViewById(R.id.wb_ora);


          cardView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

            cvID=getPosition();
            //Log.d("cvID", String.valueOf(cvID));

            Intent intent = new Intent(getActivity(), Dettaglio.class);

            Bundle bundle1 = new Bundle();
            bundle1.putSerializable("statsArrayList", (Serializable) statsArrayList);
            intent.putExtras(bundle1);


            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("bisettimanaleArrayList", (Serializable) bisettimanaleArrayList);
            intent.putExtras(bundle2);

            Bundle bundle3 = new Bundle();
            bundle3.putSerializable("whiteboxList", (Serializable) whiteboxList);
            intent.putExtras(bundle3);
            intent.putExtra("cvID",cvID);

            context.startActivity(intent);
        }
    }

    private Context getActivity() {
        return context;
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
        //holder.cardView.setOnClickListener((View.OnClickListener) this);



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


