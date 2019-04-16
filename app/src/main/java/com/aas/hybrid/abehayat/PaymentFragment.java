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
public class PaymentFragment extends Fragment {


    public PaymentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view5=inflater.inflate(R.layout.fragment_payment, container, false);
        Button btnregfrag=(Button)view5.findViewById(R.id.contpayment);

        btnregfrag.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              FragmentTransaction frag=getFragmentManager().beginTransaction();
                                              frag.replace(R.id.frag_home,new FinalPaymentFragment()).addToBackStack(null).commit();
                                          }
                                      }
        );
        return view5;
    }

}
