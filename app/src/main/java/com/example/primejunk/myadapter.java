package com.example.primejunk;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import org.jetbrains.annotations.NotNull;

import java.util.List;
public class myadapter  extends RecyclerView.Adapter<myadapter.myviewholder>
{
    List<Item> items;
    mListener activity;

    public interface mListener{
        void removeButtonVisibility();
    }

    public myadapter(Context context,List<Item> items) {
        this.items = items;
        this.activity= (mListener) context;

    }

    @NonNull
    @NotNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull myadapter.myviewholder holder, @SuppressLint("RecyclerView") int position) {
        //holder.recid.setText(String.valueOf(items.get(position).getPid()));
        holder.tv_item_type.setText(items.get(position).getTitle());

        holder.tv_item_qty.setText(String.valueOf(items.get(position).getQuantity()));
        holder.tv_cart_rate.setText(items.get(position).getRate());
        holder.tv_cart_no_of_coins.setText(String.valueOf(items.get(position).getNo_of_coins()));

        holder.iv_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db = Room.databaseBuilder(holder.itemView.getContext(),
                        AppDatabase.class, "cart_db").allowMainThreadQueries().build();
                ItemDao productDao = db.ItemDao();

                productDao.deleteById(items.get(position).getPid());
                items.remove(position);
                notifyItemRemoved(position);
                if(items.size()==0)
                {
                    activity.removeButtonVisibility();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class myviewholder extends RecyclerView.ViewHolder
    {
        TextView recid,tv_item_qty,tv_item_type,tv_cart_no_of_coins,tv_cart_rate;
        ImageView iv_remove;
        public myviewholder(@NonNull @NotNull View itemView) {
            super(itemView);

            //recid=itemView.findViewById(R.id.recid);
            tv_item_type=itemView.findViewById(R.id.tv_item_type);

            tv_item_qty=itemView.findViewById(R.id.tv_item_qty);
            iv_remove=itemView.findViewById(R.id.iv_remove);

            tv_cart_no_of_coins=itemView.findViewById(R.id.tv_cart_no_of_coins);
            tv_cart_rate=itemView.findViewById(R.id.tv_cart_rate);
        }
    }



}

