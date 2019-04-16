package com.aas.hybrid.abehayat;



import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegFragment extends Fragment {
    private Button regconbtn, btndisfrag;
    EditText id, Name, Phone, Address, Email, Password;
    public RegFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reg, container, false);

        regconbtn = view.findViewById(R.id.confirmButton);


        id = view.findViewById(R.id.cusmId);
        Name = view.findViewById(R.id.name);
        Phone = view.findViewById(R.id.phnum);
        Address = view.findViewById(R.id.address);
        Email = view.findViewById(R.id.eml);
        Password=view.findViewById(R.id.passwrd);

        regconbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String csid= id.getText().toString();
                String nm = Name.getText().toString();
                String ph = Phone.getText().toString();
                String add = Address.getText().toString();
                String emil = Email.getText().toString();
                String pw = Password.getText().toString();

                DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
                SQLiteDatabase database = databaseHelper.getWritableDatabase();
                databaseHelper.addcustomer(csid, nm, ph, add, emil, pw, database);
                DispCusInfo dispCusInfo=new DispCusInfo();
                dispCusInfo.display(csid, nm, ph, add, emil, pw);
                databaseHelper.close();
                id.setText("");
                Name.setText("");
                Phone.setText("");
                Address.setText("");
                Email.setText("");
                Password.setText("");
                Toast.makeText(getActivity(), "Customer saved successfully", Toast.LENGTH_SHORT).show();

                MainActivity.fragmentManager.beginTransaction().replace(R.id.frag_home,new BlankFragment(),null).addToBackStack(null).commit();




            }
        });



        return view;
    }

}

