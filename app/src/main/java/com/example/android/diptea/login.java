package com.example.android.diptea;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;


public class login extends ActionBarActivity implements DialogInterface.OnClickListener{

    EditText sqlEmail,sqlPwd;
    Button sqlSignup,sqlFB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sqlEmail=(EditText)findViewById(R.id.email);
        sqlPwd=(EditText)findViewById(R.id.pwd);
        sqlSignup=(Button)findViewById(R.id.btnSignup);
        sqlFB=(Button)findViewById(R.id.btnFB);
        sqlSignup.setOnClickListener((View.OnClickListener) this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    //This function has to be modified later
    public void onClick(View arg0) {
        switch (arg0.getId()){
            //if signup button is clicked
            //Checks if email is already registered Else adds to the database
            case R.id.btnSignup:
                String email=sqlEmail.getText().toString();
                String password=sqlPwd.getText().toString();
                AddSignupData entry=new AddSignupData(login.this);
                entry.open();
                entry.createEntry(email,password);

                entry.close();

                break;

            //Login through facebook
            //Use plugin from FB
            case R.id.btnFB:


                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_login, container, false);
            return rootView;
        }
    }
}
