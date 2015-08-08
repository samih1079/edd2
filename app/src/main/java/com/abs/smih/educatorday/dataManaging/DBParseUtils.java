package com.abs.smih.educatorday.dataManaging;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by smih on 04/08/2015.
 */
public class DBParseUtils {
    //params to save offline keep signed up, using default dhared preferences
    public final static  String USER_MAIL="email";
    public final static  String PASSW="passw";
    public final static  String KEEP_SIGNIN="keepsignin";
    /**
     * to call from th Application class of the application
     * @param application
     */
    public static void initConnectionFromApp(Application application)
    {
        // Initialize Crash Reporting.
        //  ParseCrashReporting.enable(this);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(application);

        // Add your initialization code here
        //the keys from your  App at Parse.com
        Parse.initialize(application, "Fe3VmVYVd1JkQWHcvwA2acI91W4yB8YKoPx5VjSu", "GBoIzKW0037wFJgOggjqFxAAXXz3vEEy0IJwoLyw");
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }

    /**
     * save sign in data i order to use in keeping signed in status
     * @param user
     * @param passw
     * @param toKeep
     * @param context
     */
    public static void toKeepSignin(String user,String passw, boolean toKeep,Context context)
    {
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        if(toKeep)
        {
            editor.putString(USER_MAIL, user);
            editor.putString(PASSW, passw);
            editor.putBoolean(KEEP_SIGNIN, toKeep);
        }
        else
        {
            editor.clear();
            editor.putBoolean(KEEP_SIGNIN, toKeep);
        }
        editor.commit();
    }
}
