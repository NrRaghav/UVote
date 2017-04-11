package uvote.app.raghav.com.uvote;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Chirag on 10-Apr-17.
 */

public class survey {
    String picture;
    String description;
    ArrayList<String> yes;
    ArrayList<String> no;
    String sid;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getYes() {
        return yes;
    }

    public void setYes(ArrayList<String> yes) {
        this.yes = yes;
    }

    public ArrayList<String> getNo() {
        return no;
    }

    public void setNo(ArrayList<String> no) {
        this.no = no;
    }



    public survey(String picture, String description, ArrayList<String> yes, ArrayList<String> no, String sid) {
        this.picture = picture;
        this.description = description;
        this.yes = yes;
        this.no = no;
        this.sid = sid;
    }

    public survey()
    {}

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
