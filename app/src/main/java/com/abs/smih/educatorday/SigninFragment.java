package com.abs.smih.educatorday;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.abs.smih.educatorday.dataManaging.DBParseUtils;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SigninFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SigninFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SigninFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Activity activity;
    private EditText etEmail;
    private EditText etPassw;
    private Button btnSignin,btnSignUp;
    private CheckBox chbxKeepSignin;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SigninFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SigninFragment newInstance(String param1, String param2) {
        SigninFragment fragment = new SigninFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public SigninFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_signin, container, false);
        etEmail= (EditText) view.findViewById(R.id.etEmail);
        etPassw= (EditText) view.findViewById(R.id.etPassw);
        chbxKeepSignin=(CheckBox)view.findViewById(R.id.chbxKeepSignin);
        btnSignin= (Button) view.findViewById(R.id.btnSignin);
        dealSingin();
        btnSignUp=(Button) view.findViewById(R.id.btnSignup);
        dealSignUp();

        return view;
    }
    private void dealSingin()
    {
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logInInBackground(etEmail.getText().toString(), etPassw.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if (e == null && parseUser != null) {
                            Log.d("SS", "signd in");
                            Toast.makeText(activity, "signed in", Toast.LENGTH_LONG).show();
                          //  ((EddApplication) activity.getApplication()).toKeepSignin(etEmail.getText().toString(), etPassw.getText().toString(),chbxKeepSignin.isChecked());
                            DBParseUtils.toKeepSignin(etEmail.getText().toString(), etPassw.getText().toString(), chbxKeepSignin.isChecked(), activity);
                            ((EddMainActivity)activity).goToStudentListFragment();
                        } else if (parseUser == null) {
                            //usernameOrPasswordIsInvalid();
                            Log.d("SS", "Invalid");
                            Toast.makeText(getActivity(), "Invalid", Toast.LENGTH_LONG).show();
                        } else {
                            // somethingWentWrong();
                            Log.d("SS", "somethingWentWrong");
                            Toast.makeText(activity, "somethingWentWrong", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });
    }



    private void dealSignUp()
    {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getFragmentManager().findFragmentByTag("signin")
                ((EddMainActivity)activity).goToSignUPFragment();
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity!=null)
            this.activity =activity;
        try {

            if(activity instanceof OnFragmentInteractionListener)
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        activity =null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
