package startup.excited.salon;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMDMajid on 7/21/2015.
 */

public class DataObject {
    protected String storename;
    protected String address;
    protected String rating;
    protected String services;
    protected String location;

    DataObject (String text1, String text2, String rating,String services,String location){
        storename = text1;
        address = text2;
        this.rating=rating;
        this.services=services;

        this.location=location;
    }

   /* public String getmText1() {
        return mText1;
    }

    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }

    public String getmText2() {
        return mText2;
    }

    public void setmText2(String mText2) {
        this.mText2 = mText2;
    }*/
}

