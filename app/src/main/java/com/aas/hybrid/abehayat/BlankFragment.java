package com.aas.hybrid.abehayat;


import android.app.Activity;
import android.content.Context;
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
public class BlankFragment extends Fragment implements View.OnClickListener{

  private Button vie,ORdER;
    DatabOpListener databOpListener;

    public BlankFragment() {
        // Required empty public constructor
    }
    public interface DatabOpListener
    {
        public void databOpPerformed(int method);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=   inflater.inflate(R.layout.fragment_blank, container, false);
      ORdER=view.findViewById(R.id.or_der);
      vie=view.findViewById(R.id.view_info);
        // Inflate the layout for this fragment
        vie.setOnClickListener(this);

        vie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frag_home,new DispCusInfo(),null).addToBackStack(null).commit();
            }
        });
        ORdER.setOnClickListener(this);

        ORdER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                        MainActivity.fragmentManager.beginTransaction().replace(R.id.frag_home,new OrderFragment(),null).addToBackStack(null).commit();
            }
        });


        return view;
    }
    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.view_info:
                databOpListener.databOpPerformed(0);
                break;
            case R.id.or_der:
                databOpListener.databOpPerformed(1);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            databOpListener = (BlankFragment.DatabOpListener) activity;
        }
        catch (ClassCastException e)
        {
            throw  new ClassCastException(activity.toString()+" must implement the interface method");
        }
    }
}
