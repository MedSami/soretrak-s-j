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

import java.util.List;

public class PanneAdapter extends RecyclerView.Adapter<PanneAdapter.ActorViewHolder> {

    List<DataModel> items;
    private Context ctx;
    //String btnValue,idUtilisateur;
    public PanneAdapter(List<DataModel> items, Context ctx) {
        this.items = items;
        this.ctx=ctx;


    }

    @Override
    public PanneAdapter.ActorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_rows_panne,viewGroup,false);

        PanneAdapter.ActorViewHolder Actionview = new PanneAdapter.ActorViewHolder(v);
        return Actionview;
    }

    @Override
    public void onBindViewHolder(PanneAdapter.ActorViewHolder holder, int position) {
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
                    Toast.makeText(ctx, ""+dm.getId(), Toast.LENGTH_SHORT).show();
                  /*  Intent intent=new Intent(ctx, ConsulterEquippement.class);
                    intent.putExtra("idUtilisateur", ""+dm.getId());
                    intent.putExtra("btnValue", "bb");
                    ctx.startActivity(intent);
*/


                }
            });

        }
    }


}
