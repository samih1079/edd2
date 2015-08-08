package com.abs.smih.educatorday;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abs.smih.educatorday.dataManaging.Student;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class EddMainActivity extends AppCompatActivity {


    private SigninFragment signinFragment;
    private StudentListFragment studentListFragment;
    private AddStudentFragment addStudentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edd_main);
        //check if the user keeping  logged in
        if (ParseUser.getCurrentUser() != null && ParseUser.getCurrentUser().getUsername() != null) {
            //goToStudentListFragment();
            goAddStudentFragment();
        } else {
           goToSignInUserFragment();
        }

    }

    public void goToSignInUserFragment() {
        if (signinFragment == null)
            signinFragment = new SigninFragment();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.main_frame, signinFragment, SigninFragment.class.getName());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        // signinFragment.show(getFragmentManager(),"signin");
    }
    public void goAddStudentFragment() {
        if (addStudentFragment == null)
            addStudentFragment = new AddStudentFragment();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.main_frame, addStudentFragment, SigninFragment.class.getName());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        // signinFragment.show(getFragmentManager(),"signin");
    }

    public void goToStudentListFragment() {
        if (studentListFragment == null)
            studentListFragment = new StudentListFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.main_frame, studentListFragment, StudentListFragment.class.getName());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
    public void goToSignUPFragment()
    {
        Toast.makeText(this, "SignUpFragment", Toast.LENGTH_LONG).show();
        SignUpFragment signUpFragment=new SignUpFragment();
        signUpFragment.show(getFragmentManager(),SignUpFragment.class.getName());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edd_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.logOut:
                ParseUser.logOut();

                goToSignInUserFragment();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
