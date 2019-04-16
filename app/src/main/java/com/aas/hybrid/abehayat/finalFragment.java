package com.aas.hybrid.abehayat;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class finalFragment extends Fragment {


    public finalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view7=inflater.inflate(R.layout.fragment_final, container, false);
        Button btn=(Button)view7.findViewById(R.id.lgout);

        btn.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              FragmentTransaction frag=getFragmentManager().beginTransaction();
                                              frag.replace(R.id.frag_home,new HomeFragment()).commit();
                                          }
                                      }
        );
        btn=(Button)view7.findViewById(R.id.neworder);
        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       FragmentTransaction frag=getFragmentManager().beginTransaction();
                                       frag.replace(R.id.frag_home,new OrderFragment()).commit();
                                   }
                               }
        );

        btn=(Button)view7.findViewById(R.id.cancelORDER);
        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       FragmentTransaction frag=getFragmentManager().beginTransaction();
                                       frag.replace(R.id.frag_home,new OrderFragment()).addToBackStack(null).commit();
                                   }
                               }
        );

        return view7;

    }

}
