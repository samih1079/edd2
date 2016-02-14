package com.abs.smih.educatorday.dataManaging;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by smih on 04/08/2015.
 */
@ParseClassName("Student")
public class Student extends ParseObject
{
    private String fname, lname, identity, father, mother;
    private String stPhone, faPhone, maPhone, homePhone,comment,email;
   // private int sendTo;//1=st 2=fa 3=ma 4=other 12=st+fa 23=fa+ma
//TODO student birthday
    //Date birthDay;
    private ParseUser educator;//connection to the educator


    public Student()
    {
        super();
    }

    public Student(String fname, String lname, String identity, String father, String mother, String stPhone, String faPhone, String maPhone, String homePhone,String email, String comment,ParseUser educator)
    {

        this.fname = fname;setFname(fname);
        this.lname = lname;setLname(lname);
        this.identity = identity;setIdentity(identity);
        this.father = father;setFather(father);
        this.mother = mother;setMother(mother);
        this.stPhone = stPhone;setStPhone(stPhone);
        this.faPhone = faPhone;setFaPhone(faPhone);
        this.maPhone = maPhone;setMaPhone(maPhone);
        this.homePhone = homePhone;setHomePhone(homePhone);
      //  this.sendTo = sendTo;setSendTo(sendTo);
        this.educator=educator;setEducator(educator);
        this.comment=comment;setComment(comment);
        this.email=email;setEmail(email);

    }

    public void setEmail(String email)
    {
        put("email",email);
        this.email = email;
    }

    public String getEmail()
    {
        email=getString("email");
        return email;
    }

    public String getFname()
    {
        fname=getString("fname");
        return fname;
    }

    public void setFname(String fname)
    {
        put("fname",fname);
        this.fname = fname;
    }

    public String getLname()
    {
        lname=getString("lname");
        return lname;
    }

    public void setLname(String lname)
    {
        put("lname",lname);
        this.lname = lname;
    }

    public String getIdentity()
    {
        identity=getString("identity");
        return identity;
    }

    public void setIdentity(String identity)
    {
        put("identity",identity);
        this.identity = identity;
    }

    public String getFather()
    {
        father=getString("father");
        return father;
    }

    public void setFather(String father)
    {
        put("father",father);
        this.father = father;
    }

    public String getMother()
    {
        mother=getString("mother");
        return mother;
    }

    public void setMother(String mother)
    {
        put("mother",mother);
        this.mother = mother;
    }

    public String getStPhone()
    {
        stPhone=getString("stPhone");
        return stPhone;
    }

    public void setStPhone(String stPhone)
    {
        put("stPhone",stPhone);
        this.stPhone = stPhone;
    }

    public String getFaPhone()
    {
        faPhone=getString(faPhone);
        return faPhone;
    }

    public void setFaPhone(String faPhone)
    {
        put("faPhone",faPhone);
        this.faPhone = faPhone;
    }

    public String getMaPhone()
    {
        maPhone=getString("maPhone");
        return maPhone;
    }

    public void setMaPhone(String maPhone)
    {
        put("maPhone",maPhone);
        this.maPhone = maPhone;
    }

    public String getHomePhone()
    {
        homePhone =getString("homePhone");
        return homePhone;
    }

    public void setHomePhone(String homePhone)
    {
        put("homePhone", homePhone);
        this.homePhone = homePhone;
    }

//    public int getSendTo()
//    {
//        sendTo=getInt("sendTo");
//        return sendTo;
//    }

//    public void setSendTo(int sendTo)
//    {
//        put("sendTo",sendTo);
//        this.sendTo = sendTo;
//    }

    public void setEducator(ParseUser educator)
    {
        put("educatorid",educator);
        this.educator = educator;
    }

    public void setComment(String comment)
    {
        put("comment",comment);
        this.comment = comment;
    }

    public String getComment()
    {
        comment=getString("comment");
        return comment;
    }

    public ParseUser getEducator()
    {
        educator= (ParseUser) getParseObject("educatorid");
        return educator;
    }
    //    public void setTeacher(Teacher teacher)
//    {
//        myObject.put("user", ParseUser.getCurrentUser());
//    }
//    public void saveAsParseObject()
//    {
//        if (myObject == null)
//        {
//            myObject = new ParseObject(this.getClass().getSimpleName());//table name
//            Log.d("st", "saveAsParseObject after new+ " + myObject.getObjectId());
//        } else
//        {
//            myObject.setObjectId(myObject.getObjectId());
//            Log.d("st", "saveAsParseObject in else+ " + myObject.getObjectId());
//        }
//        myObject.put("fname", fname);
//        myObject.put("lname", lname);
//        myObject.put("identity", identity);
//        myObject.put("father", father);
//        myObject.put("mother", mother);
//        myObject.put("stPhone", stPhone);
//        myObject.put("faPhone", faPhone);
//        myObject.put("maPhone", maPhone);
//        myObject.put("homePhone", homePhone);
//        myObject.put("sendTo", sendTo);
//
//        myObject.put("user", ParseUser.getCurrentUser());
//
//        myObject.put("eventid",ParseObject.createWithoutData("event","4UjsFTpKao") );
//
//        myObject.saveInBackground(new SaveCallback()
//        {
//            @Override
//            public void done(ParseException e)
//            {
//                if (e == null) Log.d("st", "Saved:" + myObject.getObjectId());
//
//                else
//                {
//                    Log.d("st", "not Saved" + e.getMessage());
//                    e.printStackTrace();
//                }
//
//            }
//        });
//    }
//
//    public void updateByObjectId(String objectId)
//    {
//        if (myObject == null)
//        {
//            myObject = new ParseObject(this.getClass().getSimpleName());//table name
//
//        }
//
//        myObject.setObjectId(objectId);
//
//
//        myObject.put("fname", fname);
//        myObject.put("lname", lname);
//        myObject.put("identity", identity);
//        myObject.put("father", father);
//        myObject.put("mother", mother);
//        myObject.put("stPhone", stPhone);
//        myObject.put("faPhone", faPhone);
//        myObject.put("maPhone", maPhone);
//        myObject.put("homePhone", homePhone);
//        myObject.put("sendTo", sendTo);
//
//        myObject.put("user", ParseUser.getCurrentUser());
//
//        myObject.saveInBackground(new SaveCallback()
//        {
//            @Override
//            public void done(ParseException e)
//            {
//                if (e == null) Log.d("st", "Saved:" + myObject.getObjectId());
//
//                else
//                {
//                    Log.d("st", "not Saved" + e.getMessage());
//                    e.printStackTrace();
//                }
//
//            }
//        });
//    }
//
//    public void loadParseObject(final String objId)
//    {
//
//
//        ParseQuery<ParseObject> query = ParseQuery.getQuery(this.getClass().getSimpleName());
//        query.getInBackground(objId, new GetCallback<ParseObject>()
//        {
//            public void done(ParseObject object, ParseException e)
//            {
//                if (object != null && e == null)
//                {
//                    Student.this.objectId = objId;
//                    myObject = object;
//                    Log.d("st", "loadParseObject");
//                    setFieldsFromParseObj(myObject);
//                } else
//                {
//                    Log.d("st", "not....loadParseObject");
//                    e.printStackTrace();
//                    // something went wrong
//                }
//            }
//        });
//
//    }
//
//    private void setFieldsFromParseObj(ParseObject object)
//    {
//        this.myObject = object;
//
//        this.fname = myObject.getString("fname");
//        this.lname = myObject.getString("lname");
//        this.identity = myObject.getString("identity");
//        this.father = myObject.getString("father");
//        this.mother = myObject.getString("mother");
//        this.stPhone = myObject.getString("stPhone");
//        this.faPhone = myObject.getString("faPhone");
//        this.maPhone = myObject.getString("maPhone");
//        this.homePhone = myObject.getString("homePhone");
//        this.sendTo = myObject.getInt("sendTo");
//
//        Log.d("st", "setFieldsFromParseObj " + this.toString());
//
//    }


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
                ", homePhone='" + homePhone + '\'' +
                ", comment='" + comment + '\'' +
                ", email='" + email + '\'' +
                ", educator=" + educator +
                '}';
    }
}
