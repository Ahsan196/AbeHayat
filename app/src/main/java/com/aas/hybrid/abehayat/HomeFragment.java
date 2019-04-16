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
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button button;
    OnDbOpListener dbOpListener;
    public HomeFragment() {
        // Required empty public constructor
    }
    public interface OnDbOpListener
    {
        public void dbOpPerformed(int method);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        button = view.findViewById(R.id.registerbutton);
        button.setOnClickListener(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frag_home,new RegFragment(),null).addToBackStack(null).commit();
            }
        });
        return view;

    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.registerbutton:
                dbOpListener.dbOpPerformed(0);
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            dbOpListener = (OnDbOpListener) activity;
        }
        catch (ClassCastException e)
        {
            throw  new ClassCastException(activity.toString()+" must implement the interface method");
        }
    }
}