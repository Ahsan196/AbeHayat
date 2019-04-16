package com.aas.hybrid.abehayat;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {

    private Button order1;
    EditText orderQuan,orderSize;

    public OrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view3=inflater.inflate(R.layout.fragment_order, container, false);
        order1=view3.findViewById(R.id.ordbutton);


        orderSize=view3.findViewById(R.id.szei);
        orderQuan=view3.findViewById(R.id.quantext);

        order1.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                             String siez=orderSize.getText().toString();
                                              String qan=orderQuan.getText().toString();

                                              DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
                                              SQLiteDatabase database = databaseHelper.getWritableDatabase();

                                              databaseHelper.placeOder(Integer.parseInt(qan),siez,database);
                                              databaseHelper.close();

                                              orderSize.setText("");
                                              orderQuan.setText("");
                                              Toast.makeText(getActivity(),"Order placed Successfully",Toast.LENGTH_SHORT).show();
                                              MainActivity.fragmentManager.beginTransaction().replace(R.id.frag_home,new receiptFragment(),null).addToBackStack(null).commit();

                                          }
                                      }
        );
        return view3;
    }


}
