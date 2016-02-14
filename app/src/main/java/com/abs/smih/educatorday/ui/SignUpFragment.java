package com.abs.smih.educatorday.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.abs.smih.educatorday.R;
import com.abs.smih.educatorday.dataManaging.DBParseUtils;
import com.abs.smih.educatorday.dataManaging.Teacher;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class SignUpFragment extends BaseFragment
{

    private EditText etFullName;
    private EditText etEmail;
    private EditText etPassw;
    private EditText etPassw2;
    private EditText etIdentity;
    private EditText etSchoolNum;
    private EditText etHomePhone;
    private EditText etCellPhone;
    private Button btnSignUp;
    private CheckBox chbxIsEducator;


    public SignUpFragment()
    {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_sign_up, container, false);
       initViews();

        return root;
    }

    private void dealSignUp()
    {
        if (validateAll())
        {
            String fullname=etFullName.getText().toString();
            final String username = etEmail.getText().toString().trim();
            final String password = etPassw.getText().toString().trim();
            String passwordAgain = etPassw2.getText().toString().trim();

            String identity=etIdentity.getText().toString().trim();
            String homephone=etHomePhone.getText().toString().trim();
            String cellphone=etCellPhone.getText().toString().trim();
            String schoolnum=etSchoolNum.getText().toString().trim();
            boolean isEducator=chbxIsEducator.isChecked();
//            final boolean toKeep = chbxKeepSignin.isChecked();
//            ParseUser user = new ParseUser();
//            user.setUsername(username);
//            user.setEmail(username);
//            user.setPassword(password);
//            user.put("identity", identity);
//            user.put("cellpone", cellphone);
//            user.put("homephone", homephone);
//            user.put("schoolnum",schoolnum);
            Teacher user=new Teacher(fullname,username,password,identity,homephone,cellphone,schoolnum,isEducator);
            user.signUpInBackground(new SignUpCallback()
            {
                @Override
                public void done(ParseException e)
                {
                    if (e != null)
                    {

                        // Show the error message
                        Toast.makeText(weakContext.get(), e.getMessage(), Toast.LENGTH_LONG).show();
                    } else
                    {
                        //DBParseUtils.toKeepSignin(username, password, toKeep, weakContext.get());


                        Toast.makeText(weakContext.get(), "sign up successfully", Toast.LENGTH_LONG).show();

                    }
                }
            });


        }
    }

    private boolean validateAll()
    {
        return true;
    }


//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        try {
//            if(activity!=null) this.activity=activity;
//            if(activity instanceof OnFragmentInteractionListener)
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }


    @Override
    protected void initViews()
    {
        etFullName=(EditText)findViewById(R.id.etFullName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassw = (EditText) findViewById(R.id.etPassw);
        etPassw2 = (EditText) findViewById(R.id.etPassw2);
        etIdentity = (EditText) findViewById(R.id.etIdentity);
        etSchoolNum = (EditText) findViewById(R.id.etShoolNum);
        etHomePhone = (EditText) findViewById(R.id.etHomePhone);
        etCellPhone = (EditText) findViewById(R.id.etCellPhone);
        chbxIsEducator = (CheckBox) findViewById(R.id.chbxIsEducator);
        btnSignUp = (Button) findViewById(R.id.btnSignupSave);
        setListeners();

    }

    @Override
    protected void bindData()
    {

    }

    @Override
    protected void setListeners()
    {
        btnSignUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dealSignUp();
            }
        });
    }


}
