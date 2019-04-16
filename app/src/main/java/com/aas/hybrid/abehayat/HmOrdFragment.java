package com.aas.hybrid.abehayat;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.ListFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HmOrdFragment extends Fragment {
    ListView lst;
    ArrayList<String> options;
    ArrayAdapter<String> opt;
    public HmOrdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_hm_ord, container, false);
        lst=(ListView) getView().findViewById(R.id.optionlist);
        options=new ArrayList<String>();
        opt=new ArrayAdapter<String>(getActivity(),android.R.layout.activity_list_item,options);
        lst.setAdapter(opt);
        options.add("Order");
        options.add("View Order");
        options.add("Setting");
        options.add("Complain");
   /*   lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s=opt.getItem(position);
                if (s.equalsIgnoreCase("Order")){
                    FragmentTransaction frg=getFragmentManager().beginTransaction();
                    frg.replace(R.id.frag_home,new OrderFragment()).commit();
                }
                else if (s.equalsIgnoreCase("View Order"))
                {
                    FragmentTransaction frg=getFragmentManager().beginTransaction();
                    frg.replace(R.id.frag_home,new receiptFragment()).commit();
                }

            }
        });*/
        return view;


    }

}
