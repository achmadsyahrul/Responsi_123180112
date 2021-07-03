package com.example.responsi.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi.R;
import com.example.responsi.model.fas_kes.DataItem;
import com.example.responsi.model.kasus_harian.ContentItem;

import java.util.ArrayList;

public class FasKesAdapter extends RecyclerView.Adapter<FasKesAdapter.ViewHolder> {

    private ArrayList<DataItem> fasKesItems = new ArrayList<>();
    private Context context;

    public FasKesAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<DataItem> items){
        fasKesItems.clear();
        fasKesItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FasKesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fas_kes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FasKesAdapter.ViewHolder holder, int position) {
        final DataItem item = fasKesItems.get(position);

        holder.tv_rs.setText(item.getNama());
        holder.tv_alamat_rs.setText(item.getAlamat());
        holder.btn_maps.setOnClickListener(v -> {
            Uri loc = Uri.parse("geo:"
                    +String.valueOf(item.getLatitude())
                    +","+String.valueOf(item.getLongitude())
                    +"?q="+String.valueOf(item.getNama())
            );
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, loc);
            mapIntent.setPackage("com.google.android.apps.maps");
            context.startActivity(mapIntent);
        });
    }

    @Override
    public int getItemCount() {
        return fasKesItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_rs, tv_alamat_rs;
        Button btn_maps;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_rs = itemView.findViewById(R.id.tv_val_rs);
            tv_alamat_rs = itemView.findViewById(R.id.tv_val_alamat);
            btn_maps = itemView.findViewById(R.id.btn_maps);
        }
    }
}