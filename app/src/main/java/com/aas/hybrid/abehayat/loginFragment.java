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
public class loginFragment extends Fragment {


    public loginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_login, container, false);
        Button bt=(Button)view.findViewById(R.id.login2);
        bt.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               FragmentTransaction frg=getFragmentManager().beginTransaction();
                                               frg.replace(R.id.frag_home,new HmOrdFragment()).addToBackStack(null).commit();
                                           }
                                       }
        );
        return  view;
    }

}
