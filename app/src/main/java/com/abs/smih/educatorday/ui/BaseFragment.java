package com.abs.smih.educatorday.ui;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;

import java.lang.ref.WeakReference;

/**
 * Created by ward on 6/20/2015.
 */
public abstract class BaseFragment extends Fragment {

    protected View root;
    protected WeakReference<Activity> weakContext;
    public interface FragmentInterActions{
        void backPressed(Fragment fragment);
    }

    protected FragmentInterActions fragmentInterActions;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.weakContext =new WeakReference<Activity>(activity);
    }



    protected View findViewById( int id ){
        if(root==null)return null;
        return root.findViewById(id);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.weakContext.clear();
        this.weakContext=null;
    }

    public FragmentInterActions getFragmentInterActions() {
        return fragmentInterActions;
    }

    public void setFragmentInterActions(FragmentInterActions fragmentInterActions) {
        this.fragmentInterActions = fragmentInterActions;
    }

    protected abstract void initViews();
    protected abstract void bindData();
    protected abstract void setListeners();
}
