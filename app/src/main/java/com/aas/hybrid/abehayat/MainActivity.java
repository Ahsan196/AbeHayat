package com.aas.hybrid.abehayat;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.aas.hybrid.abehayat.*;
public class MainActivity extends AppCompatActivity implements HomeFragment.OnDbOpListener, BlankFragment.DatabOpListener{
    public static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

fragmentManager =getSupportFragmentManager();
        if(findViewById(R.id.frag_home)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            HomeFragment homefragment=new HomeFragment();
          fragmentTransaction.add(R.id.frag_home,homefragment,null);
            fragmentTransaction.addToBackStack(null).commit();
        }
    }


    @Override
    public void dbOpPerformed(int method) {

        switch (method)
        {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_home,new RegFragment()).addToBackStack(null).commit();
                break;
        }
    }

    public void databOpPerformed(int method) {

        switch (method)
        {
            case 0:

                getSupportFragmentManager().beginTransaction().replace(R.id.frag_home,new DispCusInfo()).addToBackStack(null).commit();

                break;

            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_home,new OrderFragment()).addToBackStack(null).commit();
        }
    }




}
