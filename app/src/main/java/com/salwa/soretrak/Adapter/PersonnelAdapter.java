package com.salwa.soretrak.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.salwa.soretrak.Model.DataModel;
import com.salwa.soretrak.R;

import java.util.List;

public class PersonnelAdapter extends RecyclerView.Adapter<PersonnelAdapter.ActorViewHolder> {

    List<DataModel> items;
    private Context ctx;
    //String btnValue,idUtilisateur;
    public PersonnelAdapter(List<DataModel> items, Context ctx) {
        this.items = items;
        this.ctx=ctx;


    }

    @Override
    public PersonnelAdapter.ActorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_rows_personnel,viewGroup,false);

        PersonnelAdapter.ActorViewHolder Actionview = new PersonnelAdapter.ActorViewHolder(v);
        return Actionview;
    }

    @Override
    public void onBindViewHolder(PersonnelAdapter.ActorViewHolder holder, int position) {
        DataModel dm = items.get(position);
        holder.txtNomPrenom.setText(dm.getNom()+" "+dm.getPrenom());
        holder.dm=dm;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  class ActorViewHolder extends RecyclerView.ViewHolder{
        TextView txtNomPrenom;
        ImageView tvImage;
        DataModel dm;
        public ActorViewHolder(View itemView) {
            super(itemView);

            txtNomPrenom =  itemView.findViewById(R.id.txtNomPrenom);

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