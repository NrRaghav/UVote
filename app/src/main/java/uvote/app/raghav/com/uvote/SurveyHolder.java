package uvote.app.raghav.com.uvote;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import uvote.app.raghav.com.uvote.uvote.R;

/**
 * Created by Chirag on 10-Apr-17.
 */

public class SurveyHolder extends RecyclerView.ViewHolder {
    final ImageView iv;
    final TextView tv;
    final Button yes;
    final Button no;
    public SurveyHolder(View itemView) {
        super(itemView);
        iv = (ImageView)itemView.findViewById(R.id.iv);
        tv = (TextView)itemView.findViewById(R.id.tv);
        yes =(Button)itemView.findViewById(R.id.yes);
        no = (Button)itemView.findViewById(R.id.no);
    }
}
