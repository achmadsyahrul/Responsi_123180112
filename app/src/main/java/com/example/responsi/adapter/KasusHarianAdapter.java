package com.example.responsi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi.R;
import com.example.responsi.model.kasus_harian.ContentItem;

import java.util.ArrayList;

public class KasusHarianAdapter extends RecyclerView.Adapter<KasusHarianAdapter.ViewHolder> {

    private ArrayList<ContentItem> kasusHarianItems = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<ContentItem> items){
        kasusHarianItems.clear();
        kasusHarianItems.addAll(items);
        notifyDataSetChanged();
    }

    public KasusHarianAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kasus_harian,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KasusHarianAdapter.ViewHolder holder, int position) {
        final ContentItem item = kasusHarianItems.get(position);

        holder.tv_tanggal_kasus.setText(item.getTanggal());
        holder.tv_terkonfirmasi.setText(String.valueOf(item.getCONFIRMATION()));
        holder.tv_sembuh.setText(String.valueOf(item.getConfirmationSelesai()));
        holder.tv_meninggal.setText(String.valueOf(item.getConfirmationMeninggal()));
    }

    @Override
    public int getItemCount() {
        return kasusHarianItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tanggal_kasus,tv_terkonfirmasi,tv_sembuh,tv_meninggal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_tanggal_kasus = itemView.findViewById(R.id.tv_tanggal_kasus);
            tv_terkonfirmasi = itemView.findViewById(R.id.tv_val_terkonfirmasi);
            tv_sembuh = itemView.findViewById(R.id.tv_val_sembuh);
            tv_meninggal = itemView.findViewById(R.id.tv_val_meninggal);
        }
    }
}