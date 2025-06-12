package com.example.collageapp.ebook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collageapp.R;

import java.util.List;

public class ebookadapter extends RecyclerView.Adapter<ebookadapter.ebookholder> {

    private Context context;
    private List<EbookData> list;

    public ebookadapter(Context context, List<EbookData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ebookholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ebook_item_layout,parent,false);
        return new ebookholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ebookholder holder, @SuppressLint("RecyclerView") int position) {

        holder.ebookname.setText(list.get(position).getPdftitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,PdfViewerActivity.class);
                intent.putExtra("pdfurl",list.get(position).getPdfurl());
                context.startActivity(intent);
            }
        });
        holder.ebookdownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getPdfurl()));
                context.startActivity(intent);
             }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ebookholder extends RecyclerView.ViewHolder {

        private TextView ebookname;
        private ImageView ebookdownload;

        public ebookholder(@NonNull View itemView) {
            super(itemView);
            
            ebookname = itemView.findViewById(R.id.ebookname);
            ebookdownload = itemView.findViewById(R.id.ebookdownload);
        }
    }
}
