package com.example.primejunk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterItem extends ArrayAdapter<PojoItem> {
    Context context;
    ArrayList<PojoItem> itemss  ;

    LayoutInflater inflater;


    public AdapterItem(Context context,int resource,ArrayList<PojoItem> items) {
        super(context,resource,items);
        this.context = context;
        itemss = items;
        inflater= LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemss.size();
    }



    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {





        convertView=inflater.inflate(R.layout.grid_layout,null);

        ImageView iv_images;
        TextView tv_no_of_coins,tv_rate,tv_quantity;

        iv_images=(ImageView) convertView.findViewById(R.id.iv_images);
        iv_images.setImageResource(itemss.get(position).getPic());

        tv_no_of_coins=(TextView) convertView.findViewById(R.id.tv_no_of_coins);
        tv_no_of_coins.setText(itemss.get(position).getNo_of_coins());

        tv_quantity=(TextView) convertView.findViewById(R.id.tv_quantity);
        tv_quantity.setText(itemss.get(position).getQuantity());

        tv_rate=(TextView) convertView.findViewById(R.id.tv_rate);
        tv_rate.setText(itemss.get(position).getRate());




        return convertView;
    }
}
