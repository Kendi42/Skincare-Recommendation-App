package com.example.cosmeticappuiux;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class GridViewAdapterSkincare extends BaseAdapter {
    Context context;
    String [] ProductNames;
    String [] ProductImageURLs;

    LayoutInflater inflater;

    public GridViewAdapterSkincare(Context context, String[] productNames, String[] productImageURLs) {
        this.context = context;
        ProductNames = productNames;
        ProductImageURLs = productImageURLs;
    }

    @Override
    public int getCount() {
        return ProductNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(inflater == null)
            inflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
        if(view == null)
            view = inflater.inflate(R.layout.grid_item, null);

        ImageView img_gridImage = view.findViewById(R.id.img_gridImage);
        TextView tv_gridText = view.findViewById(R.id.tv_gridText);

        Glide.with(this.context).load(ProductImageURLs[i]).into(img_gridImage);
        tv_gridText.setText(ProductNames[i]);
        return view;
    }

}
