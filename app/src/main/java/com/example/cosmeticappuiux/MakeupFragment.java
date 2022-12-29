package com.example.cosmeticappuiux;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

public class MakeupFragment extends Fragment {
    private GridView gridView;


    public MakeupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_makeup, container, false);

        String[] productNames = {"IT Cosmetics Your Skin But Better Oil-Free Primer\n",
                "NYX Professional Makeup Can’t Stop Won’t Stop Foundation\n" ,
                "Dermablend Cover Care Full Coverage Concealer\n",
                "Lancôme Blush Subtil\n",
                "Uoma Beauty Black Magic Carnival Bronzing Highlighter"
                };
        String[] imageURLs = {"https://www.makeup.com/-/media/project/loreal/brand-sites/mdc/americas/us/articles/2020/09_september/10-best-makeup-for-oily-skin/best-makeup-for-oily-skin-body07-mudc-091020.jpg?w=300&h=300&hash=B732AA0286986F79B282CAF0F3A9CE7E",
        "https://www.makeup.com/-/media/project/loreal/brand-sites/mdc/americas/us/articles/2020/09_september/10-best-makeup-for-oily-skin/best-makeup-for-oily-skin-body03-mudc-091020.jpg?w=300&h=300&hash=4CB32FBFECC7D60C438E1A45FFDBE6DA",
        "https://www.makeup.com/-/media/project/loreal/brand-sites/mdc/americas/us/articles/2020/09_september/10-best-makeup-for-oily-skin/best-makeup-for-oily-skin-body04-mudc-091020.jpg?w=300&h=300&hash=E9B2976C1FE1DE1A7D94D35AA9C72D3D",
        "https://www.makeup.com/-/media/project/loreal/brand-sites/mdc/americas/us/articles/2020/09_september/10-best-makeup-for-oily-skin/best-makeup-for-oily-skin-body02-mudc-091020.jpg?w=300&h=300&hash=1E71F6DB39268BAA6DF25B7F77BF1889",
        "https://www.makeup.com/-/media/project/loreal/brand-sites/mdc/americas/us/articles/2020/09_september/10-best-makeup-for-oily-skin/est-makeup-for-oily-skin-body08-mudc-091020.jpg?w=300&h=300&hash=F938DEE51293CC0D60FF6779C803FBA7"};

        gridView = (GridView)view.findViewById(R.id.gridviewMakeup);
        GridViewAdapterMakeup gridAdapter = new GridViewAdapterMakeup(getContext(), productNames,imageURLs);
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

        // Inflate the layout for this fragment
        return view;

    }
}