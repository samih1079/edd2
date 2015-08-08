package com.abs.smih.educatorday.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.Window;

import java.lang.ref.WeakReference;

/**
 * Created by ward on 6/25/2015.
 */
public  class BaseDialogFragment extends DialogFragment {
    protected View root;
    protected WeakReference<Activity> weakContext;
  
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


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }
}
