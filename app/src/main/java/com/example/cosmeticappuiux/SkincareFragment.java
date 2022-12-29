package com.example.cosmeticappuiux;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.fragment.app.Fragment;


public class SkincareFragment extends Fragment {
    GridView gridView;

    public SkincareFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_skincare, container, false);

        String[] productNames = {"SKIN PERFECTING\n" +
                "2% BHA Liquid Exfoliant", "SKIN BALANCING\n" +
                "Oil-Reducing Cleanser","SKIN BALANCING\n" +
                "Pore-Reducing Toner","SKIN BALANCING\n" +
                "Invisible Finish Moisture Gel",
                "RESIST\n" +
                        "Super-Light Wrinkle Defense SPF 30","Pore Clarifying Charcoal Gel Mask","\n" +
                "SHINE STOPPER Instant Matte Finish with MICROSPONGE Technology","RESIST\n" +
                "Ultra-Light Super Antioxidant Concentrate Serum"};
        String[] imageURLs = {"https://www.paulaschoice.com/dw/image/v2/BBNX_PRD/on/demandware.static/-/Sites-pc-catalog/default/dwf0fd0988/images/products/skin-perfecting-2-percent-bha-liquid-2010-L.png?sw=360&sfrm=png",
                "https://www.paulaschoice.com/dw/image/v2/BBNX_PRD/on/demandware.static/-/Sites-pc-catalog/en_US/dwa630e663/images/products/skin-balancing-oil-reducing-cleanser-1150-L.png?sw=360&sfrm=png",
                "https://www.paulaschoice.com/dw/image/v2/BBNX_PRD/on/demandware.static/-/Sites-pc-catalog/en_US/dwc5c0c4f7/images/products/skin-balancing-pore-reducing-toner-1350-L.png?sw=360&sfrm=png",
                "https://www.paulaschoice.com/dw/image/v2/BBNX_PRD/on/demandware.static/-/Sites-pc-catalog/en_US/dw7b86584b/images/products/skin-balancing-invisible-finish-moisture-gel-3400-L.png?sw=360&sfrm=png",
                "https://www.paulaschoice.com/dw/image/v2/BBNX_PRD/on/demandware.static/-/Sites-pc-catalog/en_US/dw2d421a83/images/products/resist-super-light-daily-wrinkle-defense-spf-30-7760-L.png?sw=360&sfrm=png",
                "https://www.paulaschoice.com/dw/image/v2/BBNX_PRD/on/demandware.static/-/Sites-pc-catalog/default/dwafd8289c/images/products/pore-clarifying-charcoal-gel-mask-2650-L.png?sw=360&sfrm=png",
                "https://www.paulaschoice.com/dw/image/v2/BBNX_PRD/on/demandware.static/-/Sites-pc-catalog/en_US/dwa921a466/images/products/shine-stopper-instant-matte-finish-3600-L.png?sw=360&sfrm=png",
                "https://www.paulaschoice.com/dw/image/v2/BBNX_PRD/on/demandware.static/-/Sites-pc-catalog/default/dwd38bd965/images/products/resist-ultra-light-super-antioxidant-concentrate-serum-7740-L.png?sw=360&sfrm=png"};

        gridView= (GridView)view.findViewById(R.id.gridviewSkincare);
        GridViewAdapterSkincare gridAdapter = new GridViewAdapterSkincare(getContext(), productNames,imageURLs);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), MoreInfo.class);
                intent.putExtra("choice", imageURLs[i]);
                intent.putExtra("word", productNames[i]);
                startActivity(intent);
            }
        });
        return view;

    }
}