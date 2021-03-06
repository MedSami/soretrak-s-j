package com.salwa.soretrak.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.salwa.soretrak.Model.DataModel;
import com.salwa.soretrak.R;
import com.salwa.soretrak.ReclamationPanne;

import java.util.List;

public class EquippementPersonnelAdapter extends RecyclerView.Adapter<EquippementPersonnelAdapter.ActorViewHolder> {

    List<DataModel> items;
    private Context ctx;
    String btnValue,idUtilisateur;

    public EquippementPersonnelAdapter(List<DataModel> items, Context ctx,String btnValue,String idUtilisateur) {
        this.items = items;
        this.ctx=ctx;
        this.btnValue=btnValue;
        this.idUtilisateur=idUtilisateur;

    }

    @Override
    public EquippementPersonnelAdapter.ActorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_rows_equi_pers,viewGroup,false);

        EquippementPersonnelAdapter.ActorViewHolder Actionview = new EquippementPersonnelAdapter.ActorViewHolder(v);
        return Actionview;
    }

    @Override
    public void onBindViewHolder(EquippementPersonnelAdapter.ActorViewHolder holder, int position) {
        DataModel dm = items.get(position);
        holder.txtEquippement.setText("Reference : "+dm.getReference());
        holder.txtQuantite.setText("Qunatite : "+dm.getQuantite());
        holder.dm=dm;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  class ActorViewHolder extends RecyclerView.ViewHolder{
        TextView txtEquippement,txtQuantite;
        ImageView tvImage;
        DataModel dm;
        public ActorViewHolder(View itemView) {
            super(itemView);

            txtEquippement =  itemView.findViewById(R.id.txtEquippement);
            txtQuantite =  itemView.findViewById(R.id.txtQuantite);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(btnValue.equals("panne")){
                        Intent intent=new Intent(ctx, ReclamationPanne.class);
                        intent.putExtra("idEquippement", ""+dm.getId());
                        intent.putExtra("idUtilisateur", ""+idUtilisateur);
                        ctx.startActivity(intent);
                    }



                }
            });

        }
    }


}