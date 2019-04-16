package com.aas.hybrid.abehayat;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DispCusInfo extends Fragment {

    private TextView cusId, name, cphone, addrs, cemail, paswrd;

    public DispCusInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view2 = inflater.inflate(R.layout.fragment_disp_cus_info, container, false);

        cusId = view2.findViewById(R.id.cusmID);
        name = view2.findViewById(R.id.nameView);
        cphone = view2.findViewById(R.id.phNoView);
        addrs = view2.findViewById(R.id.addessView);
        cemail = view2.findViewById(R.id.emlView);
        paswrd = view2.findViewById(R.id.pswdView);
       // readcustmInfo();



        Button btndusfrag = (Button) view2.findViewById(R.id.orderbutton);

        btndusfrag.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              FragmentTransaction frgm = getFragmentManager().beginTransaction();
                                              frgm.replace(R.id.frag_home, new OrderFragment()).commit();
                                          }
                                      }
        );
        Button btn = (Button) view2.findViewById(R.id.edit);

        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       FragmentTransaction frag = getFragmentManager().beginTransaction();
                                       frag.replace(R.id.frag_home, new RegFragment()).commit();
                                   }
                               }
        );

        btn = (Button) view2.findViewById(R.id.logout);

        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       FragmentTransaction frag = getFragmentManager().beginTransaction();
                                       frag.replace(R.id.frag_home, new HomeFragment()).addToBackStack(null).commit();
                                   }
                               }
        );
        return view2;
    }

    public void readcustmInfo() {
        DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        Cursor cursor = databaseHelper.readcusmInfo(database);
        String idt="";
        String nme="";
        String pho="";
        String addres="";
        String emi="";
        String pa="";

        cursor.moveToPosition(cursor.getPosition());

        String id = cursor.getString(cursor.getColumnIndex(customerInformation.custm.CUSTOMER_ID));
        String cusmname = cursor.getString(cursor.getColumnIndex(customerInformation.custm.CUSTOMER_NAME));
        String cusmphn = cursor.getString(cursor.getColumnIndex(customerInformation.custm.CUSTOMER_PHONE));
        String cusmadrs = cursor.getString(cursor.getColumnIndex(customerInformation.custm.CUSTOMER_ADDRESS));
        String cusmemil = cursor.getString(cursor.getColumnIndex(customerInformation.custm.CUSTOMER_EMAIL));
        String cusmpawsd = cursor.getString(cursor.getColumnIndex(customerInformation.custm.CUSTOMER_PASSWORD));

       cusId.setText(id);
        name.setText(cusmname);
        cphone.setText(cusmphn);
        addrs.setText(cusmadrs);
        cemail.setText(cusmemil);
        paswrd.setText(cusmpawsd);

        databaseHelper.close();

    }


    public void display(String id, String nam, String phone, String address, String email, String password)
    {
       // cusId.setText(id);
        name.setText(nam);
        cphone.setText(phone);
        addrs.setText(address);
        cemail.setText(email);
        paswrd.setText(password);
    }

}
