package com.abs.smih.educatorday.ui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.abs.smih.educatorday.R;
import com.abs.smih.educatorday.dataManaging.Student;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddStudentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class AddStudentFragment extends BaseFragment
{



    private Activity activity;
    private Button btnSave,btnLoad;
    private TextView tvResult;
    private Student s;


    public AddStudentFragment()
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
        root=inflater.inflate(R.layout.fragment_add_student, container, false);
       initViews();

        return root;
    }


    @Override
    protected void initViews()
    {
//        btnLoad=(Button)findViewById(R.id.btnLoad);
//        btnSave=(Button)findViewById(R.id.btnSave);
//        tvResult=(TextView)findViewById(R.id.tvResult);

        setListeners();
    }

    @Override
    protected void bindData()
    {

    }

    @Override
    protected void setListeners()
    {

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
    public interface OnFragmentInteractionListener
    {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
