package com.abs.smih.educatorday.dataManaging;

import android.util.Log;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

/**
 * Created by smih on 04/08/2015.
 */
public class Student
{
    private String fname, lname, identity, father, mother;
    private String stPhone, faPhone, maPhone, otherPhone;
    private int sendTo;//1=st 2=fa 3=ma 4=other 12=st+fa 23=fa+ma
    private ParseObject myObject;
    private String objectId;

//    public final static String CLASS_TBL= "student";
//
//    public final static String fa_phone="fa_phone";
//    public final static String father_F="father";
//    public final static String fname_F="fname";
//    public final static String grade="grade";
//    public final static String identity_F="identity";
//    public final static String lname_F="lname";
//    public final static String ma_phone="ma_phone";
//
//    public final static String mother_F="mother";
//    public final static String objectId="objectId";
//    public final static String other_phone="other_phone";
//    public final static String sendto="sendto";
//    public final static String st_phone="st_phone";
//
//    public final static String userId="userId"; //pointer to user table


    public Student(String fname, String lname, String identity, String father, String mother, String stPhone, String faPhone, String maPhone, String otherPhone, int sendTo)
    {
        this.fname = fname;
        this.lname = lname;
        this.identity = identity;
        this.father = father;
        this.mother = mother;
        this.stPhone = stPhone;
        this.faPhone = faPhone;
        this.maPhone = maPhone;
        this.otherPhone = otherPhone;
        this.sendTo = sendTo;
    }

    public Student()
    {
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public String getIdentity()
    {
        return identity;
    }

    public void setIdentity(String identity)
    {
        this.identity = identity;
    }

    public String getFather()
    {
        return father;
    }

    public void setFather(String father)
    {
        this.father = father;
    }

    public String getMother()
    {
        return mother;
    }

    public void setMother(String mother)
    {
        this.mother = mother;
    }

    public String getStPhone()
    {
        return stPhone;
    }

    public void setStPhone(String stPhone)
    {
        this.stPhone = stPhone;
    }

    public String getFaPhone()
    {
        return faPhone;
    }

    public void setFaPhone(String faPhone)
    {
        this.faPhone = faPhone;
    }

    public String getMaPhone()
    {
        return maPhone;
    }

    public void setMaPhone(String maPhone)
    {
        this.maPhone = maPhone;
    }

    public String getOtherPhone()
    {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone)
    {
        this.otherPhone = otherPhone;
    }

    public int getSendTo()
    {
        return sendTo;
    }

    public void setSendTo(int sendTo)
    {
        this.sendTo = sendTo;
    }

    public void saveAsParseObject()
    {
        if (myObject == null)
        {
            myObject = new ParseObject(this.getClass().getSimpleName());//table name
            Log.d("st", "saveAsParseObject after new+ " + myObject.getObjectId());
        } else
        {
            myObject.setObjectId(myObject.getObjectId());
            Log.d("st", "saveAsParseObject in else+ " + myObject.getObjectId());
        }
        myObject.put("fname", fname);
        myObject.put("lname", lname);
        myObject.put("identity", identity);
        myObject.put("father", father);
        myObject.put("mother", mother);
        myObject.put("stPhone", stPhone);
        myObject.put("faPhone", faPhone);
        myObject.put("maPhone", maPhone);
        myObject.put("otherPhone", otherPhone);
        myObject.put("sendTo", sendTo);

        myObject.put("user", ParseUser.getCurrentUser());

        myObject.put("eventid",ParseObject.createWithoutData("event","4UjsFTpKao") );

        myObject.saveInBackground(new SaveCallback()
        {
            @Override
            public void done(ParseException e)
            {
                if (e == null) Log.d("st", "Saved:" + myObject.getObjectId());

                else
                {
                    Log.d("st", "not Saved" + e.getMessage());
                    e.printStackTrace();
                }

            }
        });
    }

    public void updateByObjectId(String objectId)
    {
        if (myObject == null)
        {
            myObject = new ParseObject(this.getClass().getSimpleName());//table name

        }

        myObject.setObjectId(objectId);


        myObject.put("fname", fname);
        myObject.put("lname", lname);
        myObject.put("identity", identity);
        myObject.put("father", father);
        myObject.put("mother", mother);
        myObject.put("stPhone", stPhone);
        myObject.put("faPhone", faPhone);
        myObject.put("maPhone", maPhone);
        myObject.put("otherPhone", otherPhone);
        myObject.put("sendTo", sendTo);

        myObject.put("user", ParseUser.getCurrentUser());

        myObject.saveInBackground(new SaveCallback()
        {
            @Override
            public void done(ParseException e)
            {
                if (e == null) Log.d("st", "Saved:" + myObject.getObjectId());

                else
                {
                    Log.d("st", "not Saved" + e.getMessage());
                    e.printStackTrace();
                }

            }
        });
    }

    public void loadParseObject(final String objId)
    {


        ParseQuery<ParseObject> query = ParseQuery.getQuery(this.getClass().getSimpleName());
        query.getInBackground(objId, new GetCallback<ParseObject>()
        {
            public void done(ParseObject object, ParseException e)
            {
                if (object != null && e == null)
                {
                    Student.this.objectId = objId;
                    myObject = object;
                    Log.d("st", "loadParseObject");
                    setFieldsFromParseObj(myObject);
                } else
                {
                    Log.d("st", "not....loadParseObject");
                    e.printStackTrace();
                    // something went wrong
                }
            }
        });

    }

    private void setFieldsFromParseObj(ParseObject object)
    {
        this.myObject = object;

        this.fname = myObject.getString("fname");
        this.lname = myObject.getString("lname");
        this.identity = myObject.getString("identity");
        this.father = myObject.getString("father");
        this.mother = myObject.getString("mother");
        this.stPhone = myObject.getString("stPhone");
        this.faPhone = myObject.getString("faPhone");
        this.maPhone = myObject.getString("maPhone");
        this.otherPhone = myObject.getString("otherPhone");
        this.sendTo = myObject.getInt("sendTo");

        Log.d("st", "setFieldsFromParseObj " + this.toString());

    }


    @Override
    public String toString()
    {
        return "Student{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", identity='" + identity + '\'' +
                ", father='" + father + '\'' +
                ", mother='" + mother + '\'' +
                ", stPhone='" + stPhone + '\'' +
                ", faPhone='" + faPhone + '\'' +
                ", maPhone='" + maPhone + '\'' +
                ", otherPhone='" + otherPhone + '\'' +
                ", sendTo=" + sendTo +
                '}';
    }
}
