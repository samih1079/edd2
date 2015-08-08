package com.abs.smih.educatorday;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.abs.smih.educatorday.dataManaging.DBParseUtils;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by smih on 04/08/2015.
 */
public class EddApplication extends Application {





    @Override
    public void onCreate() {
        super.onCreate();

        DBParseUtils.initConnectionFromApp(this);
    }


}
