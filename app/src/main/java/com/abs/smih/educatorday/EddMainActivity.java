package com.abs.smih.educatorday;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.abs.smih.educatorday.ui.AddStudentFragment;
import com.abs.smih.educatorday.ui.LogIn_LogUPFragment;
import com.abs.smih.educatorday.ui.SigninFragment;
import com.abs.smih.educatorday.ui.StudentListFragment;
import com.abs.smih.educatorday.ui.TestStudsListFragment;
import com.abs.smih.educatorday.ui.TestingFragment;
import com.parse.ParseUser;

public class EddMainActivity extends AppCompatActivity {


//    private SigninFragment signinFragment;
    private StudentListFragment studentListFragment;
    private LogIn_LogUPFragment logIn_logUPFragment;
    private AddStudentFragment addStudentFragment;
    private TestingFragment testingFragment;
    private TestStudsListFragment testStudsListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edd_main);
        //check if the user keeping  logged in
        if (ParseUser.getCurrentUser() != null && ParseUser.getCurrentUser().getUsername() != null) {
            //goToStudentListFragment();
           // goAddStudentFragment();
           // goToTestingFragment();
            goToTestStudsListFragment();
        } else {
           goToLogIn_LogUPFragment();
        }

    }

    private void goToTestStudsListFragment()
    {
        if (testStudsListFragment == null)
            testStudsListFragment = new TestStudsListFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.main_frame, testStudsListFragment, TestStudsListFragment.class.getName());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    public void goToLogIn_LogUPFragment() {
        if (logIn_logUPFragment == null)
            logIn_logUPFragment = new LogIn_LogUPFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.main_frame, logIn_logUPFragment, LogIn_LogUPFragment.class.getName());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        // signinFragment.show(getFragmentManager(),"signin");
    }
    public void goAddStudentFragment() {
        if (addStudentFragment == null)
            addStudentFragment = new AddStudentFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.main_frame, addStudentFragment, AddStudentFragment.class.getName());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        // signinFragment.show(getFragmentManager(),"signin");
    }

    public void goToStudentListFragment2() {
        if (studentListFragment == null)
            studentListFragment = new StudentListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.main_frame, studentListFragment, StudentListFragment.class.getName());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
    public void goToTestingFragment() {
        if (testingFragment == null)
            testingFragment = new TestingFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.main_frame, testingFragment, TestingFragment.class.getName());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
//    public void goFromToTestingFragment() {
//        if (testingFragment == null)
//            testingFragment = new TestingFragment();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        fragmentTransaction.replace(R.id.main_frame, testingFragment, TestingFragment.class.getName());
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        fragmentTransaction.commit();
//    }
//    public void goToSignUPFragment()
//    {
//        Toast.makeText(this, "SignUpFragment", Toast.LENGTH_LONG).show();
//        SignUpFragment signUpFragment=new SignUpFragment();
//        signUpFragment.show(getFragmentManager(),SignUpFragment.class.getName());
//    }
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

                goToLogIn_LogUPFragment();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
