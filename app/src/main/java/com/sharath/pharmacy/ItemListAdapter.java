package com.sharath.pharmacy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sharath.pharmacy.models.Item;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemHolder> {

    private List<Item> items;
    private Context context;

    public ItemListAdapter(Context context, List<Item> items) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        private ImageView imgItemPic;
        private TextView txtItemName, txtItemPrice, txtPack;
        private Spinner spinnerQty;

        ItemHolder(@NonNull View itemView) {
            super(itemView);
        }

        public TextView getTxtItemName() {
            if (txtItemName == null) {
                txtItemName = itemView.findViewById(R.id.txt_item_name);
            }
            return txtItemName;
        }

        public TextView getTxtItemPrice() {
            if (txtItemPrice == null) {
                txtItemPrice = itemView.findViewById(R.id.txt_price);
            }
            return txtItemPrice;
        }

        public TextView getTxtPack() {
            if (txtPack == null) {
                txtPack = itemView.findViewById(R.id.txt_pac);
            }
            return txtPack;
        }

        public ImageView getImgItemPic() {
            if (imgItemPic == null) {
                imgItemPic = itemView.findViewById(R.id.img_item_pic);
            }
            return imgItemPic;
        }
    }
}
