package uvote.app.raghav.com.uvote;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Chirag on 10-Apr-17.
 */

public class survey {
    ImageView iv;
    TextView tv;
    Button yes;
    Button no;

    public ImageView getIv() {
        return iv;
    }

    public void setIv(ImageView iv) {
        this.iv = iv;
    }

    public TextView getTv() {
        return tv;
    }

    public void setTv(TextView tv) {
        this.tv = tv;
    }

    public Button getYes() {
        return yes;
    }

    public void setYes(Button yes) {
        this.yes = yes;
    }

    public Button getNo() {
        return no;
    }

    public void setNo(Button no) {
        this.no = no;
    }

    public survey(ImageView iv, TextView tv, Button yes, Button no) {
        this.iv = iv;
        this.tv = tv;
        this.yes = yes;
        this.no = no;
    }
}
