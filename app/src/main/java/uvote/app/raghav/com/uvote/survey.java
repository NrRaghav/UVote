package uvote.app.raghav.com.uvote;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Chirag on 10-Apr-17.
 */

public class survey {
    String picture;
    String description;
 HashMap<String,String>votes;
    String sid;

    public HashMap<String, String> getVotes() {
        return votes;
    }

    public void setVotes(HashMap<String, String> votes) {
        this.votes = votes;
    }

    public survey(String picture, String description, HashMap<String, String> votes, String sid) {
        this.picture = picture;
        this.description = description;
        this.votes = votes;
        this.sid = sid;
    }

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


    public survey()
    {}

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
