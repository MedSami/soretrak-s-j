package com.salwa.soretrak.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.salwa.soretrak.Model.DataModel;
import com.salwa.soretrak.R;

import java.util.List;

public class BureauAdapter extends RecyclerView.Adapter<BureauAdapter.ActorViewHolder> {

    List<DataModel> items;
    private Context ctx;
    //String btnValue,idUtilisateur;
    public BureauAdapter(List<DataModel> items, Context ctx) {
        this.items = items;
        this.ctx=ctx;


    }

    @Override
    public BureauAdapter.ActorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_rows_bureau,viewGroup,false);

        BureauAdapter.ActorViewHolder Actionview = new BureauAdapter.ActorViewHolder(v);
        return Actionview;
    }

    @Override
    public void onBindViewHolder(BureauAdapter.ActorViewHolder holder, int position) {
        DataModel dm = items.get(position);
        holder.txtBureau.setText("Bureau N° : "+dm.getNumero());
        holder.dm=dm;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  class ActorViewHolder extends RecyclerView.ViewHolder{
        TextView txtBureau;
        ImageView tvImage;
        DataModel dm;
        public ActorViewHolder(View itemView) {
            super(itemView);

            txtBureau =  itemView.findViewById(R.id.txtBureau);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   /* if(btnValue.equals("panne")){
                        Intent intent=new Intent(ctx, ReclamationPanne.class);
                        intent.putExtra("idEquippement", ""+dm.getId());
                        intent.putExtra("idUtilisateur", ""+idUtilisateur);
                        ctx.startActivity(intent);
                    }*/


                }
            });

        }
    }


}