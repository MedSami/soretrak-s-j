package com.salwa.soretrak.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.salwa.soretrak.MainActivity;
import com.salwa.soretrak.Model.DataModel;
import com.salwa.soretrak.R;
import com.salwa.soretrak.ReponsePanne;

import java.util.List;

public class PanneAdapter extends RecyclerView.Adapter<PanneAdapter.ActorViewHolder> {

    List<DataModel> items;
    private Context ctx;
    String btnValue;
    public PanneAdapter(List<DataModel> items, Context ctx,String btnValue) {
        this.items = items;
        this.ctx=ctx;
        this.btnValue=btnValue;
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
        holder.txtReference.setText(dm.getReference());
        if(dm.getReponseTechnicien().equals("Pas encore"))
        holder.tvImage1.setImageResource(R.drawable.notchecked);
        else
            holder.tvImage1.setImageResource(R.drawable.checked);

        holder.dm=dm;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  class ActorViewHolder extends RecyclerView.ViewHolder{
        TextView txtNomPrenom,txtReference;
        ImageView tvImage1;
        DataModel dm;
        public ActorViewHolder(View itemView) {
            super(itemView);

            txtNomPrenom =  itemView.findViewById(R.id.txtNomPrenom);
            txtReference =  itemView.findViewById(R.id.txtRef);
            tvImage1     =  itemView.findViewById(R.id.image1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(btnValue.equals("technicien") && dm.getReponseTechnicien().equals("Pas encore")){
                    Intent intent=new Intent(ctx, ReponsePanne.class);
                    intent.putExtra("id", ""+dm.getId());
                    intent.putExtra("description", ""+dm.getDescription());
                    ctx.startActivity(intent);
                    }
                    if (btnValue.equals("personnel")&& !dm.getReponseTechnicien().equals("Pas encore")) {
                        AlertDialog alertDialog = new AlertDialog.Builder(ctx).create();
                        alertDialog.setTitle("Reponse");
                        alertDialog.setMessage(""+dm.getReponseTechnicien());
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }


                }
            });

        }
    }


}
